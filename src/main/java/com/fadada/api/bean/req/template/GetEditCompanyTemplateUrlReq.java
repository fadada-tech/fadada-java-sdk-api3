package com.fadada.api.bean.req.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName GetEditCompanyTemplateUrlReq.java
 * @Description 获取合同模板编辑链接请求对象
 * @Param
 * @createTime 2020年07月23日 17:12:00
 */
@ParamsVerif
public class GetEditCompanyTemplateUrlReq extends BaseReq {
    @ParamsVerif
    private TemplateInfo templateInfo;

    @ParamsVerif
    public static class TemplateInfo extends BaseBean {

        @ParamsVerif
        private String templateId;

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }
    }

    public void setTemplateId(String templateId) {
        if (this.templateInfo == null) {
            this.templateInfo = new TemplateInfo();
        }
        this.templateInfo.templateId = templateId;
    }

    public TemplateInfo getTemplateInfo() {
        return templateInfo;
    }

    public void setTemplateInfo(TemplateInfo templateInfo) {
        this.templateInfo = templateInfo;
    }
}
