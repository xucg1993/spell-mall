package com.rcloud.spelldao.dao.goodsdetails;

import com.rcloud.spellentity.entity.goodsdetails.GoodsDetailsEntity;
import com.rcloud.spellentity.entity.goodsdetails.GoodsDetailsEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDetailsEntityMapper {
    int countByExample(GoodsDetailsEntityExample example);

    int deleteByExample(GoodsDetailsEntityExample example);

    int deleteByPrimaryKey(Integer gdId);

    int insert(GoodsDetailsEntity record);

    int insertSelective(GoodsDetailsEntity record);

    List<GoodsDetailsEntity> selectByExample(GoodsDetailsEntityExample example);

    GoodsDetailsEntity selectByPrimaryKey(Integer gdId);

    int updateByExampleSelective(@Param("record") GoodsDetailsEntity record, @Param("example") GoodsDetailsEntityExample example);

    int updateByExample(@Param("record") GoodsDetailsEntity record, @Param("example") GoodsDetailsEntityExample example);

    int updateByPrimaryKeySelective(GoodsDetailsEntity record);

    int updateByPrimaryKey(GoodsDetailsEntity record);


    /**
     * 通过商品id查询
     *
     * @param goodsId
     * @return
     */
    GoodsDetailsEntity selectByGoodsId(String goodsId);

}