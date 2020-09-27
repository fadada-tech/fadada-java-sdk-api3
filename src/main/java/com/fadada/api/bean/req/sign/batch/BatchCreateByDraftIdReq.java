package com.fadada.api.bean.req.sign.batch;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

import java.util.List;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName BatchCreateByDraftIdReq.java
 * @Description 创建批次号任务
 * @Param
 * @createTime 2020年09月07日 15:55:00
 */
@ParamsVerif
public class BatchCreateByDraftIdReq extends BaseReq {

    @ParamsVerif
    private SenderInfo sender;

    @ParamsVerif
    private List<BatchDraftIdSigntaskInfoReq> signtasks;


    @ParamsVerif
    public static class SenderInfo extends BaseBean {
        /**
         * 员工unionId
         */
        @ParamsVerif(checkNotEmpty = true, maxLength = 32)
        private String unionId;

        @ParamsVerif(checkNotNull = false, intContains = {1, 2})
        private Integer signIntendWay;

        public String getUnionId() {
            return unionId;
        }

        public void setUnionId(String unionId) {
            this.unionId = unionId;
        }

        public Integer getSignIntendWay() {
            return signIntendWay;
        }

        public void setSignIntendWay(Integer signIntendWay) {
            this.signIntendWay = signIntendWay;
        }
    }


    public SenderInfo getSender() {
        return sender;
    }

    public void setSender(SenderInfo sender) {
        this.sender = sender;
    }

    public List<BatchDraftIdSigntaskInfoReq> getSigntasks() {
        return signtasks;
    }

    public void setSigntasks(List<BatchDraftIdSigntaskInfoReq> signtasks) {
        this.signtasks = signtasks;
    }
}
