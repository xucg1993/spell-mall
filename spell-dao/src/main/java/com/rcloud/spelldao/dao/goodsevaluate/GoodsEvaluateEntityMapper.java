package com.rcloud.spelldao.dao.goodsevaluate;

import com.rcloud.spellentity.entity.goodsevaluate.GoodsEvaluateEntity;
import com.rcloud.spellentity.entity.goodsevaluate.GoodsEvaluateEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsEvaluateEntityMapper {
    int countByExample(GoodsEvaluateEntityExample example);

    int deleteByExample(GoodsEvaluateEntityExample example);

    int deleteByPrimaryKey(Integer evaluateId);

    int insert(GoodsEvaluateEntity record);

    int insertSelective(GoodsEvaluateEntity record);

    List<GoodsEvaluateEntity> selectByExample(GoodsEvaluateEntityExample example);

    GoodsEvaluateEntity selectByPrimaryKey(Integer evaluateId);

    int updateByExampleSelective(@Param("record") GoodsEvaluateEntity record, @Param("example") GoodsEvaluateEntityExample example);

    int updateByExample(@Param("record") GoodsEvaluateEntity record, @Param("example") GoodsEvaluateEntityExample example);

    int updateByPrimaryKeySelective(GoodsEvaluateEntity record);

    int updateByPrimaryKey(GoodsEvaluateEntity record);
}