package com.fadada.api.client;

import com.fadada.api.FadadaApiClient;
import com.fadada.api.bean.req.document.*;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.document.DownLoadFileRsp;
import com.fadada.api.bean.rsp.document.LookUpCoordinatesRsp;
import com.fadada.api.bean.rsp.document.UploadFileRsp;
import com.fadada.api.bean.rsp.document.VerifySignatureRsp;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.PreconditionsUtil;
import com.fadada.api.utils.crypt.HashFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author gengxl
 * @create 2020-03-07 9:43
 */
public class DocumentClient {

    private static final String UPLOAD_FILE = "POST documents/uploadFile";
    private static final String GET_BY_SIGN_FILE_ID = "POST documents/getBySignFileId";
    private static final String GET_BY_DRAFT_ID = "POST documents/getByDraftId";
    private static final String LOOK_UP_COORDINATES = "POST documents/lookUpCoordinates";
    private static final String VERIFY_SIGNATURE = "POST documents/verifySignature";
    private static final String CONTRACT_REPORT_DOWNLOAD = "POST documents/professionalContractReportDownload";
    private static final String DOWNLOAD_EVIDENCE_REPORT = "POST documents/downloadEvidenceReport";
    private static final String UPLOAD_FILE_BY_URL = "POST documents/uploadFileByUrl";

    /**
     * pdf文件大小
     */
    private static final int PDF_FILE_SIZE = 20 * 1024 * 1024;

    /**
     * pdf文件格式
     */
    public static final Pattern PDF_FILE_PATTERN = Pattern.compile(".+(.pdf)$");

    private FadadaApiClient fadadaApiClient;

    public DocumentClient(FadadaApiClient fadadaApiClient) {
        this.fadadaApiClient = fadadaApiClient;
    }


    /**
     * 上传文件
     *
     * @param req
     * @param file
     * @return
     */
    public BaseRsp<UploadFileRsp> uploadFile(UploadFileReq req, File file) throws ApiException {
        PreconditionsUtil.checkObject(req);
        PreconditionsUtil.checkNotNull(file, "file不能为空");
        req.setFileContentHash(HashFile.getFileSHA256(file));
        Map<String, File> files = new HashMap<>(1);
        files.put("fileContent", file);
        return fadadaApiClient.invokeAPI(req, UPLOAD_FILE, files, UploadFileRsp.class);
    }


    /**
     * 通过链接上传文件
     *
     * @param req
     * @return
     */
    public BaseRsp<UploadFileRsp> uploadFileByUrl(UploadFileByUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, UPLOAD_FILE_BY_URL, UploadFileRsp.class);
    }

    /**
     * 下载签署文档
     */
    public BaseRsp<DownLoadFileRsp> getBySignFileId(GetBySignFileIdReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPIDownload(req, GET_BY_SIGN_FILE_ID, DownLoadFileRsp.class);
    }

    /**
     * 下载草稿文档
     */
    public BaseRsp<DownLoadFileRsp> getByDraftId(GetByDraftIdReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPIDownload(req, GET_BY_DRAFT_ID, DownLoadFileRsp.class);
    }


    /**
     * 关键字查询坐标
     *
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp<LookUpCoordinatesRsp> lookUpCoordinates(LookUpCoordinatesReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, LOOK_UP_COORDINATES, LookUpCoordinatesRsp.class);
    }

    /**
     * 合同文件验签
     *
     * @param req
     * @param file
     * @return
     * @throws ApiException
     */
    public BaseRsp<VerifySignatureRsp> verifySignature(VerifySignatureReq req, File file) throws ApiException {
        PreconditionsUtil.checkObject(req);
        PreconditionsUtil.checkArgument(file == null || file.length() == 0, "file为空");
        PreconditionsUtil.checkArgument(file.length() > PDF_FILE_SIZE, "file超过限制大小");
        PreconditionsUtil.checkArgument(!PDF_FILE_PATTERN.matcher(file.getName()).matches(), "file格式错误");
        req.setFileHash(HashFile.getFileSHA256(file));
        Map<String, File> fileMap = new HashMap<>(1);
        fileMap.put("file", file);
        return fadadaApiClient.invokeAPI(req, VERIFY_SIGNATURE, fileMap, VerifySignatureRsp.class);
    }

    /**
     * 下载合同技术报告
     *
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp<DownLoadFileRsp> contractReportDownload(ContractReportDownloadReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPIDownload(req, CONTRACT_REPORT_DOWNLOAD, DownLoadFileRsp.class);
    }

    /**
     * 下载公证处报告
     *
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp<DownLoadFileRsp> downloadEvidenceReport(DownloadEvidenceReportReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPIDownload(req, DOWNLOAD_EVIDENCE_REPORT, DownLoadFileRsp.class);
    }


}
