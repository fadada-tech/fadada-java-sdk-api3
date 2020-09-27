package com.fadada.api.bean.req.sign.batch;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.sign.template.ExternalSigner;

/**
 * @author yanghui
 * @className BatchTemplateSignerReq
 * @description 模板签署人信息
 * @createTime 2020年9月8日 10:37:33
 */
@ParamsVerif
public class BatchTemplateSignerReq extends SigntaskSignerReq {

    /**
     * 外部签署人对象  推送到官网签
     */
    @ParamsVerif(checkNotNull = false)
    private ExternalSigner externalSigner;


    @ParamsVerif(checkNotEmpty = true)
    private String templateRoleName; //用户角色 与模板编辑设置得角色匹配

    @ParamsVerif(checkNotNull = false)
    private String authorizedUnionId;

    public ExternalSigner getExternalSigner() {
        return externalSigner;
    }

    public void setExternalSigner(ExternalSigner externalSigner) {
        this.externalSigner = externalSigner;
    }

    public String getTemplateRoleName() {
        return templateRoleName;
    }

    public void setTemplateRoleName(String templateRoleName) {
        this.templateRoleName = templateRoleName;
    }

    public String getAuthorizedUnionId() {
        return authorizedUnionId;
    }

    public void setAuthorizedUnionId(String authorizedUnionId) {
        this.authorizedUnionId = authorizedUnionId;
    }
}
