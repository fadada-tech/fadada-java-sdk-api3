package com.fadada.api.bean.req.sign.file;


import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

import java.util.List;

/**
 * @author yanghui
 * @className FileSignTaskReq
 * @description 创建签署任务请求对象
 * @createTime 2020年8月13日 15:23:48
 */
@ParamsVerif
public class FileSignTaskReq extends BaseReq {

    /**
     * 任务主题
     */
    @ParamsVerif
    private String taskSubject;

    /**
     * 默认sent 发送状态
     */
    @ParamsVerif(strContains = {"create", "sent"})
    private String status;

    /**
     * 签署顺序 1：顺序 2：无序
     */
    @ParamsVerif(intContains = {1, 2})
    private Integer sort;

    /**
     * 发件人
     */
    @ParamsVerif(checkNotNull = false)
    private SigntaskSenderReq sender;

    /**
     * 签署文件列表
     */
    @ParamsVerif
    private List<FileReq> files;

    @ParamsVerif
    private List<SignerReq> signers;

    private String taskConfig;


    @ParamsVerif(checkNotNull = false, intContains = {0, 1})
    private Integer autoArchive;

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public SigntaskSenderReq getSender() {
        return sender;
    }

    public void setSender(SigntaskSenderReq sender) {
        this.sender = sender;
    }

    public List<FileReq> getFiles() {
        return files;
    }

    public void setFiles(List<FileReq> files) {
        this.files = files;
    }

    public List<SignerReq> getSigners() {
        return signers;
    }

    public void setSigners(List<SignerReq> signers) {
        this.signers = signers;
    }

    public String getTaskConfig() {
        return taskConfig;
    }

    public void setTaskConfig(String taskConfig) {
        this.taskConfig = taskConfig;
    }

    public Integer getAutoArchive() {
        return autoArchive;
    }

    public void setAutoArchive(Integer autoArchive) {
        this.autoArchive = autoArchive;
    }
}
