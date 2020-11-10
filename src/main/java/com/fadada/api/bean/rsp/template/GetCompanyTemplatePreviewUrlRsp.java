package com.fadada.api.bean.rsp.template;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetCompanyTemplatePreviewUrlRsp.java
 * @Description 模板预览链接信息
 * @Param
 * @createTime 2020年09月08日 19:12:00
 */

public class GetCompanyTemplatePreviewUrlRsp extends BaseBean {
    private String templatePreviewUrl;

    public String getTemplatePreviewUrl() {
        return templatePreviewUrl;
    }

    public void setTemplatePreviewUrl(String templatePreviewUrl) {
        this.templatePreviewUrl = templatePreviewUrl;
    }
}
