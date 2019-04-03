package com.rcloud.spellweb.service.impl.goodscategory;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rcloud.spelldao.dao.goodscategory.GoodsCategoryEntityMapper;
import com.rcloud.spellentity.entity.goodscategory.GoodsCategoryEntity;
import com.rcloud.spellentity.entity.goodscategory.GoodsCategoryEntityExample;
import com.rcloud.spellweb.service.interfaces.goodscategory.GoodsCategoryService;
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
    public int save(GoodsCategoryEntity entity) {
        return mapper.insertSelective(entity);
    }


    @Override
    public int update(GoodsCategoryEntity entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public PageInfo<GoodsCategoryEntity> listPage(GoodsCategoryEntity entity) {

        PageHelper.startPage(entity.getPageNum(), entity.getPageSize());

        GoodsCategoryEntityExample example = new GoodsCategoryEntityExample();

        GoodsCategoryEntityExample.Criteria criteria = example.createCriteria();

        example.setOrderByClause("create_time asc");

        if (entity.getCategoryId() != null) {
            criteria.andCategoryIdEqualTo(entity.getCategoryId());
        }
        if (entity.getParentId() != null) {
            criteria.andParentIdEqualTo(entity.getParentId());
        }
        List<GoodsCategoryEntity> list = mapper.selectByExample(example);

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

        List<GoodsCategoryEntity> list = mapper.selectByExample(example);

        return list;
    }

    @Override
    public GoodsCategoryEntity getGoodsCategory(Integer categoryId) {
        return mapper.selectByPrimaryKey(categoryId);
    }
}
