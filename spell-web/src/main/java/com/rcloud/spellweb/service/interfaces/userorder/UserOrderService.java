package com.rcloud.spellweb.service.interfaces.userorder;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.userorder.UserOrderEntity;

/**
 * @author xuchenguang
 * @since 2019.01.07
 */
public interface UserOrderService {


    /**
     * 查询所有订单
     *
     * @param entity
     * @return
     */
    PageInfo<UserOrderEntity> listPage(UserOrderEntity entity);


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
}
