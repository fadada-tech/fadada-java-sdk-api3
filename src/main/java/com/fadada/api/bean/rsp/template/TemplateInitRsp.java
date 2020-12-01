package com.fadada.api.bean.rsp.template;

import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName TemplateInitReq.java
 * @Description 模板初始化响应对象
 * @Param
 * @createTime 2020年11月25日 14:47:00
 */
public class TemplateInitRsp extends BaseBean {
    private String templateId;
    private List<RoleInfo> roles;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public List<RoleInfo> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleInfo> roles) {
        this.roles = roles;
    }
}
