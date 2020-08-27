package com.fadada.api.bean.rsp.template;

import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName UpdateCompanyTemplateRsp.java
 * @Description 修改企业模板信息请求对象
 * @Param
 * @createTime 2020年07月23日 17:11:00
 */
public class UpdateCompanyTemplateRsp extends BaseBean {
    private Long templateId;

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

}
