package com.fadada.api.bean.req.sign;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName UrgeSignReq.java
 * @Description 催签请求对象
 * @Param
 * @createTime 2020年07月29日 10:44:00
 */
@ParamsVerif
public class UrgeSignReq extends BaseReq {
    @ParamsVerif
    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
