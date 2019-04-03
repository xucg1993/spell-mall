package com.rcloud.spellminiprogram.service.impl.useraddress;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rcloud.spelldao.dao.useraddress.UserAddressEntityMapper;
import com.rcloud.spellentity.entity.useraddress.UserAddressEntity;
import com.rcloud.spellentity.entity.useraddress.UserAddressEntityExample;
import com.rcloud.spellminiprogram.service.interfaces.useraddress.UserAddressService;
import com.rcloud.spellutils.utils.BaseUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.08
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    UserAddressEntityMapper mapper;


    @Override
    public int save(UserAddressEntity entity) {
        entity.setAddressId(BaseUtils.generateUUId());
        return mapper.insertSelective(entity);
    }

    @Override
    public int update(UserAddressEntity entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<UserAddressEntity> list(UserAddressEntity entity) {

        PageHelper.startPage(entity.getPageNum(), entity.getPageSize());

        UserAddressEntityExample example = new UserAddressEntityExample();

        UserAddressEntityExample.Criteria criteria = example.createCriteria();
        //未删除
        criteria.andIsDeleteEqualTo(0);

        if (StringUtils.isNoneBlank(entity.getUserId())) {
            criteria.andUserIdEqualTo(entity.getUserId());
        }

        if (entity.getIsDefault() != null) {
            criteria.andIsDefaultEqualTo(2);
        }

        example.setOrderByClause("create_time desc");

        List<UserAddressEntity> list = mapper.selectByExample(example);

        return list;
    }

    @Override
    public PageInfo<UserAddressEntity> listPage(UserAddressEntity entity) {

        PageHelper.startPage(entity.getPageNum(), entity.getPageSize());

        UserAddressEntityExample example = new UserAddressEntityExample();

        UserAddressEntityExample.Criteria criteria = example.createCriteria();
        //未删除
        criteria.andIsDeleteEqualTo(0);

        if (StringUtils.isNoneBlank(entity.getUserId())) {
            criteria.andUserIdEqualTo(entity.getUserId());
        }

        if (entity.getIsDefault() != null) {
            criteria.andIsDefaultEqualTo(2);
        }

        example.setOrderByClause("create_time desc");

        List<UserAddressEntity> list = mapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    @Override
    public UserAddressEntity getUserAddress(String addressId) {
        return mapper.selectByPrimaryKey(addressId);
    }

    @Override
    public UserAddressEntity getUserAddressByDefault(String userId) {
        return mapper.getUserAddressByDefault(userId);
    }

    @Override
    public int updateDefault(UserAddressEntity entity) {

        UserAddressEntity addressByDefault = getUserAddressByDefault(entity.getUserId());

        if (addressByDefault != null) {
            UserAddressEntity updateDefault = new UserAddressEntity();
            updateDefault.setAddressId(addressByDefault.getAddressId());
            updateDefault.setIsDefault(0);
            return mapper.updateByPrimaryKeySelective(updateDefault);
        }

        return 1;
    }

    @Override
    public int count(UserAddressEntity entity) {
        UserAddressEntityExample example = new UserAddressEntityExample();

        UserAddressEntityExample.Criteria criteria = example.createCriteria();
        //未删除
        criteria.andIsDeleteEqualTo(0);

        if (StringUtils.isNoneBlank(entity.getUserId())) {
            criteria.andUserIdEqualTo(entity.getUserId());
        }

        if (entity.getIsDefault() != null) {
            criteria.andIsDefaultEqualTo(2);
        }
        return mapper.countByExample(example);
    }
}
