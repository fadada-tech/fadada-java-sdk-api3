package com.fadada.api.bean.req.sign.batch;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName BatchDraftIdSigntaskInfoReq.java
 * @Description 批次号对应签署任务 信息
 * @Param
 * @createTime 2020年09月07日 16:03:00
 */
@ParamsVerif
public class BatchDraftIdSigntaskInfoReq extends BaseBean {

    @ParamsVerif(checkNotEmpty = true)
    private String draftId;

    @ParamsVerif(checkNotEmpty = true)
    private String taskSubject;

    @ParamsVerif(intContains = {1, 2})
    private Integer sort;

    @ParamsVerif(checkNotNull = false)
    private TemplateSenderReq sender;

    @ParamsVerif(checkNotNull = false)
    private List<BatchTemplateSignerReq> signers;

    public String getDraftId() {
        return draftId;
    }

    public void setDraftId(String draftId) {
        this.draftId = draftId;
    }

    public String getTaskSubject() {
        return taskSubject;
    }

    public void setTaskSubject(String taskSubject) {
        this.taskSubject = taskSubject;
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

    public List<BatchTemplateSignerReq> getSigners() {
        return signers;
    }

    public void setSigners(List<BatchTemplateSignerReq> signers) {
        this.signers = signers;
    }
}
