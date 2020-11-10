package com.fadada.api.bean.req.document;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName DownloadEvidenceReportReq.java
 * @Description 公证处报告下载请求对象
 * @Param
 * @createTime 2020年07月15日 17:57:00
 */
@ParamsVerif
public class DownloadEvidenceReportReq extends BaseReq {

    @ParamsVerif
    private QueryInfo queryInfo;

    @ParamsVerif
    public static class QueryInfo extends BaseBean {
        private String taskId;

        @ParamsVerif(intContains = {2, 3, 4})
        private Integer type;

        private List<String> unionIds;

        private String unionId;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public List<String> getUnionIds() {
            return unionIds;
        }

        public void setUnionIds(List<String> unionIds) {
            this.unionIds = unionIds;
        }

        public String getUnionId() {
            return unionId;
        }

        public void setUnionId(String unionId) {
            this.unionId = unionId;
        }
    }

    public QueryInfo getQueryInfo() {
        return queryInfo;
    }

    public void setQueryInfo(QueryInfo queryInfo) {
        this.queryInfo = queryInfo;
    }
}
