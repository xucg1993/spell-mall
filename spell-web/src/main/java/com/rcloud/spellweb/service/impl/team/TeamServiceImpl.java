package com.rcloud.spellweb.service.impl.team;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rcloud.spelldao.dao.team.TeamEntityMapper;
import com.rcloud.spellentity.entity.team.TeamEntity;
import com.rcloud.spellentity.entity.team.TeamEntityExample;
import com.rcloud.spellweb.service.interfaces.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.07
 */
@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamEntityMapper mapper;

    @Override
    public int save(TeamEntity entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public int update(TeamEntity entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<TeamEntity> list(TeamEntity entity) {

        TeamEntityExample example = new TeamEntityExample();

        List<TeamEntity> list = mapper.selectByExample(example);

        return list;
    }

    @Override
    public PageInfo<TeamEntity> listPage(TeamEntity entity) {

        PageHelper.startPage(entity.getPageNum(), entity.getPageSize());

        TeamEntityExample example = new TeamEntityExample();

        List<TeamEntity> list = mapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    @Override
    public TeamEntity getTeamEntity(Integer teamId) {
        return mapper.selectByPrimaryKey(teamId);
    }
}
