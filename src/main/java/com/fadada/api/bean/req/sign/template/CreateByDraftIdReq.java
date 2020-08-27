package com.fadada.api.bean.req.sign.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

import java.util.List;

/**
 * @author yanghui
 * @className CreateByDraftIdReq
 * @description 通过草稿文件创建签署任务请求对象
 * @createTime 2020年8月13日 15:26:12
 */
@ParamsVerif
public class CreateByDraftIdReq extends BaseReq {

    /**
     * 主题
     */
    @ParamsVerif
    private String taskSubject;
    /**
     * 临时任务id
     */
    @ParamsVerif
    private String draftId;
    @ParamsVerif(strContains = {"create", "sent"})
    /**
     * 默认 sent
     */
    private String status;

    @ParamsVerif(intContains = {1, 2})
    private Integer sort;

    @ParamsVerif(checkNotNull = false)
    private TemplateSenderReq sender;

    /**
     * 是否自动归档:0不归档，1归档
     */
    @ParamsVerif(checkNotNull = false, intContains = {1, 2})
    private Integer autoArchive;

    /**
     * 任务配置   参数保留
     */
    private String taskConfig;

    @ParamsVerif
    private List<TemplateSignerReq> signers;

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public TemplateSenderReq getSender() {
        return sender;
    }

    public void setSender(TemplateSenderReq sender) {
        this.sender = sender;
    }

    public Integer getAutoArchive() {
        return autoArchive;
    }

    public void setAutoArchive(Integer autoArchive) {
        this.autoArchive = autoArchive;
    }

    public String getTaskConfig() {
        return taskConfig;
    }

    public void setTaskConfig(String taskConfig) {
        this.taskConfig = taskConfig;
    }

    public List<TemplateSignerReq> getSigners() {
        return signers;
    }

    public void setSigners(List<TemplateSignerReq> signers) {
        this.signers = signers;
    }
}
