package com.fadada.api.bean.req.document;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName LookUpCoordinatesReq.java
 * @Description 关键字查询坐标请求对象
 * @Param
 * @createTime 2020年07月23日 14:29:00
 */
@ParamsVerif
public class LookUpCoordinatesReq extends BaseReq {
    @ParamsVerif
    private QueryInfo queryInfo;

    @ParamsVerif
    public static class QueryInfo extends BaseBean {

        @ParamsVerif(checkNotEmpty = true)
        private String fileId;

        @ParamsVerif(checkNotEmpty = true, maxLength = 100)
        private String keyword;

        @ParamsVerif(checkNotNull = false, minValue = "0")
        private Integer pageNumber;

        @ParamsVerif(checkNotNull = false, intContains = {1, 2})
        private Integer keywordStrategy;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public Integer getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(Integer pageNumber) {
            this.pageNumber = pageNumber;
        }

        public Integer getKeywordStrategy() {
            return keywordStrategy;
        }

        public void setKeywordStrategy(Integer keywordStrategy) {
            this.keywordStrategy = keywordStrategy;
        }
    }

    public QueryInfo getQueryInfo() {
        return queryInfo;
    }

    public void setQueryInfo(QueryInfo queryInfo) {
        this.queryInfo = queryInfo;
    }
}
