package com.fadada.api.bean.req.sign.batch;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.sign.NoticeReq;

@ParamsVerif
public class SigntaskSignerReq extends BaseBean {

    @ParamsVerif(checkNotNull = false, intContains = {1, 2})
    private Integer signIntendWay;

    @ParamsVerif(checkNotNull = false, minValue = "0", maxValue = "65536")
    private Integer signOrder;

    @ParamsVerif(checkNotEmpty = true, maxLength = 32)
    private String unionId;

    @ParamsVerif(checkNotNull = false)
    private NoticeReq notice;

    /**
     * 发件人指定签章id
     */
    @ParamsVerif(checkNotNull = false, maxLength = 20)
    private String sealId;

    public Integer getSignIntendWay() {
        return signIntendWay;
    }

    public void setSignIntendWay(Integer signIntendWay) {
        this.signIntendWay = signIntendWay;
    }

    public Integer getSignOrder() {
        return signOrder;
    }

    public void setSignOrder(Integer signOrder) {
        this.signOrder = signOrder;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public NoticeReq getNotice() {
        return notice;
    }

    public void setNotice(NoticeReq notice) {
        this.notice = notice;
    }

    public String getSealId() {
        return sealId;
    }

    public void setSealId(String sealId) {
        this.sealId = sealId;
    }
}
