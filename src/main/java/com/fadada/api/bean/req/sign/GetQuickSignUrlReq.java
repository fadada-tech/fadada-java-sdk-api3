package com.fadada.api.bean.req.sign;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetQuickSignUrlReq.java
 * @Description 获取快捷签请求对象
 * @Param
 * @createTime 2021年02月01日 14:29:00
 */
@ParamsVerif
public class GetQuickSignUrlReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String taskId;
    @ParamsVerif(checkNotEmpty = true)
    private String mobile;
    private String redirectUrl;
    private Integer miniProgram = 0;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Integer getMiniProgram() {
        return miniProgram;
    }

    public void setMiniProgram(Integer miniProgram) {
        this.miniProgram = miniProgram;
    }
}
