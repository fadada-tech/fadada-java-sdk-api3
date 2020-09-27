package com.fadada.api.bean.req.sign.file;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.sign.NoticeReq;

import java.util.List;

/**
 * @author yanghui
 * @className SigntaskSenderReq
 * @description 签署任务对象
 * @createTime 2020年8月13日 15:25:41
 */
@ParamsVerif
public class SigntaskSenderReq extends BaseBean {

    private Integer signOrder;

    /**
     * 签署方式 0 静默签  1 手动签
     */
    @ParamsVerif(checkNotNull = false, intContains = {0, 1})
    private Integer signWay;

    @ParamsVerif(checkNotNull = false, intContains = {1, 2})
    private Integer signIntendWay;

    @ParamsVerif(checkNotNull = false)
    private List<FileSignReq> fileSigns;

    @ParamsVerif(checkNotNull = false)
    private NoticeReq notice;

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

    public Integer getSignIntendWay() {
        return signIntendWay;
    }

    public void setSignIntendWay(Integer signIntendWay) {
        this.signIntendWay = signIntendWay;
    }

    public List<FileSignReq> getFileSigns() {
        return fileSigns;
    }

    public void setFileSigns(List<FileSignReq> fileSigns) {
        this.fileSigns = fileSigns;
    }

    public NoticeReq getNotice() {
        return notice;
    }

    public void setNotice(NoticeReq notice) {
        this.notice = notice;
    }
}
