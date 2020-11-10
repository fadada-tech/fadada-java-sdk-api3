package com.fadada.api.bean.req.sign.batch;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName BatchAddByDraftIdReq.java
 * @Description 根据批次号新增签署任务请求对象
 * @Param
 * @createTime 2020年09月07日 15:54:00
 */
@ParamsVerif
public class BatchAddByDraftIdReq extends BaseReq {
    /**
     * 批次号
     */
    @ParamsVerif(checkNotEmpty = true)
    private String batchNo;

    @ParamsVerif
    private List<BatchDraftIdSigntaskInfoReq> signtasks;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public List<BatchDraftIdSigntaskInfoReq> getSigntasks() {
        return signtasks;
    }

    public void setSigntasks(List<BatchDraftIdSigntaskInfoReq> signtasks) {
        this.signtasks = signtasks;
    }
}
