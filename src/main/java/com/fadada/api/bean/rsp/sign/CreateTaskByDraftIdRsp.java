package com.fadada.api.bean.rsp.sign;

import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName CreateTaskByDraftIdRsp.java
 * @Description 创建签署任务对象
 * @Param
 * @createTime 2020年11月23日 15:47:00
 */
public class CreateTaskByDraftIdRsp extends BaseBean {
    private String taskId;
    private List<SignFileInfo> signFileIds;

    public static class SignFileInfo extends BaseBean {
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

    public List<SignFileInfo> getSignFileIds() {
        return signFileIds;
    }

    public void setSignFileIds(List<SignFileInfo> signFileIds) {
        this.signFileIds = signFileIds;
    }
}
