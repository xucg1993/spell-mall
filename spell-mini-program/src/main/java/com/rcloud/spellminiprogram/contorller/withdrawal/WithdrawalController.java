package com.rcloud.spellminiprogram.contorller.withdrawal;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.user.UserEntity;
import com.rcloud.spellentity.entity.withdrawal.WithdrawalEntity;
import com.rcloud.spellminiprogram.common.annotation.CheckLogin;
import com.rcloud.spellminiprogram.contorller.BaseController;
import com.rcloud.spellminiprogram.service.interfaces.withdrawal.WithdrawalService;
import com.rcloud.spellutils.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuchenguang
 * @since 2019.01.22
 */
@RestController
public class WithdrawalController extends BaseController {


    @Autowired
    WithdrawalService withdrawalService;

    private static final String CONTROLLER_NAME = "withdrawal";


    /**
     * 申请提现
     *
     * @param entity
     * @return
     */
    @CheckLogin
    @PostMapping(CONTROLLER_NAME)
    @Transactional(rollbackFor = Exception.class)
    public String save(WithdrawalEntity entity) throws Exception {

        //查询用户信息
        UserEntity userEntity = userService.findUserInfoByToken();

        //获取账户金额
        Integer accountBalance = userEntity.getAccountBalance();
        //需要提现的金额
        Integer money = entity.getMoney();
        //判断提现金额是否大于账户可提现余额
        if (accountBalance < money) {
            return ResultJson.getResultJsonFail(ResultJson.CODE_3, "提现金额大于可提现余额");
        }
        entity.setUserId(userEntity.getUserId());
        int save = withdrawalService.save(entity);

        if (save > 0) {
            UserEntity updateUser = new UserEntity();
            updateUser.setUserId(userEntity.getUserId());
            updateUser.setAccountBalance(-entity.getMoney());
            //扣除可提现金额
            Integer updateUserAccountBalance = userService.updateUserAccountBalance(updateUser);

            if (updateUserAccountBalance > 0) {
                return ResultJson.getResultJsonSuccess(SAVE_SUCCESS);
            }
        }
        return ResultJson.getResultJsonFail(SAVE_FAIL);
    }

    /**
     * 获取全部提现申请
     *
     * @return
     */
    @CheckLogin
    @GetMapping(CONTROLLER_NAME)
    public String listPage(WithdrawalEntity entity) {

        entity.setUserId(userService.findUserIdByToken());

        PageInfo<WithdrawalEntity> listPage = withdrawalService.listPage(entity);

        return ResultJson.getResultJsonSuccess(QUERY_SUCCESS, listPage);
    }
}
