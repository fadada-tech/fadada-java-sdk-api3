package com.fadada.api.bean.req.revise;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetFillFileUrlReq.java
 * @Description 获取填充地址请求对象
 * @Param
 * @createTime 2020年11月25日 15:55:00
 */
@ParamsVerif
public class GetFillFileUrlReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String taskId;

    @ParamsVerif(checkNotEmpty = true)
    private String roleName;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
