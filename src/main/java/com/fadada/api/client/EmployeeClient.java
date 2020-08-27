package com.fadada.api.client;

import com.fadada.api.FadadaApiClient;
import com.fadada.api.bean.req.organization.AddEmployeeReq;
import com.fadada.api.bean.req.organization.DelEmployeeReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.PreconditionsUtil;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName EmployeeClient.java
 * @Description 员工
 * @Param
 * @createTime 2020年06月17日 14:12:00
 */
public class EmployeeClient {
    private static final String ADD_EMPLOYEE = "POST /org/employee/addEmployee";
    private static final String DEL_EMPLOYEE = "POST /org/employee/delEmployee";

    private FadadaApiClient fadadaApiClient;

    public EmployeeClient(FadadaApiClient fadadaApiClient) {
        this.fadadaApiClient = fadadaApiClient;
    }

    /**
     * 新增员工
     *
     * @param token
     * @param req
     * @return
     */
    public BaseRsp addEmployee(String token, AddEmployeeReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, ADD_EMPLOYEE, Object.class);
    }


    /**
     * 删除员工
     *
     * @param token
     * @param req
     * @return
     */
    public BaseRsp delEmployee(String token, DelEmployeeReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, DEL_EMPLOYEE, Object.class);
    }

}
