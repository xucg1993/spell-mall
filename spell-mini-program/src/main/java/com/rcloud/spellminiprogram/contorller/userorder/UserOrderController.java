package com.rcloud.spellminiprogram.contorller.userorder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.rcloud.spellcommon.common.ArgsUtils;
import com.rcloud.spellcommon.common.exception.ArgsException;
import com.rcloud.spellentity.entity.goods.GoodsEntity;
import com.rcloud.spellentity.entity.ordergoods.OrderGoodsEntity;
import com.rcloud.spellentity.entity.user.UserEntity;
import com.rcloud.spellentity.entity.userorder.UserOrderEntity;
import com.rcloud.spellminiprogram.common.annotation.CheckLogin;
import com.rcloud.spellminiprogram.contorller.BaseController;
import com.rcloud.spellminiprogram.service.interfaces.ordergoods.OrderGoodsService;
import com.rcloud.spellminiprogram.service.interfaces.userorder.UserOrderService;
import com.rcloud.spellutils.utils.BaseUtils;
import com.rcloud.spellutils.utils.QrCodeUtil;
import com.rcloud.spellutils.utils.ResultJson;
import com.rcloud.spellutils.utils.WXMiniProgramUtils;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.xucg.model.WxPayPrePayModel;
import com.xucg.pay.WxPay;
import com.xucg.util.wx.WxFormatParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.List;

/**
 * 订单
 *
 * @author xuchenguang
 * @since 2019.01.07
 */
@RestController
public class UserOrderController extends BaseController {

    @Autowired
    protected UserOrderService userOrderService;

    @Autowired
    protected OrderGoodsService orderGoodsService;

    public static final String CONTROLLER_NAME = "userOrder";

    @Autowired
    WxPay wxPay;

    /**
     * 用户下单
     *
     * @param entity
     * @return
     */
    @CheckLogin
    @PostMapping(CONTROLLER_NAME)
    @Transactional(rollbackFor = Exception.class)
    public String save(UserOrderEntity entity) throws ArgsException {

        entity.setOrderId(BaseUtils.generateElevenNum());
        entity.setOrderCode(BaseUtils.generateRandomNum());

        ArgsUtils.checkObj(entity, new String[]{"teamId", "payType", "orderGoodsList"});

        entity.setUserId(userService.findUserIdByToken());

        //处理订单内商品
        List<OrderGoodsEntity> orderGoodsEntityList = JSONArray.parseArray(entity.getOrderGoodsList(), OrderGoodsEntity.class);

        //购买的商品
        List<OrderGoodsEntity> goodsEntityList = new ArrayList<>();
        //订单金额
        Integer orderAmount = 0;
        //支付金额
        Integer payAmount = 0;
        //提成
        Integer colonel = 0;

        for (OrderGoodsEntity orderGoodsEntity : orderGoodsEntityList) {
            //查询商品信息
            GoodsEntity goods = goodsService.getGoods(orderGoodsEntity.getGoodsId());

            if (goods == null) {
                return ResultJson.getResultJsonFail("商品不存在或已下架");
            }

            orderGoodsEntity.setOrderId(entity.getOrderId());
            orderGoodsEntity.setGoodsName(goods.getGoodsName());
            orderGoodsEntity.setRetailPrice(goods.getRetailPrice());
            orderGoodsEntity.setTotalPrice(goods.getRetailPrice() * orderGoodsEntity.getGoodsNumber());
            orderGoodsEntity.setColonel(goods.getColonel() * orderGoodsEntity.getGoodsNumber());
            orderGoodsEntity.setOrderCode(entity.getOrderCode());
            orderGoodsEntity.setImgUrl(goods.getGoodsMajorImg());

            //订单金额
            orderAmount += orderGoodsEntity.getTotalPrice();
            //提成
            colonel += orderGoodsEntity.getColonel();

            payAmount = orderAmount;

            //保存订单商品
            orderGoodsService.save(orderGoodsEntity);

            //放入购买的商品
            goodsEntityList.add(orderGoodsEntity);
        }
        entity.setOrderAmount(orderAmount);
        entity.setPayAmount(payAmount);
        entity.setColonel(colonel);
        entity.setOrderGoodsEntityList(goodsEntityList);

        //收货地址
//        UserAddressEntity userAddress = userAddressService.getUserAddress(entity.getAddressId());
//        if (userAddress == null) {
//            return ResultJson.getResultJsonFail("收货地址不存在");
//        }
//        entity.setAddress(userAddress.getAddress());
        entity.setPhone(entity.getPhone());
        entity.setConsignee(entity.getConsignee());

        //保存订单
        int save = userOrderService.save(entity);

        if (save > 0) {
            return ResultJson.getResultJsonSuccess(SAVE_SUCCESS, entity.getOrderId());
        }

        return ResultJson.getResultJsonFail(SAVE_FAIL);
    }

