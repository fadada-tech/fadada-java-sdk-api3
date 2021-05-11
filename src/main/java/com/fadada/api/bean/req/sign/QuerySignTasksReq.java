package com.fadada.api.bean.req.sign;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.4.0
 * @ClassName QuerySignTasksReq.java
 * @Description 查询签署任务请求对象
 * @Param
 * @createTime 2020年06月17日 17:48:00
 */
@ParamsVerif
public class QuerySignTasksReq extends BaseReq {
    @ParamsVerif
    private QuerySignTasksInfo queryInfo;

    public static class QuerySignTasksInfo {
        @ParamsVerif
        private Integer currentPageNo;
        @ParamsVerif
        private Integer pageSize;

        private String keyWord;

        public Integer getCurrentPageNo() {
            return currentPageNo;
        }

        public void setCurrentPageNo(Integer currentPageNo) {
            this.currentPageNo = currentPageNo;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public String getKeyWord() {
            return keyWord;
        }

        public void setKeyWord(String keyWord) {
            this.keyWord = keyWord;
        }
    }

    public QuerySignTasksInfo getQueryInfo() {
        return queryInfo;
    }

    public void setQueryInfo(QuerySignTasksInfo queryInfo) {
        this.queryInfo = queryInfo;
    }
}
