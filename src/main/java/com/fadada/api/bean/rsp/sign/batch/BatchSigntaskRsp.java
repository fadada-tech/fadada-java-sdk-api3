package com.fadada.api.bean.rsp.sign.batch;


import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @className BatchSigntasRsp
 * @description 签署任务信息
 * @createTime 2020年9月7日 17:15:26
 */
public class BatchSigntaskRsp extends BaseBean {
    private String taskId;
    private String taskSubject;
    private String draftId;
    private String status;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskSubject() {
        return taskSubject;
    }

    public void setTaskSubject(String taskSubject) {
        this.taskSubject = taskSubject;
    }

    public String getDraftId() {
        return draftId;
    }

    public void setDraftId(String draftId) {
        this.draftId = draftId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}