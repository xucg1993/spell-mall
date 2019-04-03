package com.rcloud.spellentity.entity.team;

import com.rcloud.spellentity.entity.Pages;
import com.rcloud.spellentity.entity.user.UserEntity;

public class TeamEntity extends Pages {
    private Integer teamId;

    private String userId;

    private String teamName;

    private String linkman;

    private String phone;

    private String address;

    private Integer isStatus;

    private String longitude;

    private String latitude;

    private Integer isDelete;

    private String departmentId;

    private String qyUserId;

    private String contactMeId;

    private UserEntity userEntity;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(Integer isStatus) {
        this.isStatus = isStatus;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getQyUserId() {
        return qyUserId;
    }

    public void setQyUserId(String qyUserId) {
        this.qyUserId = qyUserId == null ? null : qyUserId.trim();
    }

    public String getContactMeId() {
        return contactMeId;
    }

    public void setContactMeId(String contactMeId) {
        this.contactMeId = contactMeId == null ? null : contactMeId.trim();
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}