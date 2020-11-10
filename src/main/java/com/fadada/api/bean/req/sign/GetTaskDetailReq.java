package com.fadada.api.bean.req.sign;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @className GetTaskDetailReq
 * @description 获取任务详请请求对象
 * @createTime 2020年8月13日 15:28:06
 */
@ParamsVerif
public class GetTaskDetailReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true, equalLength = 32)
    private String taskId;
    @ParamsVerif(checkNotEmpty = true, maxLength = 32)
    private String unionId;

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
}
