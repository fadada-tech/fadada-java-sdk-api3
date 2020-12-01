package com.fadada.api.bean.req.sign.draft;


import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.sign.TaskSignerReq;

@ParamsVerif
public class DraftTaskSignerReq extends TaskSignerReq {

    @ParamsVerif(checkNotEmpty = true)
    private String templateRoleName;

    public String getTemplateRoleName() {
        return templateRoleName;
    }

    public void setTemplateRoleName(String templateRoleName) {
        this.templateRoleName = templateRoleName;
    }
}
