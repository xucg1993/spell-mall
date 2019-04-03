package com.rcloud.spellweb.controller;

import com.rcloud.spellweb.service.interfaces.goods.GoodsService;
import com.rcloud.spellweb.service.interfaces.goodscategory.GoodsCategoryService;
import com.rcloud.spellweb.service.interfaces.notice.NoticeService;
import com.rcloud.spellweb.service.interfaces.prefecture.PrefectureService;
import com.rcloud.spellweb.service.interfaces.prefecturegoods.PrefectureGoodsService;
import com.rcloud.spellweb.service.interfaces.slideshow.SlideShowService;
import com.rcloud.spellweb.service.interfaces.team.TeamService;
import com.rcloud.spellweb.service.interfaces.teamapplication.TeamApplicationService;
import com.rcloud.spellweb.service.interfaces.user.UserService;
import com.rcloud.spellweb.service.interfaces.userorder.UserOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xuchenguang
 * @since 2019.01.05
 */
public class BaseController {


    /**
     * 公告
     */
    @Autowired
    protected NoticeService noticeService;

    /**
     * 商品分类
     */
    @Autowired
    protected GoodsCategoryService goodsCategoryService;

    /**
     * 商品
     */
    @Autowired
    protected GoodsService goodsService;

    /**
     * 轮播图
     */
    @Autowired
    protected SlideShowService slideShowService;

    /**
     * 团队
     */
    @Autowired
    protected TeamService teamService;

    @Autowired
    protected UserOrderService userOrderService;

    @Autowired
    protected PrefectureService prefectureService;
    @Autowired
    protected PrefectureGoodsService prefectureGoodsService;


    @Autowired
    protected TeamApplicationService teamApplicationService;

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
}
