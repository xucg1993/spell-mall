package com.rcloud.spelldao.dao.user;

import com.rcloud.spellentity.entity.user.UserEntity;
import com.rcloud.spellentity.entity.user.UserEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserEntityMapper {
    int countByExample(UserEntityExample example);

    int deleteByExample(UserEntityExample example);

    int deleteByPrimaryKey(String userId);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    List<UserEntity> selectByExample(UserEntityExample example);

    UserEntity selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    int updateByExample(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);


    UserEntity selectByOpenId(String openId);

}