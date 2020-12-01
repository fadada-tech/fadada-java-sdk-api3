package com.fadada.api.bean.req.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetTemplateDetailReq.java
 * @Description 获取模板详请请求对象
 * @Param
 * @createTime 2020年11月25日 15:02:00
 */
@ParamsVerif
public class GetTemplateDetailReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String templateId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}
