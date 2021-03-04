package com.fadada.api.bean.rsp.template;

import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName UpdateCompanyTemplateRsp.java
 * @Description 修改企业模板信息请求对象
 * @Param
 * @createTime 2020年07月23日 17:11:00
 */
public class UpdateCompanyTemplateRsp extends BaseBean {
    private Long templateId;

    private List<Target> targets;

    public static class Target extends BaseBean {

        private String targetId;

        private String roleName;

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

        public Integer getSortNum() {
            return sortNum;
        }

        public void setSortNum(Integer sortNum) {
            this.sortNum = sortNum;
        }
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }
}
