package com.fadada.api.client;

import com.fadada.api.FadadaApiClient;
import com.fadada.api.bean.req.issp.SyncContractFileInfoReq;
import com.fadada.api.bean.req.issp.SyncTemplateFileInfoReq;
import com.fadada.api.bean.req.issp.WitnessReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.issp.SyncContractFileInfoRsp;
import com.fadada.api.bean.rsp.issp.SyncTemplateFileInfoRsp;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.PreconditionsUtil;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName IsspApiClient.java
 * @Description ISSP api接口
 * @Param
 * @createTime 2020年11月07日 09:24:00
 */
public class IsspApiClient {
    private static final String SYNC_CONTRACT_FILE_INFO = "POST documents/sdk/syncContractFileInfo";
    private static final String SYNC_TEMPLATE_FILE_INFO = "POST  documents/sdk/syncTemplateFileInfo";
    private static final String WITNESS = "POST documents/sdk/witness";

    private FadadaApiClient fadadaApiClient;

    public IsspApiClient(FadadaApiClient fadadaApiClient) {
        this.fadadaApiClient = fadadaApiClient;
    }

    public BaseRsp<SyncContractFileInfoRsp> syncContractFileInfo(SyncContractFileInfoReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, SYNC_CONTRACT_FILE_INFO, SyncContractFileInfoRsp.class);
    }

    public BaseRsp<SyncTemplateFileInfoRsp> syncTemplateFileInfo(SyncTemplateFileInfoReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, SYNC_TEMPLATE_FILE_INFO, SyncTemplateFileInfoRsp.class);
    }

    public BaseRsp witness(WitnessReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, WITNESS, String.class);
    }

}
