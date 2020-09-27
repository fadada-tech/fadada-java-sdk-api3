package com.fadada.api.bean.req.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author gengxl
 * @create 2020-03-06 18:14
 */
@ParamsVerif
public class GetTemplateDetailByIdReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String templateId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}
