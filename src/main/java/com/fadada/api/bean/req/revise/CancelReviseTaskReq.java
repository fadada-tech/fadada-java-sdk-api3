package com.fadada.api.bean.req.revise;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName CancelReviseTaskReq.java
 * @Description 定稿任务撤销请求对象
 * @Param
 * @createTime 2020年11月25日 15:55:00
 */
@ParamsVerif
public class CancelReviseTaskReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
