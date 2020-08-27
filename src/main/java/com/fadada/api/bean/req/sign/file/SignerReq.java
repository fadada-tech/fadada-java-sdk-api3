package com.fadada.api.bean.req.sign.file;


import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.sign.template.ExternalSigner;

import java.util.List;

/**
 * @author yanghui
 * @className SignerReq
 * @description 签署人信息
 * @createTime 2020年8月13日 15:25:03
 */
@ParamsVerif
public class SignerReq extends BaseBean {

    private String unionId;

    private String authorizedUnionId;

    @ParamsVerif(checkNotNull = false, intContains = {1, 2})
    private Integer signIntendWay;

    private Integer signOrder;

    @ParamsVerif(checkNotNull = false)
    private NoticeReq notice;

    @ParamsVerif(checkNotNull = false)
    private List<FileSignReq> fileSigns;

    @ParamsVerif(checkNotNull = false)
    private ExternalSigner externalSigner;

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getAuthorizedUnionId() {
        return authorizedUnionId;
    }

    public void setAuthorizedUnionId(String authorizedUnionId) {
        this.authorizedUnionId = authorizedUnionId;
    }

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

    public NoticeReq getNotice() {
        return notice;
    }

    public void setNotice(NoticeReq notice) {
        this.notice = notice;
    }

    public List<FileSignReq> getFileSigns() {
        return fileSigns;
    }

    public void setFileSigns(List<FileSignReq> fileSigns) {
        this.fileSigns = fileSigns;
    }

    public ExternalSigner getExternalSigner() {
        return externalSigner;
    }

    public void setExternalSigner(ExternalSigner externalSigner) {
        this.externalSigner = externalSigner;
    }
}
