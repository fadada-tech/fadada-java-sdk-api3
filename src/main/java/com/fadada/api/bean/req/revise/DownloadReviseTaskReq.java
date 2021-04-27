package com.fadada.api.bean.req.revise;

import com.fadada.api.bean.req.BaseReq;

public class DownloadReviseTaskReq extends BaseReq {
    private String taskId;
    private Integer downloadWay = 1;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Integer getDownloadWay() {
        return downloadWay;
    }

    public void setDownloadWay(Integer downloadWay) {
        this.downloadWay = downloadWay;
    }
}
