package com.rcloud.spellweb.controller.team;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.team.TeamEntity;
import com.rcloud.spellutils.utils.ResultJson;
import com.rcloud.spellweb.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 社团
 * @author xuchenguang
 * @since 2019.01.07
 */
@RestController
public class TeamController extends BaseController {

    public static final String CONTROLLER_NAME = "team";


    /**
     * 新增
     *
     * @param entity
     * @return
     */
    @PostMapping(CONTROLLER_NAME)
    public String save(TeamEntity entity) {

        loggerInfo("新增团");

        int save = teamService.save(entity);

        if (save > 0) {
            loggerInfo(SAVE_SUCCESS);
            return ResultJson.getResultJsonSuccess(SAVE_SUCCESS);
        }

        loggerError(SAVE_FAIL);

        return ResultJson.getResultJsonFail(SAVE_FAIL);
    }

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    @PutMapping(CONTROLLER_NAME)
    public String update(TeamEntity entity) {

        loggerInfo("修改团");

        int update = teamService.update(entity);

        if (update > 0) {
            loggerInfo(UPDATE_SUCCESS);
            return ResultJson.getResultJsonSuccess(UPDATE_SUCCESS);
        }

        loggerError(UPDATE_FAIL);

        return ResultJson.getResultJsonFail(UPDATE_FAIL);
    }


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
     * @param id
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/id")
    public String listPage(Integer id) {

        loggerInfo("团队列表 分页");

        TeamEntity entity = teamService.getTeamEntity(id);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, entity);
    }

}
