package com.fadada.api.bean.req.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @className QueryCompanyTemplateListReq
 * @description 查询企业模板请求对象
 * @createTime 2020年8月14日 15:30:57
 */
@ParamsVerif
public class QueryCompanyTemplateListReq extends BaseReq {

    @ParamsVerif
    private QueryInfo queryInfo;

    @ParamsVerif
    public static class QueryInfo extends BaseBean {
        @ParamsVerif(checkNotNull = false, intContains = {1, 2, 3})
        private Integer templateStatus;

        @ParamsVerif(minValue = "1")
        private Integer currentPageNo;

        @ParamsVerif(minValue = "1")
        private Integer pageSize;

        private Integer status;
        /**
         * 关键字
         */
        private String keyword;

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

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public Integer getTemplateStatus() {
            return templateStatus;
        }

        public void setTemplateStatus(Integer templateStatus) {
            this.templateStatus = templateStatus;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }

    public QueryInfo getQueryInfo() {
        return queryInfo;
    }

    public void setQueryInfo(QueryInfo queryInfo) {
        this.queryInfo = queryInfo;
    }
}
