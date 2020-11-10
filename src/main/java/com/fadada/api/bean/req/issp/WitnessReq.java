package com.fadada.api.bean.req.issp;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName WitnessReq.java
 * @Description 归档请求接口
 * @Param
 * @createTime 2020年10月23日 12:18:00
 */
@ParamsVerif
public class WitnessReq extends BaseReq {

    @ParamsVerif(checkNotEmpty = true)
    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
