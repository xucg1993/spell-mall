package com.rcloud.spelldao.dao.useraddress;

import com.rcloud.spellentity.entity.useraddress.UserAddressEntity;
import com.rcloud.spellentity.entity.useraddress.UserAddressEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserAddressEntityMapper {
    int countByExample(UserAddressEntityExample example);

    int deleteByExample(UserAddressEntityExample example);

    int deleteByPrimaryKey(String addressId);

    int insert(UserAddressEntity record);

    int insertSelective(UserAddressEntity record);

    List<UserAddressEntity> selectByExample(UserAddressEntityExample example);

    UserAddressEntity selectByPrimaryKey(String addressId);

    int updateByExampleSelective(@Param("record") UserAddressEntity record, @Param("example") UserAddressEntityExample example);

    int updateByExample(@Param("record") UserAddressEntity record, @Param("example") UserAddressEntityExample example);

    int updateByPrimaryKeySelective(UserAddressEntity record);

    int updateByPrimaryKey(UserAddressEntity record);

    UserAddressEntity getUserAddressByDefault(String userId);
}