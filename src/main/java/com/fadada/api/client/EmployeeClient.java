package com.fadada.api.client;

import com.fadada.api.FadadaApiClient;
import com.fadada.api.bean.req.organization.AddEmployeeReq;
import com.fadada.api.bean.req.organization.BatchSyncEmployeeReq;
import com.fadada.api.bean.req.organization.DelEmployeeReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.PreconditionsUtil;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName EmployeeClient.java
 * @Description 员工
 * @Param
 * @createTime 2020年06月17日 14:12:00
 */
public class EmployeeClient {
    private static final String ADD_EMPLOYEE = "POST org/employee/addEmployee";
    private static final String DEL_EMPLOYEE = "POST org/employee/delEmployee";
    private static final String BATCH_SYNC_EMPLOYEE = "POST org/employee/batchSyncEmployee";

    private FadadaApiClient fadadaApiClient;

    public EmployeeClient(FadadaApiClient fadadaApiClient) {
        this.fadadaApiClient = fadadaApiClient;
    }

    /**
     * 新增员工
     *
     * @param req
     * @return
     */
    public BaseRsp addEmployee(AddEmployeeReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, ADD_EMPLOYEE, String.class);
    }


    /**
     * 删除员工
     *
     * @param req
     * @return
     */
    public BaseRsp delEmployee(DelEmployeeReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, DEL_EMPLOYEE, String.class);
    }


    /**
     * 批量同步员工数据
     *
     * @param req
     * @return
     */
    public BaseRsp batchSyncEmployee(BatchSyncEmployeeReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, BATCH_SYNC_EMPLOYEE, String.class);
    }

}
