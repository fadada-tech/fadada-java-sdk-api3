package com.fadada.api.bean.req.sign.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.sign.file.NoticeReq;

/**
 * @author yanghui
 * @className TemplateSenderReq
 * @description 模板签署对象
 * @createTime 2020年8月13日 15:27:01
 */
@ParamsVerif
public class TemplateSenderReq extends BaseBean {

    @ParamsVerif(checkNotNull = false, minValue = "0", maxValue = "65536")
    private Integer signOrder;

    /**
     * 签署方式 0 静默签  1 手动签
     */
    @ParamsVerif(checkNotNull = false, intContains = {0, 1})
    private Integer signWay;

    @ParamsVerif
    private String templateRoleName;

    @ParamsVerif(checkNotNull = false)
    private NoticeReq notice;


    private int sequence;

    @ParamsVerif(checkNotNull = false, intContains = {1, 2})
    private Integer signIntendWay;


    public Integer getSignOrder() {
        return signOrder;
    }

    public void setSignOrder(Integer signOrder) {
        this.signOrder = signOrder;
    }

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

    public NoticeReq getNotice() {
        return notice;
    }

    public void setNotice(NoticeReq notice) {
        this.notice = notice;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Integer getSignIntendWay() {
        return signIntendWay;
    }

    public void setSignIntendWay(Integer signIntendWay) {
        this.signIntendWay = signIntendWay;
    }
}
