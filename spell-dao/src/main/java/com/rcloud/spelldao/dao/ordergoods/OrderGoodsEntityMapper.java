package com.rcloud.spelldao.dao.ordergoods;

import com.rcloud.spellentity.entity.ordergoods.OrderGoodsEntity;
import com.rcloud.spellentity.entity.ordergoods.OrderGoodsEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderGoodsEntityMapper {
    int countByExample(OrderGoodsEntityExample example);

    int deleteByExample(OrderGoodsEntityExample example);

    int deleteByPrimaryKey(Integer ogId);

    int insert(OrderGoodsEntity record);

    int insertSelective(OrderGoodsEntity record);

    List<OrderGoodsEntity> selectByExample(OrderGoodsEntityExample example);

    OrderGoodsEntity selectByPrimaryKey(Integer ogId);

    int updateByExampleSelective(@Param("record") OrderGoodsEntity record, @Param("example") OrderGoodsEntityExample example);

    int updateByExample(@Param("record") OrderGoodsEntity record, @Param("example") OrderGoodsEntityExample example);

    int updateByPrimaryKeySelective(OrderGoodsEntity record);

    int updateByPrimaryKey(OrderGoodsEntity record);

    List<OrderGoodsEntity> selectByOrderId(String orderId);


}