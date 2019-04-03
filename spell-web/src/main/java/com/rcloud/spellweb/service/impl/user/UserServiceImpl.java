package com.rcloud.spellweb.service.impl.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rcloud.spelldao.dao.user.UserEntityMapper;
import com.rcloud.spellentity.entity.user.UserEntity;
import com.rcloud.spellentity.entity.user.UserEntityExample;
import com.rcloud.spellweb.service.interfaces.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public UserEntity findByAppletsOpenId(String openId) {

        return mapper.selectByOpenId(openId);
    }


    @Override
    public UserEntity findUserInfoById(String userId) {
        return mapper.selectByPrimaryKey(userId);
    }

    @Override
    public PageInfo<UserEntity> listPage(UserEntity entity) {

        PageHelper.startPage(entity.getPageNum(), entity.getPageSize());

        UserEntityExample example = new UserEntityExample();

        UserEntityExample.Criteria criteria = example.createCriteria();

        List<UserEntity> list = mapper.selectByExample(example);

        return new PageInfo<>(list);
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
