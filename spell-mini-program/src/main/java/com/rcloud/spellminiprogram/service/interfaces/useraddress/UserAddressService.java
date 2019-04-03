package com.rcloud.spellminiprogram.service.interfaces.useraddress;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.useraddress.UserAddressEntity;

import java.util.List;

/**
 * 收货地址
 *
 * @author xuchenguang
 * @since 2019.01.08
 */
public interface UserAddressService {


    int save(UserAddressEntity entity);

    int update(UserAddressEntity entity);

    List<UserAddressEntity> list(UserAddressEntity entity);

    PageInfo<UserAddressEntity> listPage(UserAddressEntity entity);

    UserAddressEntity getUserAddress(String addressId);


    /**
     * 默认地址
     *
     * @param userId
     * @return
     */
    UserAddressEntity getUserAddressByDefault(String userId);

    /**
     * 修改默认  此方法是去除上次默认地址
     *
     * @param entity
     * @return
     */
    int updateDefault(UserAddressEntity entity);


    int count(UserAddressEntity entity);
}
