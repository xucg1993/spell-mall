package com.rcloud.spellminiprogram.contorller.team;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.team.TeamEntity;
import com.rcloud.spellminiprogram.common.annotation.CheckLogin;
import com.rcloud.spellminiprogram.contorller.BaseController;
import com.rcloud.spellminiprogram.service.interfaces.team.TeamService;
import com.rcloud.spellutils.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 社团
 *
 * @author xuchenguang
 * @since 2019.01.07
 */
@RestController
public class TeamController extends BaseController {

    /**
     * 团队
     */
    @Autowired
    protected TeamService teamService;

    public static final String CONTROLLER_NAME = "team";


    /**
     * 无分页  列表
     *
     * @param entity
     * @return
     */
    @GetMapping(CONTROLLER_NAME)
    public String list(TeamEntity entity) {

        loggerInfo("团列表");

        List<TeamEntity> list = teamService.list(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, list);
    }

    /**
     * 分页  列表
     *
     * @param entity
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/page")
    public String listPage(TeamEntity entity) {

        loggerInfo("团列表 分页");

        PageInfo<TeamEntity> list = teamService.listPage(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, list);
    }

    /**
     * 详情
     *
     * @param teamId
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/id")
    public String getTeam(Integer teamId) {

        loggerInfo("团队详情");

        TeamEntity entity = teamService.getTeamEntity(teamId);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, entity);
    }

    /**
     * 详情
     *
     * @return
     */
    @CheckLogin
    @GetMapping(CONTROLLER_NAME + "/user")
    public String getTeamByUserId() {

        loggerInfo("团队详情");

        String userId = userService.findUserIdByToken();

        TeamEntity entity = teamService.getTeamEntityByUserId(userId);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, entity);
    }

}
