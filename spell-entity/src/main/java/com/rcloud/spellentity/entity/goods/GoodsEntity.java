package com.rcloud.spellentity.entity.goods;

import com.alibaba.fastjson.annotation.JSONField;
import com.rcloud.spellentity.entity.Pages;
import com.rcloud.spellentity.entity.goodsdetails.GoodsDetailsEntity;
import com.rcloud.spellentity.entity.goodsevaluate.GoodsEvaluateEntity;

import java.util.Date;
import java.util.List;

public class GoodsEntity extends Pages {
    private String goodsId;

    private String goodsName;

    private String goodsPromotion;

    private Integer categoryId;

    private Integer lineationPrice;

    private Integer retailPrice;

    private Integer enterPrice;

    private Integer colonel;

    private Integer shippingFee;

    private String goodsMajorImg;

    private String goodsSlideshowImg;

    private String goodsDetailsImg;

    private Integer type;

    private Integer isStatus;

    private Integer repertory;

    private Integer salesVolume;

    private Integer virtualSalesVolume;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private List<GoodsDetailsEntity> goodsDetailsEntityList;

    private GoodsEvaluateEntity goodsEvaluateEntity;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsPromotion() {
        return goodsPromotion;
    }

    public void setGoodsPromotion(String goodsPromotion) {
        this.goodsPromotion = goodsPromotion == null ? null : goodsPromotion.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getLineationPrice() {
        return lineationPrice;
    }

    public void setLineationPrice(Integer lineationPrice) {
        this.lineationPrice = lineationPrice;
    }

    public Integer getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Integer retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getEnterPrice() {
        return enterPrice;
    }

    public void setEnterPrice(Integer enterPrice) {
        this.enterPrice = enterPrice;
    }

    public Integer getColonel() {
        return colonel;
    }

    public void setColonel(Integer colonel) {
        this.colonel = colonel;
    }

    public Integer getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Integer shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getGoodsMajorImg() {
        return goodsMajorImg;
    }

    public void setGoodsMajorImg(String goodsMajorImg) {
        this.goodsMajorImg = goodsMajorImg == null ? null : goodsMajorImg.trim();
    }

    public String getGoodsSlideshowImg() {
        return goodsSlideshowImg;
    }

    public void setGoodsSlideshowImg(String goodsSlideshowImg) {
        this.goodsSlideshowImg = goodsSlideshowImg == null ? null : goodsSlideshowImg.trim();
    }

    public String getGoodsDetailsImg() {
        return goodsDetailsImg;
    }

    public void setGoodsDetailsImg(String goodsDetailsImg) {
        this.goodsDetailsImg = goodsDetailsImg == null ? null : goodsDetailsImg.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(Integer isStatus) {
        this.isStatus = isStatus;
    }

    public Integer getRepertory() {
        return repertory;
    }

    public void setRepertory(Integer repertory) {
        this.repertory = repertory;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public Integer getVirtualSalesVolume() {
        return virtualSalesVolume;
    }

    public void setVirtualSalesVolume(Integer virtualSalesVolume) {
        this.virtualSalesVolume = virtualSalesVolume;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<GoodsDetailsEntity> getGoodsDetailsEntityList() {
        return goodsDetailsEntityList;
    }

    public void setGoodsDetailsEntityList(List<GoodsDetailsEntity> goodsDetailsEntityList) {
        this.goodsDetailsEntityList = goodsDetailsEntityList;
    }

    public GoodsEvaluateEntity getGoodsEvaluateEntity() {
        return goodsEvaluateEntity;
    }

    public void setGoodsEvaluateEntity(GoodsEvaluateEntity goodsEvaluateEntity) {
        this.goodsEvaluateEntity = goodsEvaluateEntity;
    }
}