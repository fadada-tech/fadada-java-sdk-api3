package com.fadada.api.bean.rsp.sign;

import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName CreateTaskByFileRsp.java
 * @Description 依据原始文件创建签署任务
 * @Param
 * @createTime 2020年10月26日 11:31:00
 */
public class CreateTaskByFileRsp extends BaseBean {

    private String taskId;
    private List<SignFileIdInfo> signFileIds;

    public static class SignFileIdInfo extends BaseBean {
        private String signFileId;

        public String getSignFileId() {
            return signFileId;
        }

        public void setSignFileId(String signFileId) {
            this.signFileId = signFileId;
        }
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public List<SignFileIdInfo> getSignFileIds() {
        return signFileIds;
    }

    public void setSignFileIds(List<SignFileIdInfo> signFileIds) {
        this.signFileIds = signFileIds;
    }
}
