package com.fadada.api.bean.req.sign;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

@ParamsVerif
public class TaskCcReq extends BaseBean {

    @ParamsVerif(checkNotEmpty = true, maxLength = 32)
    private String unionId;

    @ParamsVerif(checkNotNull = false)
    private NoticeReq notice;

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
}
