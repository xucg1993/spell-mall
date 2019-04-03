package com.rcloud.spellweb.service.interfaces.goodscategory;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.goodscategory.GoodsCategoryEntity;

import java.util.List;

public interface GoodsCategoryService {


    /**
     * 新增类别
     *
     * @param entity
     * @return
     */
    int save(GoodsCategoryEntity entity);


    /**
     * 修改类别
     *
     * @param entity
     * @return
     */
    int update(GoodsCategoryEntity entity);

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