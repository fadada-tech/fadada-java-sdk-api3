package com.fadada.api.bean.rsp.sign.batch;

import com.fadada.api.bean.BaseBean;

public class GetBatchSignUrlRsp extends BaseBean {
    private String signUrl;
    private String batchNo;

    public String getSignUrl() {
        return signUrl;
    }

    public void setSignUrl(String signUrl) {
        this.signUrl = signUrl;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
}
