package com.fadada.api.bean.req.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName TemplateInitReq.java
 * @Description 模板初始化请求对象
 * @Param
 * @createTime 2020年11月25日 14:47:00
 */
@ParamsVerif
public class TemplateInitReq extends BaseReq {
    @ParamsVerif
    private TemplateInfo templateInfo;

    @ParamsVerif
    public static class TemplateInfo extends BaseBean {
        @ParamsVerif(checkNotEmpty = true, maxLength = 50)
        private String templateName;
        @ParamsVerif(checkNotNull = false, maxLength = 50)
        private String templateRemark;
        @ParamsVerif(checkNotNull = false)
        private List<RoleInfo> roles;

        public String getTemplateName() {
            return templateName;
        }

        public void setTemplateName(String templateName) {
            this.templateName = templateName;
        }

        public String getTemplateRemark() {
            return templateRemark;
        }

        public void setTemplateRemark(String templateRemark) {
            this.templateRemark = templateRemark;
        }

        public List<RoleInfo> getRoles() {
            return roles;
        }

        public void setRoles(List<RoleInfo> roles) {
            this.roles = roles;
        }
    }

    @ParamsVerif
    public static class RoleInfo extends BaseBean {
        @ParamsVerif(checkNotEmpty = true)
        private String roleName;
        @ParamsVerif(intContains = {1, 2})
        private Integer roleType;
        @ParamsVerif(intContains = {1, 2, 3})
        private Integer rolePermission;

        private Integer signSort;
        private Integer fillSort;

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

    public TemplateInfo getTemplateInfo() {
        return templateInfo;
    }

    public void setTemplateInfo(TemplateInfo templateInfo) {
        this.templateInfo = templateInfo;
    }
}
