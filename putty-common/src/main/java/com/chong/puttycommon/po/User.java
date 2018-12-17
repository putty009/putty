package com.chong.puttycommon.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author putty li
 */
public class User implements Serializable {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userEmail;

    private String userWechat;

    private String userMobile;

    private Integer isVip;

    private String userQq;

    private Date vipDeadDate;

    private Date registerTime;

    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    public User() {}
    public User(Integer id, String name) {
        userId = id;
        userName = name;
    }

    @Override
    public String toString() {
        return "userName: "+userName+";password: "+userPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserWechat() {
        return userWechat;
    }

    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    public Date getVipDeadDate() {
        return vipDeadDate;
    }

    public void setVipDeadDate(Date vipDeadDate) {
        this.vipDeadDate = vipDeadDate;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}