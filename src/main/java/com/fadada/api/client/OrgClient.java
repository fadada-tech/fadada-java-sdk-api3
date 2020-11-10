package com.fadada.api.client;

import com.fadada.api.FadadaApiClient;
import com.fadada.api.bean.req.organization.*;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.organization.*;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.PreconditionsUtil;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName OrgClient.java
 * @Description 组织架构
 * @Param
 * @createTime 2020年06月17日 14:12:00
 */
public class OrgClient {
    private static final String GET_CHILD_COMPANY_LIST = "POST org/group/getChildCompanyList";
    private static final String GET_EMPLOYEE = "POST org/group/getEmployee";
    private static final String GET_ADD_EMPLOYEE_URL = "POST org/group/getAddEmployeeUrl";
    private static final String DEL_EMPLOYEE = "POST org/group/delEmployee";
    private static final String GET_ADD_SUB_COMPANY_URL = "POST org/group/getAddSubCompanyUrl";
    private static final String REMOVE_SUB_COMPANY = "POST org/group/removeSubCompany";
    private static final String GET_CHANGE_COMPANY_MAJOR_URL = "POST /org/group/getChangeCompanyMajorUrl";

    private FadadaApiClient fadadaApiClient;

    public OrgClient(FadadaApiClient fadadaApiClient) {
        this.fadadaApiClient = fadadaApiClient;
    }


    /**
     * 获取子公司列表
     *
     * @param req
     * @return
     */
    public BaseRsp<List<GetChildCompanyListRsp>> getChildCompanyList(GetChildCompanyListReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPIList(req, GET_CHILD_COMPANY_LIST, GetChildCompanyListRsp.class);
    }

    /**
     * 获取公司员工列表
     *
     * @param req
     * @return
     */
    public BaseRsp<List<GetEmployeeRsp>> getEmployee(GetEmployeeReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPIList(req, GET_EMPLOYEE, GetEmployeeRsp.class);
    }

    /**
     * 获取确认添加员工url
     *
     * @param req
     * @return
     */
    public BaseRsp<GetAddEmployeeUrlRsp> getAddEmployeeUrl(GetAddEmployeeUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_ADD_EMPLOYEE_URL, GetAddEmployeeUrlRsp.class);
    }

    /**
     * 移除员工
     *
     * @param req
     * @return
     */
    public BaseRsp delSubEmployee(DelSubEmployeeReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, DEL_EMPLOYEE, String.class);
    }


    /**
     * 确认添加子公司url
     *
     * @param req
     * @return
     */
    public BaseRsp<GetAddSubCompanyUrlRsp> getAddSubCompanyUrl(GetAddSubCompanyUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_ADD_SUB_COMPANY_URL, GetAddSubCompanyUrlRsp.class);
    }

    /**
     * 移除子公司
     *
     * @param req
     * @return
     */
    public BaseRsp removeSubCompany(RemoveSubCompanyReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, REMOVE_SUB_COMPANY, String.class);
    }

    /**
     * 获取变更公司管理员url
     *
     * @param req
     * @return
     */
    public BaseRsp<GetChangeCompanyMajorUrlRsp> getChangeCompanyMajorUrl(GetChangeCompanyMajorUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_CHANGE_COMPANY_MAJOR_URL, GetChangeCompanyMajorUrlRsp.class);
    }

}
