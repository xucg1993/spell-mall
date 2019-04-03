package com.rcloud.spellminiprogram.service.impl.ordergoods;

import com.rcloud.spelldao.dao.ordergoods.OrderGoodsEntityMapper;
import com.rcloud.spellentity.entity.ordergoods.OrderGoodsEntity;
import com.rcloud.spellminiprogram.service.interfaces.ordergoods.OrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuchenguang
 * @since 2019.01.08
 */
@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {


    @Autowired
    OrderGoodsEntityMapper mapper;

    @Override
    public int save(OrderGoodsEntity entity) {
        return mapper.insertSelective(entity);
    }
}
