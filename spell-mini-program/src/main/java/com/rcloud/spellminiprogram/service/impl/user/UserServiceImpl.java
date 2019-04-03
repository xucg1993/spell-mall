package com.rcloud.spellminiprogram.service.impl.user;

import com.rcloud.spelldao.dao.user.UserEntityMapper;
import com.rcloud.spellentity.entity.user.UserEntity;
import com.rcloud.spellminiprogram.service.interfaces.user.UserService;
import com.rcloud.spellutils.utils.StringRedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xuchenguang
 * @since 2019.01.07
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserEntityMapper mapper;
    @Autowired
    private HttpServletRequest request;

    @Override
    public int save(UserEntity entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public int update(UserEntity entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public UserEntity findByAppletsOpenId(String openId) {

        return mapper.selectByOpenId(openId);
    }

    @Override
    public String findUserIdByToken() {
        String token = findToken();

        if (StringUtils.isBlank(token)) {
            return null;
        }

        return StringRedisUtils.get(token);
    }

    @Override
    public String findToken() {
        return request.getHeader("X-MiniProGram-Token");
    }

    @Override
    public UserEntity findUserInfoByToken() {
        String token = findToken();

        String userId = StringRedisUtils.get(token);

        if (StringUtils.isNotBlank(userId)) {
            return mapper.selectByPrimaryKey(userId);
        }

        return null;
    }


    @Override
    public UserEntity findUserInfoById(String userId) {
        return mapper.selectByPrimaryKey(userId);
    }

    @Override
    public Integer updateUserAccountBalance(UserEntity entity) {
        //查询用户信息
        UserEntity userEntity = mapper.selectByPrimaryKey(entity.getUserId());

        //当前金额
        int accountBalance = userEntity.getAccountBalance().intValue();

        //传入的金额
        int value = entity.getAccountBalance().intValue();

        int i = accountBalance + value;

        //可用余额不足
        if (i < 0) {
            return 0;
        }

        entity.setAccountBalance(accountBalance + value);

        return mapper.updateByPrimaryKeySelective(entity);
    }
}
