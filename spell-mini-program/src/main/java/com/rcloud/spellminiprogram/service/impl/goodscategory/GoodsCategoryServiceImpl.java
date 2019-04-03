package com.rcloud.spellminiprogram.service.impl.goodscategory;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rcloud.spelldao.dao.goodscategory.GoodsCategoryEntityMapper;
import com.rcloud.spellentity.entity.goodscategory.GoodsCategoryEntity;
import com.rcloud.spellentity.entity.goodscategory.GoodsCategoryEntityExample;
import com.rcloud.spellminiprogram.service.interfaces.goodscategory.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.05
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Autowired
    GoodsCategoryEntityMapper mapper;

    @Override
    public PageInfo<GoodsCategoryEntity> listPage(GoodsCategoryEntity entity) {

        PageHelper.startPage(entity.getPageNum(), entity.getPageSize());

        GoodsCategoryEntityExample example = new GoodsCategoryEntityExample();

        GoodsCategoryEntityExample.Criteria criteria = example.createCriteria();

        if (entity.getCategoryId() != null) {
            criteria.andCategoryIdEqualTo(entity.getCategoryId());
        }
        if (entity.getParentId() != null) {
            criteria.andParentIdEqualTo(entity.getParentId());
        }

        example.setOrderByClause("create_time asc");

        List<GoodsCategoryEntity> list = mapper.selectByExampleNew(example);

        return new PageInfo<>(list);
    }

    @Override
    public List<GoodsCategoryEntity> list(GoodsCategoryEntity entity) {

        GoodsCategoryEntityExample example = new GoodsCategoryEntityExample();

        GoodsCategoryEntityExample.Criteria criteria = example.createCriteria();

        example.setOrderByClause("create_time asc");

        if (entity.getCategoryId() != null) {
            criteria.andCategoryIdEqualTo(entity.getCategoryId());
        }
        if (entity.getParentId() != null) {
            criteria.andParentIdEqualTo(entity.getParentId());
        }

        List<GoodsCategoryEntity> list = mapper.selectByExampleNew(example);

        return list;
    }

    @Override
    public GoodsCategoryEntity getGoodsCategory(Integer categoryId) {
        return mapper.selectByCategoryId(categoryId);
    }
}
