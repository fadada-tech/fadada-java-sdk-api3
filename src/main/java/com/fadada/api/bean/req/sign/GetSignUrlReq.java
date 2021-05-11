package com.fadada.api.bean.req.sign;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @className GetSignUrlReq
 * @description 获取签署链接请求对象
 * @createTime 2020年8月13日 15:27:43
 * @version 1.4.0
 */
@ParamsVerif
public class GetSignUrlReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String taskId;
    @ParamsVerif(checkNotEmpty = true)
    private String unionId;

    private String redirectUrl;

    private String modifyUrl;

    @ParamsVerif(checkNotNull = false, intContains = {0, 1})
    private Integer miniProgramSign;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Integer getMiniProgramSign() {
        return miniProgramSign;
    }

    public void setMiniProgramSign(Integer miniProgramSign) {
        this.miniProgramSign = miniProgramSign;
    }

    public String getModifyUrl() {
        return modifyUrl;
    }

    public void setModifyUrl(String modifyUrl) {
        this.modifyUrl = modifyUrl;
    }
}
