package com.fadada.api.bean.rsp.template;

import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yh128
 * @className QueryCompanyTemplateListRsp
 * @description 获取模板列表返回对象
 * @createTime 2020年8月20日 15:07:31
 */
public class QueryCompanyTemplateListRsp extends BaseBean {
    /**
     * 总数
     */
    private String total;
    /**
     * 总页数
     */
    private String totalPageCount;
    /**
     * 当前页数
     */

    private String currentPageNo;
    /**
     * 模板列表数据
     */
    private List<CompanyTemplate> list;

    public static class CompanyTemplate extends BaseBean {
        /**
         * 模板ID
         */
        private String templateId;
        /**
         * 模板名称
         */
        private String templateName;
        /**
         * 创建时间
         */
        private String createTime;
        /**
         * 模板类型
         */
        private String templateTypeName;
        /**
         * 创建人
         */
        private String creatorName;

        private Integer templateStatus;

        private Integer status;

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }

        public String getTemplateName() {
            return templateName;
        }

        public void setTemplateName(String templateName) {
            this.templateName = templateName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getTemplateTypeName() {
            return templateTypeName;
        }

        public void setTemplateTypeName(String templateTypeName) {
            this.templateTypeName = templateTypeName;
        }

        public String getCreatorName() {
            return creatorName;
        }

        public void setCreatorName(String creatorName) {
            this.creatorName = creatorName;
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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(String totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public String getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(String currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public List<CompanyTemplate> getList() {
        return list;
    }

    public void setList(List<CompanyTemplate> list) {
        this.list = list;
    }
}
