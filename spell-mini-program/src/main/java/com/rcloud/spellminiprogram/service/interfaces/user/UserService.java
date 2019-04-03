package com.rcloud.spellminiprogram.service.interfaces.user;

import com.rcloud.spellentity.entity.user.UserEntity;

/**
 * @author xuchenguang
 * @since 2019.01.07
 */
public interface UserService {


    int save(UserEntity entity);

    int update(UserEntity entity);


    /**
     * 通过openId  获取用户信息
     *
     * @param openId
     * @return
     */
    UserEntity findByAppletsOpenId(String openId);

    /**
     * 通过token获取用户id
     *
     * @return
     */
    String findUserIdByToken();


    String findToken();

    /**
     * 通过token查询用户信息
     *
     * @return
     */
    UserEntity findUserInfoByToken();


    UserEntity findUserInfoById(String userId);


    /**
     * 修改金额
     *
     * @param entity
     * @return
     */
    Integer updateUserAccountBalance(UserEntity entity);
}
