package com.rcloud.spellweb.service.interfaces.user;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.user.UserEntity;

/**
 * @author xuchenguang
 * @since 2019.01.07
 */
public interface UserService {

    /**
     * 通过openId  获取用户信息
     *
     * @param openId
     * @return
     */
    UserEntity findByAppletsOpenId(String openId);


    UserEntity findUserInfoById(String userId);


    PageInfo<UserEntity> listPage(UserEntity entity);

    /**
     * 修改金额
     *
     * @param entity
     * @return
     */
    Integer updateUserAccountBalance(UserEntity entity);
}
