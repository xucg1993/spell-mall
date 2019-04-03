package com.rcloud.spellentity.entity.userorder;

import com.alibaba.fastjson.annotation.JSONField;
import com.rcloud.spellentity.entity.Pages;
import com.rcloud.spellentity.entity.ordergoods.OrderGoodsEntity;
import com.rcloud.spellentity.entity.team.TeamEntity;
import com.rcloud.spellentity.entity.user.UserEntity;

import java.util.Date;
import java.util.List;

public class UserOrderEntity extends Pages {
    private String orderId;

    private String orderCode;

    private Integer orderAmount;

    private Integer payAmount;

    private Integer payType;

    private Integer isPay;

    private Integer isStatus;

    private Integer evaluateStatus;

    private String userId;

    private Integer teamId;

    private Integer clearingStatus;

    private Integer colonel;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date payTime;

    private String addressId;

    private String address;

    private String phone;

    private String consignee;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date deliveryTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String formId;

    private Integer shippingFee;

    private List<OrderGoodsEntity> orderGoodsEntityList;

    private String orderGoodsList;

    private UserEntity userEntity;

    private TeamEntity teamEntity;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Integer getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(Integer isStatus) {
        this.isStatus = isStatus;
    }

    public Integer getEvaluateStatus() {
        return evaluateStatus;
    }

    public void setEvaluateStatus(Integer evaluateStatus) {
        this.evaluateStatus = evaluateStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getColonel() {
        return colonel;
    }

    public void setColonel(Integer colonel) {
        this.colonel = colonel;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
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

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId == null ? null : formId.trim();
    }

    public Integer getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Integer shippingFee) {
        this.shippingFee = shippingFee;
    }

    public List<OrderGoodsEntity> getOrderGoodsEntityList() {
        return orderGoodsEntityList;
    }

    public void setOrderGoodsEntityList(List<OrderGoodsEntity> orderGoodsEntityList) {
        this.orderGoodsEntityList = orderGoodsEntityList;
    }

    public String getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(String orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public TeamEntity getTeamEntity() {
        return teamEntity;
    }

    public void setTeamEntity(TeamEntity teamEntity) {
        this.teamEntity = teamEntity;
    }

    public Integer getClearingStatus() {
        return clearingStatus;
    }

    public void setClearingStatus(Integer clearingStatus) {
        this.clearingStatus = clearingStatus;
    }
}