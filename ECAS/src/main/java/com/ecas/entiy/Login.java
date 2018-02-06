package com.ecas.entiy;


import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by lenovo on 2017/12/9.
 */
@Component
public class Login {

    private long userId;
    private String userName;
    private String password;
    private Date loginTime;
    private String loginIp;
    private boolean loginStatu;
    private String roleId;

    public Login() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public boolean isLoginStatu() {
        return loginStatu;
    }

    public void setLoginStatu(boolean loginStatu) {
        this.loginStatu = loginStatu;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", loginTime=" + loginTime +
                ", loginIp='" + loginIp + '\'' +
                ", loginStatu=" + loginStatu +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
