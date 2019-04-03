package com.rcloud.spellweb.controller.slideshow;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.slideshow.SlideShowEntity;
import com.rcloud.spellutils.utils.ResultJson;
import com.rcloud.spellweb.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    public static final String CONTROLLER_NAME = "slideShow";

    /**
     * 新增
     *
     * @param entity
     * @return
     */
    @PostMapping(CONTROLLER_NAME)
    public String save(SlideShowEntity entity) {

        loggerInfo("轮播图新增");

        int save = slideShowService.save(entity);

        if (save > 0) {
            loggerInfo(SAVE_SUCCESS);
            return ResultJson.getResultJsonSuccess(SAVE_SUCCESS);
        }

        loggerError(SAVE_FAIL);
        return ResultJson.getResultJsonFail(SAVE_FAIL);
    }

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    @PutMapping(CONTROLLER_NAME)
    public String update(SlideShowEntity entity) {

        loggerInfo("轮播图修改");

        int update = slideShowService.update(entity);

        if (update > 0) {
            loggerInfo(UPDATE_SUCCESS);
            return ResultJson.getResultJsonSuccess(UPDATE_SUCCESS);
        }

        loggerError(UPDATE_FAIL);
        return ResultJson.getResultJsonFail(UPDATE_FAIL);
    }

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
