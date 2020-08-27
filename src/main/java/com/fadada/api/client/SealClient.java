package com.fadada.api.client;

import com.fadada.api.FadadaApiClient;
import com.fadada.api.bean.req.seal.*;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.seal.AddCompanySealRsp;
import com.fadada.api.bean.rsp.seal.CompanySealDetailRsp;
import com.fadada.api.bean.rsp.seal.CompanySealListRsp;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.PreconditionsUtil;
import com.fadada.api.utils.crypt.HashFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName SealClient.java
 * @Description 签章
 * @Param
 * @createTime 2020年06月17日 14:10:00
 */
public class SealClient {
    private static final String ADD_COMPANY_SEAL = "POST /seal/addCompanySeal";
    private static final String DEL_COMPANY_SEAL = "POST /seal/delCompanySeal";
    private static final String SEAL_AUTH = "POST /seal/sealAuth";
    private static final String CANCEL_SEAL_AUTH = "POST /seal/cancelSealAuth";
    private static final String COMPANY_SEAL_LIST = "POST /seal/companySealList";
    private static final String COMPANY_SEAL_DETAIL = "POST /seal/companySealDetail";
    private static final Pattern CONTRACT_IMAGE_PATTERN = Pattern.compile(".+(.jpg|.png|.JPG|.PNG)$");
    private static final long IMAGE_FILE_SIZE = 1024 * 1024 * 2;

    private FadadaApiClient fadadaApiClient;

    public SealClient(FadadaApiClient fadadaApiClient) {
        this.fadadaApiClient = fadadaApiClient;
    }

    /**
     * 上传企业签章
     *
     * @param token
     * @param req
     * @param imageFile
     * @return
     */
    public BaseRsp<AddCompanySealRsp> addCompanySeal(String token, AddCompanySealReq req, File imageFile) throws ApiException {
        PreconditionsUtil.checkObject(req);
        PreconditionsUtil.checkArgument(imageFile == null || imageFile.length() == 0, "imageFile为空");
        PreconditionsUtil.checkArgument(imageFile.length() > IMAGE_FILE_SIZE, "imageFile不能超过20M");
        PreconditionsUtil.checkArgument(!CONTRACT_IMAGE_PATTERN.matcher(imageFile.getName()).matches(), "imageFile格式错误");

        req.getSealInfo().setImageHash(HashFile.getFileSHA256(imageFile));
        Map<String, File> files = new HashMap<>(1);
        files.put("image", imageFile);
        return fadadaApiClient.invokeAPI(token, req, ADD_COMPANY_SEAL, files, AddCompanySealRsp.class);
    }

    /**
     * 删除企业签章
     *
     * @param token
     * @param req
     * @return
     */
    public BaseRsp delCompanySeal(String token, DelCompanySealReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, DEL_COMPANY_SEAL, Object.class);
    }

    /**
     * 签章授权
     *
     * @param token
     * @param req
     * @return
     */
    public BaseRsp sealAuth(String token, SealAuthReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, SEAL_AUTH, Object.class);
    }

    /**
     * 签章取消授权
     *
     * @param token
     * @param req
     * @return
     */
    public BaseRsp cancelSealAuth(String token, CancelSealAuthReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, CANCEL_SEAL_AUTH, Object.class);
    }

    /**
     * 企业签章列表
     *
     * @param token
     * @param req
     * @return
     */
    public BaseRsp<CompanySealListRsp> companySealList(String token, CompanySealListReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, COMPANY_SEAL_LIST, CompanySealListRsp.class);
    }

    /**
     * 企业签章详请
     *
     * @param token
     * @param req
     * @return
     */
    public BaseRsp<CompanySealDetailRsp> companySealDetail(String token, CompanySealDetailReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, COMPANY_SEAL_DETAIL, CompanySealDetailRsp.class);
    }
}
