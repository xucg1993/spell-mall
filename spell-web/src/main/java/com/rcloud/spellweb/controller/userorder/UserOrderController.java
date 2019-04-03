package com.rcloud.spellweb.controller.userorder;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.userorder.UserOrderEntity;
import com.rcloud.spellutils.utils.ResultJson;
import com.rcloud.spellweb.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单
 *
 * @author xuchenguang
 * @since 2019.01.07
 */
@RestController
public class UserOrderController extends BaseController {

    public static final String CONTROLLER_NAME = "userOrder";

    /**
     * 查询所有订单
     *
     * @param entity
     * @return
     */
    @GetMapping(CONTROLLER_NAME)
    public String listPage(UserOrderEntity entity) {

        loggerInfo("查询所有订单");

        PageInfo<UserOrderEntity> listPage = userOrderService.listPage(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, listPage);

    }

    /**
     * 订单详情
     *
     * @param orderId
     * @return
     */
    @GetMapping(CONTROLLER_NAME + "/id")
    public String getUserOrder(String orderId) {

        loggerInfo("查询订单详情");

        UserOrderEntity entity = userOrderService.getUserOrder(orderId);

        if (entity != null) {
            entity.setTeamEntity(teamService.getTeamEntity(entity.getTeamId()));
            entity.setUserEntity(userService.findUserInfoById(entity.getUserId()));
        }

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, entity);

    }

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    @PutMapping(CONTROLLER_NAME)
    public String update(UserOrderEntity entity) {
        loggerInfo("修改订单");

        int update = userOrderService.update(entity);

        if (update > 0) {
            loggerInfo(UPDATE_SUCCESS);
            return ResultJson.getResultJsonSuccess(UPDATE_SUCCESS);
        }
        loggerError(UPDATE_FAIL);
        return ResultJson.getResultJsonFail(UPDATE_FAIL);
    }
}
