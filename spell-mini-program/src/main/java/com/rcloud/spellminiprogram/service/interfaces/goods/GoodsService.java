package com.rcloud.spellminiprogram.service.interfaces.goods;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.goods.GoodsEntity;

import java.util.List;

/**
 * @author xuchenguang
 * @since 2019.01.06
 */
public interface GoodsService {


    /**
     * 保存商品
     *
     * @param entity
     * @return
     */
    int save(GoodsEntity entity);


    /**
     * 修改商品
     *
     * @param entity
     * @return
     */
    int update(GoodsEntity entity);


    /**
     * 查询列表 带分页
     *
     * @param entity
     * @return
     */
    PageInfo<GoodsEntity> listPage(GoodsEntity entity);

    /**
     * 查询列表
     *
     * @param entity
     * @return
     */
    List<GoodsEntity> list(GoodsEntity entity);

    /**
     * 查询商品详情
     *
     * @param goodsId
     * @return
     */
    GoodsEntity getGoods(String goodsId);

}
