package com.rcloud.spellweb.service.interfaces.prefecturegoods;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.goods.GoodsEntity;
import com.rcloud.spellentity.entity.prefecturegoods.PrefectureGoodsEntity;

import java.util.List;

/**
 * 专区商品
 *
 * @author xuchenguang
 * @since 2019.01.07
 */
public interface PrefectureGoodsService {


    int save(PrefectureGoodsEntity entity);

    int update(PrefectureGoodsEntity entity);

    List<PrefectureGoodsEntity> list(PrefectureGoodsEntity entity);

    PageInfo<PrefectureGoodsEntity> listPage(PrefectureGoodsEntity entity);

    PrefectureGoodsEntity getPrefectureGoods(Integer prefectureGoodsId);

    int delete(Integer pgId);

    /*
        PageInfo<PrefectureGoodsEntity> getPrefectureGoodsListPage(PrefectureGoodsEntity entity);

        List<PrefectureGoodsEntity> getPrefectureGoodsList(PrefectureGoodsEntity entity);
    */
    PageInfo<GoodsEntity> getGoodsList(PrefectureGoodsEntity entity);


}
