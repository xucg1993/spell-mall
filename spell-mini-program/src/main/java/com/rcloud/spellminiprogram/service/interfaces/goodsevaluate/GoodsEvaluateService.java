package com.rcloud.spellminiprogram.service.interfaces.goodsevaluate;

import com.github.pagehelper.PageInfo;
import com.rcloud.spellentity.entity.goodsevaluate.GoodsEvaluateEntity;

import java.util.List;

/**
 * 商品评论
 *
 * @author xuchenguang
 * @since 2019.01.10
 */
public interface GoodsEvaluateService {


    int save(GoodsEvaluateEntity evaluateEntity);


    List<GoodsEvaluateEntity> list(GoodsEvaluateEntity entity);

    
    PageInfo<GoodsEvaluateEntity> listPage(GoodsEvaluateEntity entity);


}
