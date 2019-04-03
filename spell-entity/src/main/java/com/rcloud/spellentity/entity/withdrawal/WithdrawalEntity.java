package com.rcloud.spellentity.entity.withdrawal;

import com.rcloud.spellentity.entity.Pages;

import java.util.Date;

public class WithdrawalEntity extends Pages {
    private Integer mwId;

    private String userId;

    private Integer type;

    private Integer teamId;

    private Integer money;

    private Integer isStatus;

    private Date createTime;

    private Date updateTime;

    public Integer getMwId() {
        return mwId;
    }

    public void setMwId(Integer mwId) {
        this.mwId = mwId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(Integer isStatus) {
        this.isStatus = isStatus;
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
}