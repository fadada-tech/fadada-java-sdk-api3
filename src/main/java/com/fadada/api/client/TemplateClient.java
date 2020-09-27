package com.fadada.api.client;

import com.fadada.api.FadadaApiClient;
import com.fadada.api.bean.req.template.CreateByTemplateReq;
import com.fadada.api.bean.req.template.GetTemplateDetailByIdReq;
import com.fadada.api.bean.req.template.*;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.document.DownLoadFileRsp;
import com.fadada.api.bean.rsp.template.DraftRsp;
import com.fadada.api.bean.rsp.template.GetTemplateDetailByIdRsp;
import com.fadada.api.bean.rsp.template.*;
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
 * @ClassName TemplateClient.java
 * @Description 合同模板
 * @Param
 * @createTime 2020年07月23日 16:59:00
 */
public class TemplateClient {

    private static final String UPLOAD_COMPANY_TEMPLATE_FILE = "POST /template/uploadCompanyTemplateFile";
    private static final String UPDATE_COMPANY_TEMPLATE = "POST /template/updateCompanyTemplate";
    private static final String GET_EDITCOMPANY_TEMPLATE_URL = "POST /template/getEditCompanyTemplateUrl";
    private static final String DEL_COMPANY_TEMPLATE_FILE = "POST /template/delCompanyTemplateFile";
    private static final String GET_COMPANY_TEMPLATE_PREVIEW_URL = "POST /template/getCompanyTemplatePreviewUrl";
    private static final String QUERY_COMPANY_TEMPLATE_LIST = "POST /template/queryCompanyTemplateList";
    private static final String DOWNLOAD_COMPANY_TEMPLATE_FILE = "POST /template/downloadCompanyTemplateFile";
    private static final String GET_TEMPLATED_ETAIL_BY_ID = "POST /documents/getTemplateDetailById";
    private static final String CREATE_BY_TEMPLATEID = "POST /documents/createByTemplate";


    /**
     * 模板文件支持格式
     */
    public static final Pattern TEMPLATE_FILE_PATTERN = Pattern.compile(".+(.doc|.docx|.wps|.pdf|.xls|.xlsx)$");
    /**
     * 模板附件支持格式
     */
    public static final Pattern TEMPLATE_ATTACH_PATTERN = Pattern.compile(".+(.doc|.docx|.wps|.jpeg|.jpg|.png|.pdf|.xls|.xlsx)$");

    /**
     * 模板文件附件最大值
     */
    private static final int TEMPLATE_FILE_SIZE = 20 * 1024 * 1024;

    private FadadaApiClient fadadaApiClient;

    public TemplateClient(FadadaApiClient fadadaApiClient) {
        this.fadadaApiClient = fadadaApiClient;
    }

    /**
     * 上传企业模板文件
     *
     * @param token
     * @param req
     * @param file
     * @return
     */
    public BaseRsp<UploadCompanyTemplateFileRsp> uploadCompanyTemplateFile(String token,
                                                                           UploadCompanyTemplateFileReq req, File file) throws ApiException {
        PreconditionsUtil.checkObject(req);
        PreconditionsUtil.checkArgument(file == null || file.length() == 0, "file为空");
        Integer fileType = req.getTemplateInfo().getFileType();
        PreconditionsUtil.checkArgument(file.length() > TEMPLATE_FILE_SIZE, "file超过限制大小");
        PreconditionsUtil.checkArgument(fileType.equals(1) && !TEMPLATE_FILE_PATTERN.matcher(file.getName()).matches(),
                "模板文件格式错误");
        PreconditionsUtil.checkArgument(fileType.equals(2) && !TEMPLATE_ATTACH_PATTERN.matcher(file.getName()).matches(),
                "模板附件格式错误");
        req.setFileHash(HashFile.getFileSHA256(file));
        Map<String, File> fileMap = new HashMap<>(1);
        fileMap.put("file", file);
        return fadadaApiClient.invokeAPI(token, req, UPLOAD_COMPANY_TEMPLATE_FILE, fileMap, UploadCompanyTemplateFileRsp.class);
    }

    /**
     * 修改企业模板信息
     *
     * @param token
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp<UpdateCompanyTemplateRsp> updateCompanyTemplate(String token, UpdateCompanyTemplateReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, UPDATE_COMPANY_TEMPLATE, UpdateCompanyTemplateRsp.class);
    }

    /**
     * 获取合同模板控件维护链接
     *
     * @param token
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp<GetEditCompanyTemplateUrlRsp> getEditCompanyTemplateUrl(String token,
                                                                           GetEditCompanyTemplateUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, GET_EDITCOMPANY_TEMPLATE_URL, GetEditCompanyTemplateUrlRsp.class);
    }

    /**
     * 删除合同模板文件
     *
     * @param token
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp delCompanyTemplateFile(String token, DelCompanyTemplateFileReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, DEL_COMPANY_TEMPLATE_FILE, GetEditCompanyTemplateUrlRsp.class);
    }

    /**
     * 获取模板预览链接
     *
     * @param token
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp<GetCompanyTemplatePreviewUrlRsp> getCompanyTemplatePreviewUrl(String token,
                                                                                 GetEditCompanyTemplateUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, GET_COMPANY_TEMPLATE_PREVIEW_URL, GetCompanyTemplatePreviewUrlRsp.class);
    }


    /**
     * 模板列表
     *
     * @param token
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp<QueryCompanyTemplateListRsp> queryCompanyTemplateList(String token,
                                                                         QueryCompanyTemplateListReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, QUERY_COMPANY_TEMPLATE_LIST, QueryCompanyTemplateListRsp.class);
    }


    /**
     * 模板文件下载
     *
     * @param token
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp<DownLoadFileRsp> downloadCompanyTemplateFile(String token, DownloadCompanyTemplateFileReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPIDownload(token, req, DOWNLOAD_COMPANY_TEMPLATE_FILE, DownLoadFileRsp.class);
    }

    /**
     * 查询模板详情
     *
     * @param token
     * @param req
     * @return
     */
    public BaseRsp<GetTemplateDetailByIdRsp> getTemplateDetailById(String token, GetTemplateDetailByIdReq req)
            throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, GET_TEMPLATED_ETAIL_BY_ID, GetTemplateDetailByIdRsp.class);
    }


    /**
     * 填充模板
     *
     * @param req
     * @return
     */
    public BaseRsp<DraftRsp> createByTemplate(String token, CreateByTemplateReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, CREATE_BY_TEMPLATEID, DraftRsp.class);
    }


}