    /**
     * 发起支付
     *
     * @param entity
     * @return
     */
    @PostMapping(CONTROLLER_NAME + "/pay")
    @Transactional(rollbackFor = Exception.class)
    public String payOrder(UserOrderEntity entity) throws Exception {

        //查询订单
        UserOrderEntity userOrder = userOrderService.getUserOrder(entity.getOrderId());

        if (userOrder == null) {
            return ResultJson.getResultJsonFail("订单不存在");
        }

        //订单已支付
        if (userOrder.getIsPay().equals(2)) {
            return ResultJson.getResultJsonFail("订单已支付");
        }

        //查询用户信息
        UserEntity userInfo = userService.findUserInfoById(userOrder.getUserId());

        WxPayPrePayModel payModel = new WxPayPrePayModel();
        //商品描述
        payModel.setBody("严选商品");
        //订单编号
        payModel.setOutTradeNo(userOrder.getOrderCode());
        //订单金额   单位：分
        payModel.setTotalFee(userOrder.getPayAmount());
        //终端Ip
        payModel.setSpbillCreateIp(WXMiniProgramUtils.getLocalHostIp());
        //回调地址
        payModel.setNotifyUrl(callBack);

        payModel.setOpenId(userInfo.getMiniappOpenId());

        String pay = wxPay.miniAppPay(payModel);

        //获取formId
        ResultJson resultJson = JSONObject.toJavaObject(JSONObject.parseObject(pay), ResultJson.class);
        JSONObject jsonObject = JSONObject.parseObject(resultJson.getInfo().toString());
        String prepayId = jsonObject.getString("prepay_id");
        String formId = prepayId.substring(prepayId.indexOf("=") + 1);

        //储存formId
        UserOrderEntity orderEntity = new UserOrderEntity();
        orderEntity.setOrderId(userOrder.getOrderId());
        orderEntity.setFormId(formId);
        userOrderService.update(orderEntity);

        return pay;

    }

