package com.rcloud.spellminiprogram.service.impl.prefecture;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rcloud.spelldao.dao.prefecture.PrefectureEntityMapper;
import com.rcloud.spellentity.entity.prefecture.PrefectureEntity;
import com.rcloud.spellentity.entity.prefecture.PrefectureEntityExample;
import com.rcloud.spellminiprogram.service.interfaces.prefecture.PrefectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.07
 */
@Service
public class PrefectureServiceImpl implements PrefectureService {

    @Autowired
    PrefectureEntityMapper mapper;


    @Override
    public int save(PrefectureEntity entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public int update(PrefectureEntity entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<PrefectureEntity> list(PrefectureEntity entity) {

        PrefectureEntityExample example = new PrefectureEntityExample();
        PrefectureEntityExample.Criteria criteria = example.createCriteria();
        //创建时间排序
        example.setOrderByClause("create_time desc");


        if (entity.getIntList() != null) {
            criteria.andPrefectureIdIn(entity.getIntList());
        }

        if (entity.getIsStatus() != null) {
            criteria.andIsStatusEqualTo(entity.getIsStatus());
        }

        List<PrefectureEntity> list = mapper.selectByExample(example);

        return list;
    }

    @Override
    public PageInfo<PrefectureEntity> listPage(PrefectureEntity entity) {

        PageHelper.startPage(entity.getPageNum(), entity.getPageSize());
        PrefectureEntityExample example = new PrefectureEntityExample();
        PrefectureEntityExample.Criteria criteria = example.createCriteria();
        //创建时间排序
        example.setOrderByClause("create_time desc");

        List<PrefectureEntity> list = mapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    @Override
    public PrefectureEntity getPrefectureEntity(Integer prefectureId) {
        return mapper.selectByPrimaryKey(prefectureId);
    }
}
