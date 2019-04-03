package com.rcloud.spellminiprogram.service.impl.userorder;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rcloud.spelldao.dao.userorder.UserOrderEntityMapper;
import com.rcloud.spellentity.entity.userorder.UserOrderEntity;
import com.rcloud.spellentity.entity.userorder.UserOrderEntityExample;
import com.rcloud.spellminiprogram.service.interfaces.userorder.UserOrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.07
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {


    @Autowired
    UserOrderEntityMapper mapper;


    @Override
    public int save(UserOrderEntity entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public PageInfo<UserOrderEntity> listPage(UserOrderEntity entity) {

        PageHelper.startPage(entity.getPageNum(), entity.getPageSize());

        UserOrderEntityExample example = new UserOrderEntityExample();

        UserOrderEntityExample.Criteria criteria = example.createCriteria();

        example.setOrderByClause("create_time desc");

        //已付款
        List<Integer> status = new ArrayList<>();
        Integer isStatus = entity.getIsStatus();
        if (isStatus != null) {
            if (entity.getIsStatus().equals(0)) {
                status.add(1);
                status.add(2);
                status.add(3);
                status.add(4);
                status.add(5);
            } else if (entity.getIsStatus().equals(1)) {
                status.add(1);
            } else if (entity.getIsStatus().equals(2)) {
                status.add(2);
            } else if (entity.getIsStatus().equals(3)) {
                status.add(3);
            } else if (entity.getIsStatus().equals(4)) {
                status.add(4);
            }
            criteria.andIsStatusIn(status);
        }


        if (StringUtils.isNoneBlank(entity.getUserId())) {
            criteria.andUserIdEqualTo(entity.getUserId());
        }

        if (entity.getTeamId() != null) {
            criteria.andTeamIdEqualTo(entity.getTeamId());
        }

        List<UserOrderEntity> list = mapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    @Override
    public List<UserOrderEntity> list(UserOrderEntity entity) {
        UserOrderEntityExample example = new UserOrderEntityExample();

        UserOrderEntityExample.Criteria criteria = example.createCriteria();

        if (StringUtils.isNoneBlank(entity.getUserId())) {
            criteria.andUserIdEqualTo(entity.getUserId());
        }

        if (entity.getTeamId() != null) {
            criteria.andTeamIdEqualTo(entity.getTeamId());
        }

        return mapper.selectByExample(example);
    }

    @Override
    public int update(UserOrderEntity entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public UserOrderEntity getUserOrder(String orderId) {
        return mapper.selectByPrimaryKey(orderId);
    }

    @Override
    public UserOrderEntity getUserOrderCode(String orderCode) {
        return mapper.getUserOrderCode(orderCode);
    }

    @Override
    public int getCount(UserOrderEntity entity) {
        UserOrderEntityExample example = new UserOrderEntityExample();

        UserOrderEntityExample.Criteria criteria = example.createCriteria();

        if (entity.getTeamId() != null) {
            criteria.andTeamIdEqualTo(entity.getTeamId());
        }

        if (StringUtils.isNoneBlank(entity.getUserId())) {
            criteria.andUserIdEqualTo(entity.getUserId());
        }

        return mapper.countByExample(example);
    }
}
