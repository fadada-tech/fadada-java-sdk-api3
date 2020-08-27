package com.fadada.api.bean.req.sign;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName CancelSignTaskReq.java
 * @Description 取消签署任务请求对象
 * @Param
 * @createTime 2020年06月17日 17:48:00
 */
@ParamsVerif
public class CancelSignTaskReq extends BaseReq {

    @ParamsVerif(equalLength = 32)
    private String taskId;

    @ParamsVerif
    private String remark;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
