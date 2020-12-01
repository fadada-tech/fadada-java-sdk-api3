package com.fadada.api.bean.rsp.template;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetTemplateMainUrlReq.java
 * @Description 获取模板编辑主页链接响应对象
 * @Param
 * @createTime 2020年11月25日 14:56:00
 */
public class GetTemplateMainUrlRsp extends BaseBean {
    private String editTemplateUrl;

    public String getEditTemplateUrl() {
        return editTemplateUrl;
    }

    public void setEditTemplateUrl(String editTemplateUrl) {
        this.editTemplateUrl = editTemplateUrl;
    }
}