package com.rcloud.spellminiprogram.service.impl.prefecturegoods;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rcloud.spelldao.dao.prefecturegoods.PrefectureGoodsEntityMapper;
import com.rcloud.spellentity.entity.prefecturegoods.PrefectureGoodsEntity;
import com.rcloud.spellentity.entity.prefecturegoods.PrefectureGoodsEntityExample;
import com.rcloud.spellminiprogram.service.interfaces.prefecturegoods.PrefectureGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.07
 */
@Service
public class PrefectureGoodsServiceImpl implements PrefectureGoodsService {


    @Autowired
    PrefectureGoodsEntityMapper mapper;


    @Override
    public int save(PrefectureGoodsEntity entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public int update(PrefectureGoodsEntity entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<PrefectureGoodsEntity> list(PrefectureGoodsEntity entity) {

        PrefectureGoodsEntityExample example = new PrefectureGoodsEntityExample();
        PrefectureGoodsEntityExample.Criteria criteria = example.createCriteria();
        if (entity.getPrefectureId() != null) {
            criteria.andPrefectureIdEqualTo(entity.getPrefectureId());
        }
        if (entity.getIsShow() != null) {
            criteria.andIsShowEqualTo(entity.getIsShow());
        }

        List<PrefectureGoodsEntity> list = mapper.selectByExample(example);

        return list;
    }

    @Override
    public PageInfo<PrefectureGoodsEntity> listPage(PrefectureGoodsEntity entity) {

        PageHelper.startPage(entity.getPageNum(), entity.getPageSize());

        PrefectureGoodsEntityExample example = new PrefectureGoodsEntityExample();
        PrefectureGoodsEntityExample.Criteria criteria = example.createCriteria();
        if (entity.getPrefectureId() != null) {
            criteria.andPrefectureIdEqualTo(entity.getPrefectureId());
        }

        if (entity.getIsShow() != null) {
            criteria.andIsShowEqualTo(entity.getIsShow());
        }


        List<PrefectureGoodsEntity> list = mapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    @Override
    public PrefectureGoodsEntity getPrefectureGoods(Integer prefectureGoodsId) {
        return mapper.selectByPrimaryKey(prefectureGoodsId);
    }


/*    @Override
    public PageInfo<PrefectureGoodsEntity> getPrefectureGoodsListPage(PrefectureGoodsEntity entity) {

        PageHelper.startPage(entity.getPageNum(), entity.getPageSize());

        List<PrefectureGoodsEntity> list = mapper.getPrefectureGoodsListPage(entity);

        return new PageInfo<>(list);
    }


    @Override
    public List<PrefectureGoodsEntity> getPrefectureGoodsList(PrefectureGoodsEntity entity) {
        return mapper.getPrefectureGoodsListPage(entity);
    }*/

    @Override
    public int count(PrefectureGoodsEntity entity) {
        PrefectureGoodsEntityExample example = new PrefectureGoodsEntityExample();
        PrefectureGoodsEntityExample.Criteria criteria = example.createCriteria();
        if (entity.getPrefectureId() != null) {
            criteria.andPrefectureIdEqualTo(entity.getPrefectureId());
        }

        if (entity.getIsShow() != null) {
            criteria.andIsShowEqualTo(entity.getIsShow());
        }
        return mapper.countByExample(example);
    }
}
