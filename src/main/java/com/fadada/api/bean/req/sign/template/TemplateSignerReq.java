package com.fadada.api.bean.req.sign.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.sign.NoticeReq;
import com.fadada.api.bean.req.sign.batch.SigntaskSignerReq;

/**
 * @author yh128
 * @className TemplateSignerReq
 * @description 模板签署人信息
 * @createTime 2020年8月13日 15:27:18
 */
@ParamsVerif
public class TemplateSignerReq extends SigntaskSignerReq {

    private String unionId;

    /**
     * 外部签署人对象  推送到官网签
     */
    @ParamsVerif(checkNotNull = false)
    private ExternalSigner externalSigner;

    /**
     * 用户角色 与模板编辑设置得角色匹配
     */
    @ParamsVerif(checkNotEmpty = true)
    private String templateRoleName;

    private String authorizedUnionId;

    @ParamsVerif(checkNotNull = false, intContains = {1, 2})
    private Integer signIntendWay;

    @ParamsVerif(checkNotNull = false, minValue = "0", maxValue = "65536")
    private Integer signOrder;

    @ParamsVerif(checkNotNull = false)
    private NoticeReq notice;

    private int sequence;

    @Override
    public String getUnionId() {
        return unionId;
    }

    @Override
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

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

    @Override
    public Integer getSignIntendWay() {
        return signIntendWay;
    }

    @Override
    public void setSignIntendWay(Integer signIntendWay) {
        this.signIntendWay = signIntendWay;
    }

    @Override
    public Integer getSignOrder() {
        return signOrder;
    }

    @Override
    public void setSignOrder(Integer signOrder) {
        this.signOrder = signOrder;
    }

    @Override
    public NoticeReq getNotice() {
        return notice;
    }

    @Override
    public void setNotice(NoticeReq notice) {
        this.notice = notice;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
