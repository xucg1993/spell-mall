package com.rcloud.spellweb.service.impl.userorder;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rcloud.spelldao.dao.userorder.UserOrderEntityMapper;
import com.rcloud.spellentity.entity.userorder.UserOrderEntity;
import com.rcloud.spellentity.entity.userorder.UserOrderEntityExample;
import com.rcloud.spellweb.service.interfaces.userorder.UserOrderService;
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
    public PageInfo<UserOrderEntity> listPage(UserOrderEntity entity) {

        PageHelper.startPage(entity.getPageNum(), entity.getPageSize());

        UserOrderEntityExample example = new UserOrderEntityExample();
        UserOrderEntityExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("create_time desc");

        //已付款
        List<Integer> status = new ArrayList<>();
        status.add(1);
        status.add(2);
        status.add(3);
        status.add(4);
        status.add(5);
        criteria.andIsStatusIn(status);

        List<UserOrderEntity> list = mapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    @Override
    public int update(UserOrderEntity entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }


    @Override
    public UserOrderEntity getUserOrder(String orderId) {
        return mapper.selectByPrimaryKey(orderId);
    }
}
