package com.fadada.api.client;

import com.fadada.api.FadadaApiClient;
import com.fadada.api.bean.req.sign.*;
import com.fadada.api.bean.req.sign.file.FileSignTaskReq;
import com.fadada.api.bean.req.sign.template.CreateByDraftIdReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.sign.*;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.PreconditionsUtil;

/**
 * @author gengxl
 * @create 2020-03-07 9:43
 */
public class SignTaskClient {
    private static final String SIGNTASKS_CREATE_BY_FILE = "POST /signtasks/createByFile";
    private static final String SIGNTASKS_CREATE_BY_DRAFT_ID = "POST /signtasks/createByDraftId";
    private static final String GET_SIGN_URL = "POST /signtasks/getSignUrl";
    private static final String GET_TASK_DETAIL_BY_TASK_ID = "POST /signtasks/getTaskDetailByTaskId";
    private static final String CANCEL = "POST /signtasks/cancel";
    private static final String GET_SENT_URL = "POST /signtasks/getSentUrl";
    private static final String URGE_SIGN = "POST /signtasks/urgeSign";
    private static final String GET_SIGN_PREVIEW_URL = "POST /signtasks/getSignPreviewUrl";


    private FadadaApiClient fadadaApiClient;

    public SignTaskClient(FadadaApiClient fadadaApiClient) {
        this.fadadaApiClient = fadadaApiClient;
    }

    /**
     * 利用文件库id创建签署任务
     *
     * @param req
     * @return
     */
    public BaseRsp<FileSignTaskRsp> createSignTaskByFileId(String token, FileSignTaskReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, SIGNTASKS_CREATE_BY_FILE, FileSignTaskRsp.class);
    }

    /**
     * 根据模板创建签署任务
     *
     * @param req
     * @return
     */
    public BaseRsp<TemplateSignTaskRsp> createSignTaskByDraftId(String token, CreateByDraftIdReq req)
            throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, SIGNTASKS_CREATE_BY_DRAFT_ID, TemplateSignTaskRsp.class);
    }

    /**
     * 获取签署链接
     *
     * @param req
     * @return
     */
    public BaseRsp<GetSignUrlRsp> getSignUrl(String token, GetSignUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, GET_SIGN_URL, GetSignUrlRsp.class);
    }


    /**
     * 查询签署详情
     *
     * @param req
     * @return
     */
    public BaseRsp<GetTaskDetailsRes> getTaskDetailByTaskId(String token, GetTaskDetailReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, GET_TASK_DETAIL_BY_TASK_ID, GetTaskDetailsRes.class);
    }

    /**
     * 撤销签署任务
     *
     * @param token
     * @param req
     * @return
     */
    public BaseRsp cancelSignTask(String token, CancelSignTaskReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, CANCEL, Object.class);
    }

    /**
     * 获取签署任务发起链接
     *
     * @param token
     * @param req
     * @return
     */
    public BaseRsp<GetSentUrlRsp> getSentUrl(String token, GetSentUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, GET_SENT_URL, GetSentUrlRsp.class);
    }

    /**
     * 催签
     *
     * @param token
     * @param req
     * @return
     */
    public BaseRsp urgeSign(String token, UrgeSignReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, URGE_SIGN, String.class);
    }

    /**
     * 获取预览链接
     *
     * @param req
     * @return
     */
    public BaseRsp<GetSignPreviewUrlRsp> getSignPreviewUrl(String token, GetSignPreviewUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, GET_SIGN_PREVIEW_URL, GetSignPreviewUrlRsp.class);
    }

}
