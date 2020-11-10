package com.fadada.api.bean.rsp.document;


import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @className TemplateTargetRsp
 * @description 模板target信息
 * @createTime 2020年9月7日 19:35:20
 */
public class TemplateTargetRsp extends BaseBean {

    private String targetId;

    private String roleName;

    private Integer roleType;

    private Integer sortNum;

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
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

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
}