package com.rcloud.spelldao.dao.prefecture;

import com.rcloud.spellentity.entity.prefecture.PrefectureEntity;
import com.rcloud.spellentity.entity.prefecture.PrefectureEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrefectureEntityMapper {
    int countByExample(PrefectureEntityExample example);

    int deleteByExample(PrefectureEntityExample example);

    int deleteByPrimaryKey(Integer prefectureId);

    int insert(PrefectureEntity record);

    int insertSelective(PrefectureEntity record);

    List<PrefectureEntity> selectByExample(PrefectureEntityExample example);

    PrefectureEntity selectByPrimaryKey(Integer prefectureId);

    int updateByExampleSelective(@Param("record") PrefectureEntity record, @Param("example") PrefectureEntityExample example);

    int updateByExample(@Param("record") PrefectureEntity record, @Param("example") PrefectureEntityExample example);

    int updateByPrimaryKeySelective(PrefectureEntity record);

    int updateByPrimaryKey(PrefectureEntity record);
}