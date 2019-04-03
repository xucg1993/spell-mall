package com.rcloud.spellentity.entity.goodscategory;

import com.alibaba.fastjson.annotation.JSONField;
import com.rcloud.spellentity.entity.Pages;
import com.rcloud.spellentity.entity.goods.GoodsEntity;

import java.util.Date;
import java.util.List;

public class GoodsCategoryEntity extends Pages {
    private Integer categoryId;

    private String categoryName;

    private Integer parentId;

    private String imgUrl;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private Integer isStatus;

    private List<GoodsEntity> goodsEntityList;

    private List<GoodsCategoryEntity> goodsCategoryEntityList;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
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

    public Integer getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(Integer isStatus) {
        this.isStatus = isStatus;
    }

    public List<GoodsEntity> getGoodsEntityList() {
        return goodsEntityList;
    }

    public void setGoodsEntityList(List<GoodsEntity> goodsEntityList) {
        this.goodsEntityList = goodsEntityList;
    }

    public List<GoodsCategoryEntity> getGoodsCategoryEntityList() {
        return goodsCategoryEntityList;
    }

    public void setGoodsCategoryEntityList(List<GoodsCategoryEntity> goodsCategoryEntityList) {
        this.goodsCategoryEntityList = goodsCategoryEntityList;
    }
}