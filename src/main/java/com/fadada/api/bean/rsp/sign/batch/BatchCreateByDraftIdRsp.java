package com.fadada.api.bean.rsp.sign.batch;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName BatchCreateByDraftIdRsp.java
 * @Description 批量创建签署任务返回对象
 * @Param
 * @createTime 2020年09月07日 17:10:00
 */
public class BatchCreateByDraftIdRsp extends BaseBean {

    private String batchNo;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
}
