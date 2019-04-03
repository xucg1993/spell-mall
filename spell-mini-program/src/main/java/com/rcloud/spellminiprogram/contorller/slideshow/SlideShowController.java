package com.rcloud.spellminiprogram.contorller.slideshow;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.slideshow.SlideShowEntity;
import com.rcloud.spellminiprogram.contorller.BaseController;
import com.rcloud.spellminiprogram.service.interfaces.slideshow.SlideShowService;
import com.rcloud.spellutils.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 轮播图管理
 *
 * @author xuchenguang
 * @since 2019.01.06
 */
@RestController
public class SlideShowController extends BaseController {

    /**
     * 轮播图
     */
    @Autowired
    protected SlideShowService slideShowService;

    public static final String CONTROLLER_NAME = "slideShow";

    /**
     * 列表  无分页
     *
     * @param entity
     * @return
     */
    @GetMapping(CONTROLLER_NAME)
    public String list(SlideShowEntity entity) {

        loggerInfo("查询轮播图列表");

        List<SlideShowEntity> list = slideShowService.list(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, list);
    }

    /**
     * 列表  分页
     *
     * @param entity
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/page")
    public String listPage(SlideShowEntity entity) {

        loggerInfo("查询轮播图列表 分页");

        PageInfo<SlideShowEntity> list = slideShowService.listPage(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, list);
    }

    /**
     * 查询轮播图详情
     *
     * @param id
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/id")
    public String getSlideShow(String id) {

        loggerInfo("查询轮播图详情");

        SlideShowEntity entity = slideShowService.getSlideShow(id);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, entity);
    }


}
