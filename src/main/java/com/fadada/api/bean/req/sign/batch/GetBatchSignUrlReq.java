package com.fadada.api.bean.req.sign.batch;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetBatchSignUrlReq.java
 * @Description 获取批量签请求对象
 * @Param
 * @createTime 2021年02月01日 14:29:00
 */
@ParamsVerif
public class GetBatchSignUrlReq extends BaseReq {
    private String requestWay;
    private String signerId;
    private String corpId;
    private List<SigntaskInfo> signtasks;

    public static class SigntaskInfo extends BaseBean {
        private String taskId;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }
    }

    public String getRequestWay() {
        return requestWay;
    }

    public void setRequestWay(String requestWay) {
        this.requestWay = requestWay;
    }

    public String getSignerId() {
        return signerId;
    }

    public void setSignerId(String signerId) {
        this.signerId = signerId;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public List<SigntaskInfo> getSigntasks() {
        return signtasks;
    }

    public void setSigntasks(List<SigntaskInfo> signtasks) {
        this.signtasks = signtasks;
    }
}
