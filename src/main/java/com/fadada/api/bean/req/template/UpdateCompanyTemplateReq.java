package com.fadada.api.bean.req.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

import java.util.List;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName UpdateCompanyTemplateReq.java
 * @Description 修改企业模板信息请求对象
 * @Param
 * @createTime 2020年07月23日 17:12:00
 */
@ParamsVerif
public class UpdateCompanyTemplateReq extends BaseReq {
    @ParamsVerif
    private TemplateInfo templateInfo;

    @ParamsVerif
    public static class TemplateInfo extends BaseBean {

        @ParamsVerif(checkNotEmpty = true)
        private String templateId;

        @ParamsVerif(maxLength = 50)
        private String templateName;

        @ParamsVerif(checkNotNull = false, maxLength = 50)
        private String templateRemark;

        @ParamsVerif(intContains = {1, 2})
        private Integer sortType;

        @ParamsVerif
        private List<Target> targets;

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }

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

        public Integer getSortType() {
            return sortType;
        }

        public void setSortType(Integer sortType) {
            this.sortType = sortType;
        }

        public List<Target> getTargets() {
            return targets;
        }

        public void setTargets(List<Target> targets) {
            this.targets = targets;
        }
    }

    @ParamsVerif
    public static class Target extends BaseBean {

        private String targetId;

        @ParamsVerif(maxLength = 32)
        private String roleName;

        @ParamsVerif(intContains = {1, 2})
        private Integer roleType;

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
    }

    public TemplateInfo getTemplateInfo() {
        return templateInfo;
    }

    public void setTemplateInfo(TemplateInfo templateInfo) {
        this.templateInfo = templateInfo;
    }
}
