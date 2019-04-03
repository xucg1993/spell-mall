package com.rcloud.spelldao.dao.goods;

import com.rcloud.spellentity.entity.goods.GoodsEntity;
import com.rcloud.spellentity.entity.goods.GoodsEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsEntityMapper {
    int countByExample(GoodsEntityExample example);

    int deleteByExample(GoodsEntityExample example);

    int deleteByPrimaryKey(String goodsId);

    int insert(GoodsEntity record);

    int insertSelective(GoodsEntity record);

    List<GoodsEntity> selectByExample(GoodsEntityExample example);

    GoodsEntity selectByPrimaryKey(String goodsId);

    int updateByExampleSelective(@Param("record") GoodsEntity record, @Param("example") GoodsEntityExample example);

    int updateByExample(@Param("record") GoodsEntity record, @Param("example") GoodsEntityExample example);

    int updateByPrimaryKeySelective(GoodsEntity record);

    int updateByPrimaryKey(GoodsEntity record);

    List<GoodsEntity> selectByCategoryId(Integer categoryId);
}