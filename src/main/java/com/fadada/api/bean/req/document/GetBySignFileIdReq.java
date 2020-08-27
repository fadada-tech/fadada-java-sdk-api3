package com.fadada.api.bean.req.document;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @className GetBySignFileIdReq
 * @description 下载签署文件信息请求对象
 * @createTime 2020年8月13日 15:21:43
 */
@ParamsVerif
public class GetBySignFileIdReq extends BaseReq {
    /**
     * 任务编号
     **/
    @ParamsVerif
    private String taskId;
    /**
     * 签署文件编号
     **/
    private String signFileId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getSignFileId() {
        return signFileId;
    }

    public void setSignFileId(String signFileId) {
        this.signFileId = signFileId;
    }
}
