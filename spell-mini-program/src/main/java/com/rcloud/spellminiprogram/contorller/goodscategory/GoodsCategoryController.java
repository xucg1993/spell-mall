package com.rcloud.spellminiprogram.contorller.goodscategory;

import com.rcloud.spellentity.entity.goodscategory.GoodsCategoryEntity;
import com.rcloud.spellminiprogram.contorller.BaseController;
import com.rcloud.spellminiprogram.service.interfaces.goodscategory.GoodsCategoryService;
import com.rcloud.spellutils.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品分类
 * @author xuchenguang
 * @since 2019.01.05
 */
@RestController
public class GoodsCategoryController extends BaseController {

    public static final String CONTROLLER_NAME = "goodsCategory";


    /**
     * 商品分类
     */
    @Autowired
    protected GoodsCategoryService goodsCategoryService;

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