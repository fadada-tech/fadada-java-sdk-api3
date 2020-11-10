package com.fadada.api.bean.rsp.sign.batch;

import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName BatchGetSigntasksByBatchNoRsp.java
 * @Description 获取签署任务返回对象
 * @Param
 * @createTime 2020年09月07日 17:09:00
 */
public class BatchGetSigntasksByBatchNoRsp extends BaseBean {
    private List<BatchSigntaskRsp> signtasks;

    public List<BatchSigntaskRsp> getSigntasks() {
        return signtasks;
    }

    public void setSigntasks(List<BatchSigntaskRsp> signtasks) {
        this.signtasks = signtasks;
    }
}
