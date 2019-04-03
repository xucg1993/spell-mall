package com.rcloud.spellweb.controller.goodscategory;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.goodscategory.GoodsCategoryEntity;
import com.rcloud.spellutils.utils.ResultJson;
import com.rcloud.spellweb.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuchenguang
 * @since 2019.01.05
 */
@RestController
public class GoodsCategoryController extends BaseController {

    public static final String CONTROLLER_NAME = "goodsCategory";

    /**
     * 保存分类
     *
     * @param entity
     * @return
     */
    @PostMapping(CONTROLLER_NAME)
    public String save(GoodsCategoryEntity entity) {

        loggerDebug("保存分类");

        int i = goodsCategoryService.save(entity);

        if (i > 0) {
            loggerInfo(SAVE_SUCCESS);
            return ResultJson.getResultJsonSuccess(SAVE_SUCCESS, entity);
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
    public String update(GoodsCategoryEntity entity) {

        loggerInfo("修改分类");

        int update = goodsCategoryService.update(entity);

        if (update > 0) {
            return ResultJson.getResultJsonSuccess(UPDATE_SUCCESS);
        }

        return ResultJson.getResultJsonFail(UPDATE_FAIL);
    }

    /**
     * 查询列表 带分页
     *
     * @param entity
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/page")
    public String listPage(GoodsCategoryEntity entity) {

        PageInfo<GoodsCategoryEntity> list = goodsCategoryService.listPage(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, list);
    }

    /**
     * 分类列表
     *
     * @param entity
     * @return
     */
    @GetMapping(CONTROLLER_NAME)
    public String list(GoodsCategoryEntity entity) {

        List<GoodsCategoryEntity> list = goodsCategoryService.list(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, list);
    }

    @GetMapping(CONTROLLER_NAME + "/map")
    public String listMap(GoodsCategoryEntity entity) {

        List<GoodsCategoryEntity> list = goodsCategoryService.list(entity);

        //父级信息
        GoodsCategoryEntity goodsCategory = goodsCategoryService.getGoodsCategory(entity.getParentId());

        //处理加载一级区域  区域为空的问题
        if (goodsCategory == null) {
            goodsCategory = new GoodsCategoryEntity();
            goodsCategory.setCategoryId(0);
        }

        Map<String, Object> map = new HashMap<>();

        map.put("goodsCategory", goodsCategory);
        map.put("entity", entity);
        map.put("list", list);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, map);
    }

    /**
     * 查询分类 详情
     *
     * @param categoryId
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/id")
    public String getGoodsCategory(Integer categoryId) {

        GoodsCategoryEntity entity = goodsCategoryService.getGoodsCategory(categoryId);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, entity);
    }

}