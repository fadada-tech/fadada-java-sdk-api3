package com.fadada.api.bean.req.sign;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @className GetSignPreviewUrlReq
 * @description 获取文件预览地址请求对象
 * @createTime 2020年8月13日 15:27:43
 */
@ParamsVerif
public class GetSignPreviewUrlReq extends BaseReq {
    @ParamsVerif
    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
