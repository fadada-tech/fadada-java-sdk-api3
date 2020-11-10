package com.fadada.api.bean.req.document;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName ContractReportDownloadReq.java
 * @Description 技术报告下载请求对象
 * @Param
 * @createTime 2020年07月23日 14:30:00
 */
@ParamsVerif
public class ContractReportDownloadReq extends BaseReq {
    @ParamsVerif
    private ContractInfo contractInfo;

    @ParamsVerif
    public static class ContractInfo extends BaseBean {

        @ParamsVerif(checkNotEmpty = true)
        private String taskId;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }
    }

    public ContractInfo getContractInfo() {
        return contractInfo;
    }

    public void setContractInfo(ContractInfo contractInfo) {
        this.contractInfo = contractInfo;
    }
}
