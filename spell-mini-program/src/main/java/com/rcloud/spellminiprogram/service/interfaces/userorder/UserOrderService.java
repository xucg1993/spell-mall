package com.rcloud.spellminiprogram.service.interfaces.userorder;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.userorder.UserOrderEntity;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.07
 */
public interface UserOrderService {

    /**
     * 保存订单
     *
     * @param entity
     * @return
     */
    int save(UserOrderEntity entity);

    /**
     * 查询所有订单
     *
     * @param entity
     * @return
     */
    PageInfo<UserOrderEntity> listPage(UserOrderEntity entity);



    List<UserOrderEntity> list(UserOrderEntity entity);


    /**
     * 修改
     *
     * @param entity
     * @return
     */
    int update(UserOrderEntity entity);


    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    UserOrderEntity getUserOrder(String orderId);


    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    UserOrderEntity getUserOrderCode(String orderCode);


    int getCount(UserOrderEntity entity);
}
