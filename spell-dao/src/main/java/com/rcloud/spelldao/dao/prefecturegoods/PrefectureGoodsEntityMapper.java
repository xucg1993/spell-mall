package com.rcloud.spelldao.dao.prefecturegoods;

import com.rcloud.spellentity.entity.goods.GoodsEntity;
import com.rcloud.spellentity.entity.prefecturegoods.PrefectureGoodsEntity;
import com.rcloud.spellentity.entity.prefecturegoods.PrefectureGoodsEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrefectureGoodsEntityMapper {
    int countByExample(PrefectureGoodsEntityExample example);

    int deleteByExample(PrefectureGoodsEntityExample example);

    int deleteByPrimaryKey(Integer pgId);

    int insert(PrefectureGoodsEntity record);

    int insertSelective(PrefectureGoodsEntity record);

    List<PrefectureGoodsEntity> selectByExample(PrefectureGoodsEntityExample example);

    PrefectureGoodsEntity selectByPrimaryKey(Integer pgId);

    int updateByExampleSelective(@Param("record") PrefectureGoodsEntity record, @Param("example") PrefectureGoodsEntityExample example);

    int updateByExample(@Param("record") PrefectureGoodsEntity record, @Param("example") PrefectureGoodsEntityExample example);

    int updateByPrimaryKeySelective(PrefectureGoodsEntity record);

    int updateByPrimaryKey(PrefectureGoodsEntity record);


    List<PrefectureGoodsEntity> getPrefectureGoodsList(PrefectureGoodsEntity entity);


    List<GoodsEntity> getGoodsList(PrefectureGoodsEntity entity);
}