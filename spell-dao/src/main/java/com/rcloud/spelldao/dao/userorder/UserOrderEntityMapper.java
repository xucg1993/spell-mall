package com.rcloud.spelldao.dao.userorder;

import com.rcloud.spellentity.entity.userorder.UserOrderEntity;
import com.rcloud.spellentity.entity.userorder.UserOrderEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserOrderEntityMapper {
    int countByExample(UserOrderEntityExample example);

    int deleteByExample(UserOrderEntityExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(UserOrderEntity record);

    int insertSelective(UserOrderEntity record);

    List<UserOrderEntity> selectByExample(UserOrderEntityExample example);

    UserOrderEntity selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") UserOrderEntity record, @Param("example") UserOrderEntityExample example);

    int updateByExample(@Param("record") UserOrderEntity record, @Param("example") UserOrderEntityExample example);

    int updateByPrimaryKeySelective(UserOrderEntity record);

    int updateByPrimaryKey(UserOrderEntity record);

    UserOrderEntity getUserOrderCode(String orderCode);
}