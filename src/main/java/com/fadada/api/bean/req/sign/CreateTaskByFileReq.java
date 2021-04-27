package com.fadada.api.bean.req.sign;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;
import com.fadada.api.bean.req.sign.file.FileReq;
import com.fadada.api.bean.req.sign.file.SignHereReq;
import com.fadada.api.bean.req.sign.file.SignerReqV2;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName CreateTaskByFileReq.java
 * @Description 依据原始文件创建签署任务
 * @Param
 * @createTime 2020年10月26日 11:31:00
 */
@ParamsVerif
public class CreateTaskByFileReq extends BaseReq {
    /**
     * 签署文件集合
     */
    @ParamsVerif(maxLength = 20)
    private List<FileReq> files;

    /**
     * 签署附件集合
     */
    @ParamsVerif(checkNotNull = false, maxLength = 10)
    private List<FileReq> attachments;

    /**
     * 签署人列表
     */
    @ParamsVerif
    private List<SignerInfo> signers;

    @ParamsVerif(checkNotEmpty = true)
    private String taskSubject; //主题

    @ParamsVerif(checkNotEmpty = true, strContains = {"create", "sent"})
    private String status; //默认 sent

    @ParamsVerif(checkNotNull = false, intContains = {0, 1})
    private Integer autoArchive; //是否自动归档:0不归档，1归档

    @ParamsVerif(intContains = {1, 2})
    private Integer sort;

    /**
     * 抄送人集合
     */
    @ParamsVerif(checkNotNull = false, maxLength = 50)
    private List<TaskCcInfo> ccs;

    /**
     * 发起方对象，只能是平台方或者平台方子公司
     */
    @ParamsVerif(checkNotNull = false)
    private TaskSenderInfo sender;


    @ParamsVerif
    public static class TaskSenderInfo extends BaseBean {

        @ParamsVerif(checkNotEmpty = true)
        private String agentId;

        private String unionId;

        public String getAgentId() {
            return agentId;
        }

        public void setAgentId(String agentId) {
            this.agentId = agentId;
        }

        public String getUnionId() {
            return unionId;
        }

        public void setUnionId(String unionId) {
            this.unionId = unionId;
        }
    }

    @ParamsVerif
    public static class TaskCcInfo extends BaseBean {
        private String personName;
        private String companyName;

        @ParamsVerif(checkNotNull = false)
        private NoticeReq notice;

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public NoticeReq getNotice() {
            return notice;
        }

        public void setNotice(NoticeReq notice) {
            this.notice = notice;
        }
    }

    @ParamsVerif
    public static class SignerInfo extends BaseBean {

        /**
         * 应用内部签署
         */
        @ParamsVerif(checkNotNull = false)
        private SignerReqV2 signer;


        /**
         * 外部签署方
         */
        @ParamsVerif(checkNotNull = false)
        private ExternalSignerReq externalSigner;

        private NoticeReq notice;

        /**
         * 签署区域
         */
        @ParamsVerif(checkNotNull = false)
        private List<SignRegionInfo> signRegions;
        private Integer lock;
        private Integer signOrder;

        public SignerReqV2 getSigner() {
            return signer;
        }

        public void setSigner(SignerReqV2 signer) {
            this.signer = signer;
        }

        public ExternalSignerReq getExternalSigner() {
            return externalSigner;
        }

        public void setExternalSigner(ExternalSignerReq externalSigner) {
            this.externalSigner = externalSigner;
        }

        public List<SignRegionInfo> getSignRegions() {
            return signRegions;
        }

        public void setSignRegions(List<SignRegionInfo> signRegions) {
            this.signRegions = signRegions;
        }

        public Integer getLock() {
            return lock;
        }

        public void setLock(Integer lock) {
            this.lock = lock;
        }

        public Integer getSignOrder() {
            return signOrder;
        }

        public void setSignOrder(Integer signOrder) {
            this.signOrder = signOrder;
        }

        public NoticeReq getNotice() {
            return notice;
        }

        public void setNotice(NoticeReq notice) {
            this.notice = notice;
        }
    }

    @ParamsVerif
    public static class SignRegionInfo extends BaseBean {

        @ParamsVerif(checkNotEmpty = true, maxLength = 20)
        private String fileId; //文件编号

        private Integer type;

        @ParamsVerif(checkNotEmpty = true)
        private List<SignHereReq> signHeres;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public List<SignHereReq> getSignHeres() {
            return signHeres;
        }

        public void setSignHeres(List<SignHereReq> signHeres) {
            this.signHeres = signHeres;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }


    public List<FileReq> getFiles() {
        return files;
    }

    public void setFiles(List<FileReq> files) {
        this.files = files;
    }

    public List<FileReq> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<FileReq> attachments) {
        this.attachments = attachments;
    }

    public List<SignerInfo> getSigners() {
        return signers;
    }

    public void setSigners(List<SignerInfo> signers) {
        this.signers = signers;
    }

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

    public List<TaskCcInfo> getCcs() {
        return ccs;
    }

    public void setCcs(List<TaskCcInfo> ccs) {
        this.ccs = ccs;
    }

    public TaskSenderInfo getSender() {
        return sender;
    }

    public void setSender(TaskSenderInfo sender) {
        this.sender = sender;
    }
}
