package com.fadada.api.client;

import com.fadada.api.FadadaApiClient;
import com.fadada.api.bean.req.revise.*;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.revise.CreateReviseTaskRsp;
import com.fadada.api.bean.rsp.revise.GetFillFileUrlRsp;
import com.fadada.api.bean.rsp.revise.ReviseTaskDetailRsp;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.PreconditionsUtil;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName ReviseTaskClient.java
 * @Description 定稿任务
 * @Param
 * @createTime 2020年07月23日 16:59:00
 */
public class ReviseTaskClient {

    private static final String CREATE_REVISE_TASK = "POST /reviseTask/createReviseTask";
    private static final String GET_FILL_FILE_URL = "POST /reviseTask/getFillFileUrl";
    private static final String CANCEL_REVISE_TASK = "POST /reviseTask/cancelReviseTask";
    private static final String REVISE_TASK_DETAIL = "POST /reviseTask/reviseTaskDetail";
    private static final String SAVE_FILL_VALUES = "POST /reviseTask/saveFillValues";


    private FadadaApiClient fadadaApiClient;

    public ReviseTaskClient(FadadaApiClient fadadaApiClient) {

        this.fadadaApiClient = fadadaApiClient;
    }

    /**
     * 创建定稿任务
     *
     * @param req
     * @return
     */
    public BaseRsp<CreateReviseTaskRsp> createReviseTask(CreateReviseTaskReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, CREATE_REVISE_TASK, CreateReviseTaskRsp.class);
    }

    /**
     * 生成填充链接
     *
     * @param req
     * @return
     */
    public BaseRsp<GetFillFileUrlRsp> getFillFileUrl(GetFillFileUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_FILL_FILE_URL, GetFillFileUrlRsp.class);
    }

    /**
     * 定稿流程撤销
     *
     * @param req
     * @return
     */
    public BaseRsp cancelReviseTask(CancelReviseTaskReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, CANCEL_REVISE_TASK, String.class);
    }

    /**
     * 定稿流程详请
     *
     * @param req
     * @return
     */
    public BaseRsp<ReviseTaskDetailRsp> reviseTaskDetail(ReviseTaskDetailReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, REVISE_TASK_DETAIL, ReviseTaskDetailRsp.class);
    }

    /**
     * 定稿任务接口填充
     *
     * @param req
     * @return
     */
    public BaseRsp saveFillValues(SaveFillValuesReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, SAVE_FILL_VALUES, String.class);
    }
}