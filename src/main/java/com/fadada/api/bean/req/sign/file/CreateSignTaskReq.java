package com.fadada.api.bean.req.sign.file;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;
import com.fadada.api.bean.req.sign.TaskCcReq;
import com.fadada.api.bean.req.sign.TaskSenderReq;

import java.util.List;

@ParamsVerif
public class CreateSignTaskReq extends BaseReq {

    @ParamsVerif(checkNotEmpty = true)
    private String taskSubject;


    @ParamsVerif(checkNotEmpty = true, strContains = {"create", "sent"})
    private String status;

    @ParamsVerif(checkNotNull = false, intContains = {0, 1})
    private Integer autoArchive;

    @ParamsVerif(intContains = {1, 2})
    private Integer sort;

    /**
     * 抄送人集合
     */
    @ParamsVerif(maxLength = 50)
    private List<TaskCcReq> ccs;


    @ParamsVerif
    private TaskSenderReq sender;


    public String getTaskSubject() {
        return taskSubject;
    }

    public void setTaskSubject(String taskSubject) {
        this.taskSubject = taskSubject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAutoArchive() {
        return autoArchive;
    }

    public void setAutoArchive(Integer autoArchive) {
        this.autoArchive = autoArchive;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<TaskCcReq> getCcs() {
        return ccs;
    }

    public void setCcs(List<TaskCcReq> ccs) {
        this.ccs = ccs;
    }

    public TaskSenderReq getSender() {
        return sender;
    }

    public void setSender(TaskSenderReq sender) {
        this.sender = sender;
    }

}
