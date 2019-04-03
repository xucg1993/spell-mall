package com.rcloud.spellentity.entity.prefecturegoods;

import com.rcloud.spellentity.entity.Pages;
import com.rcloud.spellentity.entity.goods.GoodsEntity;
import com.rcloud.spellentity.entity.prefecture.PrefectureEntity;

public class PrefectureGoodsEntity extends Pages {
    private Integer pgId;

    private Integer prefectureId;

    private String goodsId;

    private Integer isShow;

    private GoodsEntity goodsEntity;

    private PrefectureEntity prefectureEntity;

    public Integer getPgId() {
        return pgId;
    }

    public void setPgId(Integer pgId) {
        this.pgId = pgId;
    }

    public Integer getPrefectureId() {
        return prefectureId;
    }

    public void setPrefectureId(Integer prefectureId) {
        this.prefectureId = prefectureId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public GoodsEntity getGoodsEntity() {
        return goodsEntity;
    }

    public void setGoodsEntity(GoodsEntity goodsEntity) {
        this.goodsEntity = goodsEntity;
    }

    public PrefectureEntity getPrefectureEntity() {
        return prefectureEntity;
    }

    public void setPrefectureEntity(PrefectureEntity prefectureEntity) {
        this.prefectureEntity = prefectureEntity;
    }
}