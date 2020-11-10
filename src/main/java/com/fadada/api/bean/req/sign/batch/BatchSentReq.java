package com.fadada.api.bean.req.sign.batch;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName BatchSentReq.java
 * @Description 签署任务发起请求对象
 * @Param
 * @createTime 2020年09月07日 15:53:00
 */
public class BatchSentReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String batchNo;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
}
