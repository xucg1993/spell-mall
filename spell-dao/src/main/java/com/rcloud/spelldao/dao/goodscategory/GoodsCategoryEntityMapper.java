package com.rcloud.spelldao.dao.goodscategory;

import com.rcloud.spellentity.entity.goodscategory.GoodsCategoryEntity;
import com.rcloud.spellentity.entity.goodscategory.GoodsCategoryEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryEntityMapper {
    int countByExample(GoodsCategoryEntityExample example);

    int deleteByExample(GoodsCategoryEntityExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(GoodsCategoryEntity record);

    int insertSelective(GoodsCategoryEntity record);

    List<GoodsCategoryEntity> selectByExample(GoodsCategoryEntityExample example);

    GoodsCategoryEntity selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") GoodsCategoryEntity record, @Param("example") GoodsCategoryEntityExample example);

    int updateByExample(@Param("record") GoodsCategoryEntity record, @Param("example") GoodsCategoryEntityExample example);

    int updateByPrimaryKeySelective(GoodsCategoryEntity record);

    int updateByPrimaryKey(GoodsCategoryEntity record);


    List<GoodsCategoryEntity> selectByParentId(Integer parentId);

    GoodsCategoryEntity selectByCategoryId(Integer parentId);

    List<GoodsCategoryEntity> selectByExampleNew(GoodsCategoryEntityExample example);


}