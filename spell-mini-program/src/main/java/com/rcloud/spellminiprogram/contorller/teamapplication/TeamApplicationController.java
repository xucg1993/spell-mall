package com.rcloud.spellminiprogram.contorller.teamapplication;

import com.rcloud.spellentity.entity.teamapplication.TeamApplicationEntity;
import com.rcloud.spellminiprogram.common.annotation.CheckLogin;
import com.rcloud.spellminiprogram.contorller.BaseController;
import com.rcloud.spellminiprogram.service.interfaces.teamapplication.TeamApplicationService;
import com.rcloud.spellutils.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuchenguang
 * @since 2019.01.12
 */
@RestController
public class TeamApplicationController extends BaseController {


    @Autowired
    protected TeamApplicationService teamApplicationService;

    private static final String CONTROLLER_NAME = "teamApplication";


    /**
     * 提交申请
     *
     * @param entity
     * @return
     */
    @CheckLogin
    @PostMapping(CONTROLLER_NAME)
    public String save(TeamApplicationEntity entity) {

        String userId = userService.findUserIdByToken();

        TeamApplicationEntity application = teamApplicationService.getTeamApplicationByUserId(userId);

        if (application != null) {
            return ResultJson.getResultJsonFail(ResultJson.CODE_3, "您已经提交过申请，请勿重复提交");
        }

        int save = teamApplicationService.save(entity);

        if (save > 0) {
            return ResultJson.getResultJsonSuccess(SAVE_SUCCESS);
        }
        return ResultJson.getResultJsonFail(SAVE_FAIL);
    }


    /**
     * 查询申请记录
     *
     * @return
     */
    @CheckLogin
    @GetMapping(CONTROLLER_NAME)
    public String get() {
        String userId = userService.findUserIdByToken();

        TeamApplicationEntity application = teamApplicationService.getTeamApplicationByUserId(userId);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, application);
    }
}
