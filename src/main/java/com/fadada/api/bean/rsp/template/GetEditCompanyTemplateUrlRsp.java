package com.fadada.api.bean.rsp.template;

import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName GetEditCompanyTemplateUrlRsp.java
 * @Description 获取企业合同模板链接请求对象
 * @Param
 * @createTime 2020年07月23日 17:11:00
 */
public class GetEditCompanyTemplateUrlRsp extends BaseBean {
    private String editTemplateUrl;

    public String getEditTemplateUrl() {
        return editTemplateUrl;
    }

    public void setEditTemplateUrl(String editTemplateUrl) {
        this.editTemplateUrl = editTemplateUrl;
    }
}
