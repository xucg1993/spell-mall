package com.rcloud.spellminiprogram.service.interfaces.team;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.team.TeamEntity;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.07
 */
public interface TeamService {

    /**
     * 保存
     *
     * @param entity
     * @return
     */
    int save(TeamEntity entity);

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    int update(TeamEntity entity);

    /**
     * 列表 无分页
     *
     * @param entity
     * @return
     */
    List<TeamEntity> list(TeamEntity entity);

    /**
     * 列表 分页
     *
     * @param entity
     * @return
     */
    PageInfo<TeamEntity> listPage(TeamEntity entity);

    /**
     * 详情
     *
     * @param teamId
     * @return
     */
    TeamEntity getTeamEntity(Integer teamId);



    TeamEntity getTeamEntityByUserId(String teamId);
}