    /**
     * 微信支付回调
     *
     * @param request
     * @param response
     */
    @PostMapping(CONTROLLER_NAME + "/callback")
    public void orderCallback(HttpServletRequest request, HttpServletResponse response) {
        try {
            String callback = wxPay.callback(request, response);
            ResultJson resultJson = JSONObject.toJavaObject(JSONObject.parseObject(callback), ResultJson.class);

            //判断是否成功
            if (ResultJson.CODE_1.equals(resultJson.getCode())) {
                Object info = resultJson.getInfo();
                JSONObject jsonObject = JSONObject.parseObject(info.toString());

                String orderNum = jsonObject.getString("out_trade_no");

                //查询订单
                UserOrderEntity orderEntity = userOrderService.getUserOrderCode(orderNum);

                UserEntity userEntity = userService.findUserInfoById(orderEntity.getUserId());

                //检查订单是否已支付
                if (orderEntity.getIsStatus().equals(2)) {
                    response.getWriter().println(WxFormatParamUtil.resultSuccess());
                    return;
                }
                loggerInfo("订单未支付");
                //支付后处理
                UserOrderEntity order = new UserOrderEntity();

                order.setOrderId(orderEntity.getOrderId());
                //已支付
                order.setIsPay(2);
                //已支付
                order.setIsStatus(2);
                //完成支付时间
                order.setPayTime(new Date());

                int update = userOrderService.update(order);

                if (update > 0) {
                    //发送模板信息
                    List<OrderGoodsEntity> orderGoodsEntityList = orderEntity.getOrderGoodsEntityList();
                    loggerInfo("发送模板消息");
                    StringBuffer goodsName = new StringBuffer();

                    int size = orderGoodsEntityList.size();
                    for (int i = 0; i < size; i++) {
                        goodsName.append(orderGoodsEntityList.get(i).getGoodsName())
                                .append(" x " + orderGoodsEntityList.get(i).getGoodsNumber())
                                .append(i < size - 1 ? "," : "");
                    }

                    double i = orderEntity.getPayAmount() / 100.0;
                    WXMiniProgramUtils.sendTemplate(userEntity.getMiniappOpenId()
                            , ORDER_PAY_OK_TEMPLATE_ID
                            , "pages/orderInfo/orderInfo?orderId=" + orderEntity.getOrderId(),//跳转页面
                            orderEntity.getFormId(),
                            new String[]{orderEntity.getOrderId()//订单号
                                    , dateFormat(orderEntity.getCreateTime())//下单时间
                                    , goodsName.toString()//商品名称
                                    , orderGoodsEntityList.size() + "件"//数量
                                    , i + "元"//支付金额
                                    , dateFormat(order.getPayTime())//支付时间
                                    , "您的商品很快就飞奔到您手上咯！"
                                    , "商丘社区电商第一品牌，因为专业，所以品质"});
                    loggerInfo("发送完毕");
                    response.getWriter().println(WxFormatParamUtil.resultSuccess());

                } else {

                    response.getWriter().println(WxFormatParamUtil.resultFail());

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 查询所有订单
     *
     * @param entity
     * @return
     */
    @CheckLogin
    @GetMapping(CONTROLLER_NAME)
    public String listPage(UserOrderEntity entity) {

        loggerInfo("查询所有订单");

        entity.setUserId(userService.findUserIdByToken());

        PageInfo<UserOrderEntity> listPage = userOrderService.listPage(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, listPage);

    }

    @GetMapping(CONTROLLER_NAME + "/team")
    public String listPageByTeam(UserOrderEntity entity) {

        loggerInfo("查询所有订单");

        PageInfo<UserOrderEntity> listPage = userOrderService.listPage(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, listPage);

    }

    @GetMapping(CONTROLLER_NAME + "/count")
    public String count(UserOrderEntity entity) {

        loggerInfo("查询订单数量");

        int count = userOrderService.getCount(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, count);

    }

    @GetMapping(CONTROLLER_NAME + "/statistics")
    public String statistics(UserOrderEntity entity) {

        loggerInfo("查询订单数量");

        //订单数
        int count = userOrderService.getCount(entity);

        List<UserOrderEntity> list = userOrderService.list(entity);
        int forTheTotal = 0;
        int closeTotal = 0;
        for (UserOrderEntity orderEntity : list) {
            if (orderEntity.getClearingStatus().equals(1)) {
                forTheTotal += orderEntity.getPayAmount();
            }
            if (orderEntity.getClearingStatus().equals(2)) {
                closeTotal += orderEntity.getPayAmount();
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        map.put("forTheTotal", forTheTotal);
        map.put("closeTotal", closeTotal);


        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, map);

    }


    /**
     * 修改
     *
     * @param entity
     * @return
     */
    @CheckLogin
    @PutMapping(CONTROLLER_NAME)
    public String update(UserOrderEntity entity) {
        loggerInfo("用户修改订单");

        UserOrderEntity userOrder = userOrderService.getUserOrder(entity.getOrderId());

        if (userOrder == null) {
            return ResultJson.getResultJsonFail("此订单不存在");
        }

        if (userOrder.getIsStatus().equals(entity.getIsStatus())) {
            return ResultJson.getResultJsonFail(ResultJson.CODE_3, "请勿重复操作");
        }

        if (entity.getIsStatus() == 4) {
            entity.setFinishTime(new Date());
        }

        int update = userOrderService.update(entity);

        if (update > 0) {
            loggerInfo(UPDATE_SUCCESS);
            return ResultJson.getResultJsonSuccess(UPDATE_SUCCESS);
        }
        loggerError(UPDATE_FAIL);
        return ResultJson.getResultJsonFail(UPDATE_FAIL);
    }

    /**
     * 订单详情
     *
     * @param orderId
     * @return
     */
    @CheckLogin
    @GetMapping(CONTROLLER_NAME + "/id")
    public String getUserOrder(String orderId) {
        UserOrderEntity userOrder = userOrderService.getUserOrder(orderId);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, userOrder);
    }

    /**
     * @param response
     * @throws Exception
     */
    @GetMapping("qrCode/create")
    public void test(String content, HttpServletResponse response) throws Exception {

        loggerInfo("生成二维码:内容- " + content);

        QrCodeUtil.createQrCodePngStream(content, response);

    }
 /*   @GetMapping("qrCode/create")
    public void test(Integer x, Integer y, HttpServletResponse response) throws Exception {

        xxx(x, y, response);
    }*/

    public void xxx(Integer x, Integer y, HttpServletResponse response) throws Exception {
        URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547888434418&di=163e79bca56878f0fdcba1ed0d0e52c4&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F377adab44aed2e734ee2f20a8d01a18b87d6fa89.jpg");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //设置请求方式为"GET"
        connection.setRequestMethod("GET");
        //超时响应时间为5秒
        connection.setConnectTimeout(5 * 1000);
        //通过输入流获取图片数据
        InputStream inStream = connection.getInputStream();

        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(inStream);
        //解码当前JPEG数据流，返回BufferedImage对象
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        System.out.println("主图的宽：" + buffImg.getWidth());
        System.out.println("主图的高：" + buffImg.getHeight());

        //得到画笔对象
        Graphics2D g = (Graphics2D) buffImg.getGraphics();

        URL url2 = new URL("https://hanchuig.oss-cn-beijing.aliyuncs.com/1547222393689.jpg");
        ImageIcon imgIcon = new ImageIcon(url2);
        Image image = imgIcon.getImage();


        //将小图片绘到大图片上。
        g.drawImage(image, x, y, null);

        //设置颜色。
        g.setColor(Color.BLACK);


        //设置文字
        Font f = new Font("Default", Font.BOLD, 20);
        g.setFont(f);
        //第一个是你设置的内容。
        g.drawString("商丘社区电商", 480, 400);
        g.dispose();

        ImageIO.write(buffImg, "png", response.getOutputStream());
    }
}
