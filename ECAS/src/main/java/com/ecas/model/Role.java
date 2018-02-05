package com.ecas.model;

import com.ecas.common.base.model.BaseEntiy;

import java.util.Date;

/**
 * Created by lenovo on 2017/12/20.
 */
public class Role extends BaseEntiy {
    private int roleId;
    private String roleName;
    private String roleType;
    private String roleLevel;


    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(String roleLevel) {
        this.roleLevel = roleLevel;
    }


}
