package com.fadada.api.bean.rsp.sign;

import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yanghui
 * @className GetTaskDetailsRes
 * @description 签署任务详请
 * @createTime 2020年8月13日 15:15:24
 */
public class GetTaskDetailsRes extends BaseBean {
    private String taskId;
    private String taskSubject;
    private Integer taskStatus;
    private List<SigntaskDetailRes> taskDetails;
    private List<SingtaskFileDetailRes> taskFiles;

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

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public List<SigntaskDetailRes> getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(List<SigntaskDetailRes> taskDetails) {
        this.taskDetails = taskDetails;
    }

    public List<SingtaskFileDetailRes> getTaskFiles() {
        return taskFiles;
    }

    public void setTaskFiles(List<SingtaskFileDetailRes> taskFiles) {
        this.taskFiles = taskFiles;
    }
}
