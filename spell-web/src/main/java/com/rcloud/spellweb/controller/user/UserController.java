package com.rcloud.spellweb.controller.user;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.user.UserEntity;
import com.rcloud.spellutils.utils.ResultJson;
import com.rcloud.spellweb.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理
 *
 * @author xuchenguang
 * @since 2019.01.17
 */
@RestController
public class UserController extends BaseController {

    private static final String CONTROLLER_NAME = "user";


    @GetMapping(CONTROLLER_NAME)
    public String listPage(UserEntity entity) {

        PageInfo<UserEntity> listPage = userService.listPage(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, listPage);
    }
}
