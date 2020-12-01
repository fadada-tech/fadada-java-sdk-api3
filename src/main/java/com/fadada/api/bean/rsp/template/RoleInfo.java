package com.fadada.api.bean.rsp.template;

import com.fadada.api.bean.BaseBean;

public class RoleInfo extends BaseBean {
    private String roleId;
    private String roleName;
    private Integer roleType;
    private Integer rolePermission;
    private Integer signSort;
    private Integer fillSort;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Integer getRolePermission() {
        return rolePermission;
    }

    public void setRolePermission(Integer rolePermission) {
        this.rolePermission = rolePermission;
    }

    public Integer getSignSort() {
        return signSort;
    }

    public void setSignSort(Integer signSort) {
        this.signSort = signSort;
    }

    public Integer getFillSort() {
        return fillSort;
    }

    public void setFillSort(Integer fillSort) {
        this.fillSort = fillSort;
    }
}
