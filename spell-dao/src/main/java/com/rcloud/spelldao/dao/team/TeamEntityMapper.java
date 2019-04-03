package com.rcloud.spelldao.dao.team;

import com.rcloud.spellentity.entity.team.TeamEntity;
import com.rcloud.spellentity.entity.team.TeamEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamEntityMapper {
    int countByExample(TeamEntityExample example);

    int deleteByExample(TeamEntityExample example);

    int deleteByPrimaryKey(Integer teamId);

    int insert(TeamEntity record);

    int insertSelective(TeamEntity record);

    List<TeamEntity> selectByExample(TeamEntityExample example);

    TeamEntity selectByPrimaryKey(Integer teamId);

    int updateByExampleSelective(@Param("record") TeamEntity record, @Param("example") TeamEntityExample example);

    int updateByExample(@Param("record") TeamEntity record, @Param("example") TeamEntityExample example);

    int updateByPrimaryKeySelective(TeamEntity record);

    int updateByPrimaryKey(TeamEntity record);

    TeamEntity selectByUserId(String userId);

}