package com.fadada.api.bean.req.sign;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetSentUrlReq.java
 * @Description 获取签署任务发起链接请求对象
 * @Param
 * @createTime 2020年06月17日 17:49:00
 */
@ParamsVerif
public class GetSentUrlReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true, equalLength = 32)
    private String taskId;

    private String redirectUrl;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
