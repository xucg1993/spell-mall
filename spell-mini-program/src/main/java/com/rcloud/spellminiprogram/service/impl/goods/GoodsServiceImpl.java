package com.rcloud.spellminiprogram.service.impl.goods;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rcloud.spelldao.dao.goods.GoodsEntityMapper;
import com.rcloud.spellentity.entity.goods.GoodsEntity;
import com.rcloud.spellentity.entity.goods.GoodsEntityExample;
import com.rcloud.spellminiprogram.service.interfaces.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.06
 */
@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    GoodsEntityMapper mapper;


    @Override
    public int save(GoodsEntity entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public int update(GoodsEntity entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public PageInfo<GoodsEntity> listPage(GoodsEntity entity) {

        PageHelper.startPage(entity.getPageNum(), entity.getPageSize());

        GoodsEntityExample example = new GoodsEntityExample();
        GoodsEntityExample.Criteria criteria = example.createCriteria();
        if (entity.getCategoryId() != null) {
            criteria.andCategoryIdEqualTo(entity.getCategoryId());
        }
        if (entity.getIsStatus() != null) {
            criteria.andIsStatusEqualTo(entity.getIsStatus());
        }

        List<GoodsEntity> list = mapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    @Override
    public List<GoodsEntity> list(GoodsEntity entity) {
        GoodsEntityExample entityExample = new GoodsEntityExample();
        GoodsEntityExample.Criteria criteria = entityExample.createCriteria();
        if (entity.getCategoryId() != null) {
            criteria.andCategoryIdEqualTo(entity.getCategoryId());
        }
        if (entity.getIsStatus() != null) {
            criteria.andIsStatusEqualTo(entity.getIsStatus());
        }

        List<GoodsEntity> list = mapper.selectByExample(entityExample);

        return list;
    }

    @Override
    public GoodsEntity getGoods(String goodsId) {
        return mapper.selectByPrimaryKey(goodsId);
    }
}
