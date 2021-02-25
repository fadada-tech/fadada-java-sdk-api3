package com.fadada.api.client;

import com.fadada.api.FadadaApiClient;
import com.fadada.api.bean.req.sign.*;
import com.fadada.api.bean.req.sign.batch.*;
import com.fadada.api.bean.req.sign.draft.CreateTaskByDraftIdReq;
import com.fadada.api.bean.req.sign.file.FileSignTaskReq;
import com.fadada.api.bean.req.sign.template.CreateByDraftIdReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.sign.*;
import com.fadada.api.bean.rsp.sign.batch.BatchCreateByDraftIdRsp;
import com.fadada.api.bean.rsp.sign.batch.BatchGetSignUrlRsp;
import com.fadada.api.bean.rsp.sign.batch.BatchGetSigntasksByBatchNoRsp;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.PreconditionsUtil;

/**
 * @author gengxl
 * @create 2020-03-07 9:43
 */
public class SignTaskClient {
    private static final String SIGNTASKS_CREATE_BY_FILE = "POST signtasks/createByFile";
    private static final String SIGNTASKS_CREATE_BY_DRAFT_ID = "POST signtasks/createByDraftId";
    private static final String GET_SIGN_URL = "POST signtasks/getSignUrl";
    private static final String GET_TASK_DETAIL_BY_TASK_ID = "POST signtasks/getTaskDetailByTaskId";
    private static final String CANCEL = "POST signtasks/cancel";
    private static final String GET_SENT_URL = "POST signtasks/getSentUrl";
    private static final String URGE_SIGN = "POST signtasks/urgeSign";
    private static final String GET_SIGN_PREVIEW_URL = "POST signtasks/getSignPreviewUrl";
    private static final String CREATE_TASK_BY_FILE = "POST signtasks/createTaskByFile";
    private static final String CREATE_TASK_BY_DRAFT_ID = "POST signtasks/createTaskByDraftId";
    private static final String UNLOCK = "POST signtasks/unlock";
    private static final String GET_QUICK_SIGN_URL = "POST signtasks/getQuickSignUrl";

    /**
     * 批次号任务
     */
    private static final String BATCH_CREATE_BY_DRAFT_ID = "POST batch/signtasks/createByDraftId";
    private static final String BATCH_SENT = "POST batch/signtasks/sent";
    private static final String BATCH_ADD_BY_DRAFT_ID = "POST batch/signtasks/addByDraftId";
    private static final String BATCH_GET_SIGN_URL = "POST batch/signtasks/getSignUrl";
    private static final String BATCH_GET_SIGNTASKS_BY_BATCH_NO = "POST batch/signtasks/getSigntasksByBatchNo";

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
    @Deprecated
    public BaseRsp<FileSignTaskRsp> createSignTaskByFileId(FileSignTaskReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, SIGNTASKS_CREATE_BY_FILE, FileSignTaskRsp.class);
    }

    /**
     * 根据模板创建签署任务
     *
     * @param req
     * @return
     */
    @Deprecated
    public BaseRsp<TemplateSignTaskRsp> createSignTaskByDraftId(CreateByDraftIdReq req)
            throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, SIGNTASKS_CREATE_BY_DRAFT_ID, TemplateSignTaskRsp.class);
    }

    /**
     * 获取签署链接
     *
     * @param req
     * @return
     */
    public BaseRsp<GetSignUrlRsp> getSignUrl(GetSignUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_SIGN_URL, GetSignUrlRsp.class);
    }


    /**
     * 查询签署详情
     *
     * @param req
     * @return
     */
    public BaseRsp<GetTaskDetailsRes> getTaskDetailByTaskId(GetTaskDetailReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_TASK_DETAIL_BY_TASK_ID, GetTaskDetailsRes.class);
    }

    /**
     * 撤销签署任务
     *
     * @param req
     * @return
     */
    public BaseRsp cancelSignTask(CancelSignTaskReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, CANCEL, Object.class);
    }

    /**
     * 获取签署任务发起链接
     *
     * @param req
     * @return
     */
    public BaseRsp<GetSentUrlRsp> getSentUrl(GetSentUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_SENT_URL, GetSentUrlRsp.class);
    }

    /**
     * 催签
     *
     * @param req
     * @return
     */
    public BaseRsp urgeSign(UrgeSignReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, URGE_SIGN, String.class);
    }

    /**
     * 获取预览链接
     *
     * @param req
     * @return
     */
    public BaseRsp<GetSignPreviewUrlRsp> getSignPreviewUrl(GetSignPreviewUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_SIGN_PREVIEW_URL, GetSignPreviewUrlRsp.class);
    }

    /**
     * 依据原始文件创建签署任务
     *
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp<CreateTaskByFileRsp> createTaskByFile(CreateTaskByFileReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, CREATE_TASK_BY_FILE, CreateTaskByFileRsp.class);
    }

    /**
     * 依据草稿id批量创建签署任务
     *
     * @param req
     * @return
     */
    public BaseRsp<BatchCreateByDraftIdRsp> batchCreateByDraftId(BatchCreateByDraftIdReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, BATCH_CREATE_BY_DRAFT_ID, BatchCreateByDraftIdRsp.class);
    }

    /**
     * 根据批次号批量发起签署任务
     *
     * @param req
     * @return
     */
    public BaseRsp batchSent(BatchSentReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, BATCH_SENT, String.class);
    }

    /**
     * 根据批次号添加签署任务（依据草稿id创建）
     *
     * @param req
     * @return
     */
    public BaseRsp batchAddByDraftId(BatchAddByDraftIdReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, BATCH_ADD_BY_DRAFT_ID, String.class);
    }

    /**
     * 根据批次号获取签署链接
     *
     * @param req
     * @return
     */
    public BaseRsp<BatchGetSignUrlRsp> batchGetSignUrl(BatchGetSignUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, BATCH_GET_SIGN_URL, BatchGetSignUrlRsp.class);
    }


    /**
     * 根据批次号查询签署任务
     *
     * @param req
     * @return
     */
    public BaseRsp<BatchGetSigntasksByBatchNoRsp> batchGetSigntasksByBatchNo(
            BatchGetSigntasksByBatchNoReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, BATCH_GET_SIGNTASKS_BY_BATCH_NO, BatchGetSigntasksByBatchNoRsp.class);
    }

    /**
     * 基于模板草稿id创建签署任务
     *
     * @param req
     * @return
     */
    public BaseRsp<CreateTaskByDraftIdRsp> createTaskByDraftId(
            CreateTaskByDraftIdReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, CREATE_TASK_BY_DRAFT_ID, CreateTaskByDraftIdRsp.class);
    }

    /**
     * 解锁
     *
     * @param req
     * @return
     */
    public BaseRsp<UnlockRsp> unlock(UnlockReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, UNLOCK, UnlockRsp.class);
    }

    /**
     * 获取快捷签链接
     *
     * @param req
     * @return
     */
    public BaseRsp<GetQuickSignUrlRsp> getQuickSignUrl(GetQuickSignUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_QUICK_SIGN_URL, GetQuickSignUrlRsp.class);
    }

}
