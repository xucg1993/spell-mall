package com.rcloud.spellminiprogram.service.impl.withdrawal;

import com.github.pagehelper.PageInfo;
import com.rcloud.spelldao.dao.withdrawal.WithdrawalEntityMapper;
import com.rcloud.spellentity.entity.withdrawal.WithdrawalEntity;
import com.rcloud.spellentity.entity.withdrawal.WithdrawalEntityExample;
import com.rcloud.spellminiprogram.service.interfaces.withdrawal.WithdrawalService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.22
 */
@Service
public class WithdrawalServiceImpl implements WithdrawalService {


    @Autowired
    WithdrawalEntityMapper mapper;

    @Override
    public int save(WithdrawalEntity entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public int update(WithdrawalEntity entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public WithdrawalEntity getWithdrawal(Integer mwId) {
        return mapper.selectByPrimaryKey(mwId);
    }

    @Override
    public List<WithdrawalEntity> list(WithdrawalEntity entity) {

        WithdrawalEntityExample example = new WithdrawalEntityExample();
        WithdrawalEntityExample.Criteria criteria = example.createCriteria();

        example.setOrderByClause("create_time desc");

        if (StringUtils.isNoneBlank(entity.getUserId())) {
            criteria.andUserIdEqualTo(entity.getUserId());
        }

        if (entity.getTeamId() != null) {
            criteria.andTeamIdEqualTo(entity.getTeamId());
        }
        return mapper.selectByExample(example);
    }

    @Override
    public PageInfo<WithdrawalEntity> listPage(WithdrawalEntity entity) {
        WithdrawalEntityExample example = new WithdrawalEntityExample();
        WithdrawalEntityExample.Criteria criteria = example.createCriteria();

        example.setOrderByClause("create_time desc");

        if (StringUtils.isNoneBlank(entity.getUserId())) {
            criteria.andUserIdEqualTo(entity.getUserId());
        }

        if (entity.getTeamId() != null) {
            criteria.andTeamIdEqualTo(entity.getTeamId());
        }
        List<WithdrawalEntity> list = mapper.selectByExample(example);

        return new PageInfo<>(list);
    }
}
