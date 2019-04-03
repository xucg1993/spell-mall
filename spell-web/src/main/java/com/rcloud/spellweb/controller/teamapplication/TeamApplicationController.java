package com.rcloud.spellweb.controller.teamapplication;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.teamapplication.TeamApplicationEntity;
import com.rcloud.spellutils.utils.ResultJson;
import com.rcloud.spellweb.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuchenguang
 * @since 2019.01.12
 */
@RestController
public class TeamApplicationController extends BaseController {

    private static final String CONTROLLER_NAME = "teamApplication";


    /**
     * 查询申请记录
     *
     * @return
     */
    @GetMapping(CONTROLLER_NAME)
    public String get(Integer taId) {

        TeamApplicationEntity application = teamApplicationService.getTeamApplicationByTaId(taId);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, application);
    }


    /**
     * 获取申请列表
     *
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/page")
    public String listPage(TeamApplicationEntity entity) {
        PageInfo<TeamApplicationEntity> listPage = teamApplicationService.listPage(entity);


        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, listPage);
    }


    /**
     * 修改
     *
     * @param entity
     * @return
     */
    @PutMapping(CONTROLLER_NAME)
    public String save(TeamApplicationEntity entity) {


        int update = teamApplicationService.update(entity);

        if (update > 0) {
            return ResultJson.getResultJsonSuccess(UPDATE_SUCCESS);
        }
        return ResultJson.getResultJsonFail(UPDATE_FAIL);
    }


}
