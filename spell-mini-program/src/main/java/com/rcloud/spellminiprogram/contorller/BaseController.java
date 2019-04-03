package com.rcloud.spellminiprogram.contorller;

import com.rcloud.spellminiprogram.service.interfaces.goods.GoodsService;
import com.rcloud.spellminiprogram.service.interfaces.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xuchenguang
 * @since 2019.01.05
 */
public class BaseController {

    /**
     * 订单支付成功通知
     */
    protected static final String ORDER_PAY_OK_TEMPLATE_ID = "2-biCWt8qcJxPuWPNTCMIejuOQQKcwEHvjga_Vd-gE4";


    @Value("${wxConfig.appId}")
    protected String appId;

    @Value("${wxConfig.secret}")
    protected String secret;

    @Value("${wxConfig.callBack}")
    protected String callBack;

    /**
     * 商品
     */
    @Autowired
    protected GoodsService goodsService;




    @Autowired
    protected UserService userService;


    protected static final String SAVE_SUCCESS = "新增成功";
    protected static final String SAVE_FAIL = "新增失败";

    protected static final String UPDATE_SUCCESS = "修改成功";
    protected static final String UPDATE_FAIL = "修改失败";

    protected static final String DELETE_SUCCESS = "删除成功";
    protected static final String DELETE_FAIL = "删除失败";

    protected static final String QUERY_SUCCESS = "查询成功";
    protected static final String QUERY_FAIL = "查询失败";


    protected Logger logger(String name) {
        return LoggerFactory.getLogger(name);
    }

    /**
     * 日志
     *
     * @param info
     */
    protected void loggerInfo(String info) {
        LoggerFactory.getLogger(this.getClass()).info(info);
    }

    protected void loggerDebug(String info) {
        LoggerFactory.getLogger(this.getClass()).debug(info);
    }

    protected void loggerError(String info) {
        LoggerFactory.getLogger(this.getClass()).error(info);
    }


    /**
     * 格式时间  yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    protected String dateFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
