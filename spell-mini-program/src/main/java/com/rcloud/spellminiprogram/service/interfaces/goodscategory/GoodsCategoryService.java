package com.rcloud.spellminiprogram.service.interfaces.goodscategory;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.goodscategory.GoodsCategoryEntity;

import java.util.List;

public interface GoodsCategoryService {


    /**
     * 查询列表  带分页
     *
     * @param entity
     * @return
     */
    PageInfo<GoodsCategoryEntity> listPage(GoodsCategoryEntity entity);

    List<GoodsCategoryEntity> list(GoodsCategoryEntity entity);

    GoodsCategoryEntity getGoodsCategory(Integer categoryId);
}