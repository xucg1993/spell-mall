package com.rcloud.spellminiprogram.service.impl.goodsevaluate;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rcloud.spelldao.dao.goodsevaluate.GoodsEvaluateEntityMapper;
import com.rcloud.spellentity.entity.goodsevaluate.GoodsEvaluateEntity;
import com.rcloud.spellentity.entity.goodsevaluate.GoodsEvaluateEntityExample;
import com.rcloud.spellminiprogram.service.interfaces.goodsevaluate.GoodsEvaluateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.10
 */
@Service
public class GoodsEvaluateServiceImpl implements GoodsEvaluateService {

    @Autowired
    GoodsEvaluateEntityMapper mapper;


    @Override
    public int save(GoodsEvaluateEntity evaluateEntity) {
        return mapper.insertSelective(evaluateEntity);
    }

    @Override
    public List<GoodsEvaluateEntity> list(GoodsEvaluateEntity entity) {

        GoodsEvaluateEntityExample example = new GoodsEvaluateEntityExample();
        GoodsEvaluateEntityExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("create_time desc,star desc");

        if (StringUtils.isNoneBlank(entity.getGoodsId())) {
            criteria.andGoodsIdEqualTo(entity.getGoodsId());
        }

        return mapper.selectByExample(example);
    }

    @Override
    public PageInfo<GoodsEvaluateEntity> listPage(GoodsEvaluateEntity entity) {

        PageHelper.startPage(entity.getPageNum(), entity.getPageSize());

        GoodsEvaluateEntityExample example = new GoodsEvaluateEntityExample();
        GoodsEvaluateEntityExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("create_time desc,star desc");

        if (StringUtils.isNoneBlank(entity.getGoodsId())) {
            criteria.andGoodsIdEqualTo(entity.getGoodsId());
        }

        List<GoodsEvaluateEntity> list = mapper.selectByExample(example);

        return new PageInfo<>(list);
    }
}
