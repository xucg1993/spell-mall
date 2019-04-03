package com.rcloud.spelldao.dao.teamapplication;

import com.rcloud.spellentity.entity.teamapplication.TeamApplicationEntity;
import com.rcloud.spellentity.entity.teamapplication.TeamApplicationEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamApplicationEntityMapper {
    int countByExample(TeamApplicationEntityExample example);

    int deleteByExample(TeamApplicationEntityExample example);

    int deleteByPrimaryKey(Integer taId);

    int insert(TeamApplicationEntity record);

    int insertSelective(TeamApplicationEntity record);

    List<TeamApplicationEntity> selectByExample(TeamApplicationEntityExample example);

    TeamApplicationEntity selectByPrimaryKey(Integer taId);

    int updateByExampleSelective(@Param("record") TeamApplicationEntity record, @Param("example") TeamApplicationEntityExample example);

    int updateByExample(@Param("record") TeamApplicationEntity record, @Param("example") TeamApplicationEntityExample example);

    int updateByPrimaryKeySelective(TeamApplicationEntity record);

    int updateByPrimaryKey(TeamApplicationEntity record);


    TeamApplicationEntity selectByUserId(String taId);

}