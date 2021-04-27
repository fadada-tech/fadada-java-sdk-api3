package com.fadada.api.bean.rsp.revise;

import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName CreateReviseTaskReq.java
 * @Description 创建定稿任务响应对象
 * @Param
 * @createTime 2020年11月25日 15:55:00
 */
public class CreateReviseTaskRsp extends BaseBean {
    private String taskId;
    private List<TaskFileInfo> taskFiles;

    public static class TaskFileInfo extends BaseBean {
        private String fileId;
        private String templateFileId;
        private String fileName;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public String getTemplateFileId() {
            return templateFileId;
        }

        public void setTemplateFileId(String templateFileId) {
            this.templateFileId = templateFileId;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public List<TaskFileInfo> getTaskFiles() {
        return taskFiles;
    }

    public void setTaskFiles(List<TaskFileInfo> taskFiles) {
        this.taskFiles = taskFiles;
    }
}
