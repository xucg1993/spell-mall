package com.rcloud.spellweb.service.impl.teamapplication;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rcloud.spelldao.dao.teamapplication.TeamApplicationEntityMapper;
import com.rcloud.spellentity.entity.teamapplication.TeamApplicationEntity;
import com.rcloud.spellentity.entity.teamapplication.TeamApplicationEntityExample;
import com.rcloud.spellweb.service.interfaces.teamapplication.TeamApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuchenguang
 * @since 2019.01.12
 */
@Service
public class TeamApplicationServiceImpl implements TeamApplicationService {


    @Autowired
    TeamApplicationEntityMapper mapper;


    @Override
    public int save(TeamApplicationEntity entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public int update(TeamApplicationEntity entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public PageInfo<TeamApplicationEntity> listPage(TeamApplicationEntity entity) {

        PageHelper.startPage(entity.getPageNum(), entity.getPageSize());

        TeamApplicationEntityExample example = new TeamApplicationEntityExample();

        TeamApplicationEntityExample.Criteria criteria = example.createCriteria();

        if (entity.getIsStatus() != null) {
            criteria.andIsStatusEqualTo(entity.getIsStatus());
        }

        return null;
    }

    @Override
    public TeamApplicationEntity getTeamApplicationByUserId(String userId) {
        return mapper.selectByUserId(userId);
    }

    @Override
    public TeamApplicationEntity getTeamApplicationByTaId(Integer taId) {
        return mapper.selectByPrimaryKey(taId);
    }
}
