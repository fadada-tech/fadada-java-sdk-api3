package com.fadada.api.bean.req.sign.batch;

import com.fadada.api.annotation.ParamsVerif;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName TemplateSenderReq.java
 * @Description 模板发送人信息
 * @Param
 * @createTime 2020年09月08日 10:37:00
 */
@ParamsVerif
public class TemplateSenderReq extends SigntaskSignerReq {
    @ParamsVerif(checkNotNull = false, intContains = {0, 1})
    private Integer signWay;
    @ParamsVerif(checkNotEmpty = true)
    private String templateRoleName;

    public Integer getSignWay() {
        return signWay;
    }

    public void setSignWay(Integer signWay) {
        this.signWay = signWay;
    }

    public String getTemplateRoleName() {
        return templateRoleName;
    }

    public void setTemplateRoleName(String templateRoleName) {
        this.templateRoleName = templateRoleName;
    }
}
