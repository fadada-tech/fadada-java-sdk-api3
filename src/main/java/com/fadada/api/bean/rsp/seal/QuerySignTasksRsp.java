package com.fadada.api.bean.rsp.seal;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yh128
 * @version 1.4.0
 * @ClassName QuerySignTasksRsp.java
 * @Description 查询签署任务请求响应对象
 * @Param
 * @createTime 2020年06月17日 17:48:00
 */
@ParamsVerif
public class QuerySignTasksRsp extends BaseBean {

    private Integer total;
    private Integer totalPageCount;
    private Integer currentPageNo;
    private List<QuerySignTasksRspInfo> list;

    public static class QuerySignTasksRspInfo extends BaseBean {
        private String taskId;
        private String taskSubject;
        private String taskStatus;
        private String createTime;
        private Integer sort;
        private Integer autoArchive;
        private String senderUnionId;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getTaskSubject() {
            return taskSubject;
        }

        public void setTaskSubject(String taskSubject) {
            this.taskSubject = taskSubject;
        }

        public String getTaskStatus() {
            return taskStatus;
        }

        public void setTaskStatus(String taskStatus) {
            this.taskStatus = taskStatus;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Integer getSort() {
            return sort;
        }

        public void setSort(Integer sort) {
            this.sort = sort;
        }

        public Integer getAutoArchive() {
            return autoArchive;
        }

        public void setAutoArchive(Integer autoArchive) {
            this.autoArchive = autoArchive;
        }

        public String getSenderUnionId() {
            return senderUnionId;
        }

        public void setSenderUnionId(String senderUnionId) {
            this.senderUnionId = senderUnionId;
        }
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public Integer getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(Integer currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public List<QuerySignTasksRspInfo> getList() {
        return list;
    }

    public void setList(List<QuerySignTasksRspInfo> list) {
        this.list = list;
    }

}
