package com.fadada.api.bean.req.sign.batch;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName BatchGetSigntasksByBatchNoReq.java
 * @Description 根据批次号获取签署任务 请求对象
 * @Param
 * @createTime 2020年09月07日 15:54:00
 */
public class BatchGetSigntasksByBatchNoReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String batchNo;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
}
