package com.fadada.api.bean.req.sign.file;

import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.sign.CorpReq;
import com.fadada.api.bean.req.sign.NoticeReq;
import com.fadada.api.bean.req.sign.SignActionReq;
import com.fadada.api.bean.req.sign.SignatoryReq;

public class SignerReqV2 extends BaseBean {

    /**
     * 签署人对象
     */
    private SignatoryReq signatory;

    /**
     * 企业签署信息，企业自动签 只需要传企业unionId就可以
     */
    private CorpReq corp;

    /**
     * 签署动作，签署方式，签署意愿认证方式
     */
    private SignActionReq signAction;

    /**
     * 通知对象
     */
    private NoticeReq notice;

    public SignatoryReq getSignatory() {
        return signatory;
    }

    public void setSignatory(SignatoryReq signatory) {
        this.signatory = signatory;
    }

    public CorpReq getCorp() {
        return corp;
    }

    public void setCorp(CorpReq corp) {
        this.corp = corp;
    }

    public SignActionReq getSignAction() {
        return signAction;
    }

    public void setSignAction(SignActionReq signAction) {
        this.signAction = signAction;
    }

    public NoticeReq getNotice() {
        return notice;
    }

    public void setNotice(NoticeReq notice) {
        this.notice = notice;
    }
}
