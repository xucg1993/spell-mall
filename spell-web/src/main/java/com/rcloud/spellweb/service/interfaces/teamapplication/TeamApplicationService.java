package com.rcloud.spellweb.service.interfaces.teamapplication;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.teamapplication.TeamApplicationEntity;

/**
 * 团长申请
 *
 * @author xuchenguang
 * @since 2019.01.12
 */
public interface TeamApplicationService {


    /**
     * 保存
     *
     * @param entity
     * @return
     */
    int save(TeamApplicationEntity entity);

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    int update(TeamApplicationEntity entity);


    /**
     * 列表  分页
     *
     * @param entity
     * @return
     */
    PageInfo<TeamApplicationEntity> listPage(TeamApplicationEntity entity);


    /**
     * 通过userId查询
     *
     * @param userId
     * @return
     */
    TeamApplicationEntity getTeamApplicationByUserId(String userId);


    TeamApplicationEntity getTeamApplicationByTaId(Integer taId);


}
