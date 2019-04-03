package com.rcloud.spellweb.controller.withdrawal;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.user.UserEntity;
import com.rcloud.spellentity.entity.withdrawal.WithdrawalEntity;
import com.rcloud.spellutils.utils.ResultJson;
import com.rcloud.spellweb.controller.BaseController;
import com.rcloud.spellweb.service.interfaces.withdrawal.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提现
 *
 * @author xuchenguang
 * @since 2019.01.22
 */
@RestController
public class WithdrawalController extends BaseController {


    @Autowired
    WithdrawalService withdrawalService;

    private static final String CONTROLLER_NAME = "withdrawal";


    /**
     * 提现审批
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @PutMapping(CONTROLLER_NAME)
    @Transactional(rollbackFor = Exception.class)
    public String update(WithdrawalEntity entity) throws Exception {

        //查询提现信息
        WithdrawalEntity wEntity = withdrawalService.getWithdrawal(entity.getMwId());


        if (wEntity.getIsStatus().equals(entity.getIsStatus())) {
            return ResultJson.getResultJsonFail("请勿重复操作");
        }

        WithdrawalEntity updateEntity = new WithdrawalEntity();
        if (wEntity != null) {
            //待审核
            if (entity.getIsStatus() == 1) {

            }
            //已审核
            if (entity.getIsStatus() == 2) {
                updateEntity.setMwId(wEntity.getMwId());
                updateEntity.setIsStatus(2);
                int update = withdrawalService.update(updateEntity);
                if (update > 0) {
                    return ResultJson.getResultJsonSuccess(UPDATE_SUCCESS);
                }
            }
            //拒绝
            if (entity.getIsStatus() == 3) {
                //将金额退还
                updateEntity.setMwId(wEntity.getMwId());
                updateEntity.setIsStatus(2);
                int update = withdrawalService.update(updateEntity);

                //回滚用户金额
                UserEntity userEntity = new UserEntity();
                userEntity.setUserId(wEntity.getUserId());
                userEntity.setAccountBalance(wEntity.getMoney());
                Integer updateUserAccountBalance = userService.updateUserAccountBalance(userEntity);

                if (update > 0 && updateUserAccountBalance > 0) {
                    return ResultJson.getResultJsonSuccess(UPDATE_SUCCESS);
                }
            }
        }

        return ResultJson.getResultJsonFail(UPDATE_FAIL);

    }


    /**
     * 获取全部提现申请
     *
     * @return
     */
    @GetMapping(CONTROLLER_NAME)
    public String listPage(WithdrawalEntity entity) {

        PageInfo<WithdrawalEntity> listPage = withdrawalService.listPage(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, listPage);
    }

}
