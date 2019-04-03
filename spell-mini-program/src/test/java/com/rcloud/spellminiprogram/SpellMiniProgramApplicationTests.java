package com.rcloud.spellminiprogram;

import com.alibaba.fastjson.JSONObject;
import com.rcloud.spellminiprogram.contorller.BaseController;
import com.rcloud.spellutils.utils.WXMiniProgramUtils;
import com.xucg.model.WxPayPrePayModel;
import com.xucg.model.WxWorkPayModel;
import com.xucg.pay.WxPay;
import com.xucg.work.WxWorkPay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpellMiniProgramApplicationTests extends BaseController {

    @Autowired
    WxPay wxPay;

    @Test
    public void contextLoads() {
        WxPayPrePayModel model = new WxPayPrePayModel();
        System.out.println(JSONObject.toJSONString(model));
        //商品描述
        model.setBody("测试");
        //订单编号
        model.setOutTradeNo("201802261231561111");
        //订单金额   单位：分
        model.setTotalFee(1000);
        //终端Ip
        model.setSpbillCreateIp("127.0.0.1");
        //回调地址
        model.setNotifyUrl("http://www.baidu.com");

        model.setOpenId("oA4SZ5SUFqxep3u8N6WM1q1lPRnA");

        String pay = wxPay.miniAppPay(model);

        System.out.println(pay);
    }

    @Test
    public void aaa() throws Exception {
        String accessToken = WXMiniProgramUtils.getAccessToken(appId, secret);
        System.out.println(accessToken);
    }

    @Test
    public void bbb() throws Exception {
        WxWorkPayModel model = new WxWorkPayModel("wwcde813c600556c6d"
                , "1500793841"
                , "H68LB0G5CyeFArcYleQh93GYJP6U2a8X"
                , "oqhH-ZP9dAURNQmztpiBRHeSeqWc9Z80V3qqUaDdaCQ");
        model.setPartnerTradeNo("1234567890");
        model.setOpenId("oAKhf1WCtys0JG58GvhGKq24fGZ8");
        model.setCheckName("NO_CHECK");
        model.setAmount(100);
        model.setDesc("六月出差报销费用");
        model.setSpbillCreateIp(WXMiniProgramUtils.getLocalHostIp());
        model.setWwMsgType("NORMAL_MSG");
        model.setActName("拼團");
        String payment = WxWorkPay.employeePayment(model, "C:\\Users\\XCG\\Desktop\\apiclient_cert.p12");
        System.out.println(payment);
    }


    @Test
    public void eee() {
        String sendTemplate = WXMiniProgramUtils.sendTemplate("oA4SZ5SUFqxep3u8N6WM1q1lPRnA"
                , ORDER_PAY_OK_TEMPLATE_ID
                , "pages/orderInfo/orderInfo",//跳转页面
                "wx1815271107707102c36024f32213280516",
                new String[]{"123456789"//订单号
                        , dateFormat(new Date())//下单时间
                        , "测试商品"//商品名称
                        , 111 + ""//数量
                        , (10000 / 100) + ""//支付金额
                        , dateFormat(new Date())//支付时间
                        , "您的商品很快就飞奔到您手上咯！"
                        , "商丘社区电商第一品牌，因为专业，所以品质"});
    }
}

