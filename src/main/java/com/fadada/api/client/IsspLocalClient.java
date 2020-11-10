package com.fadada.api.client;

import com.fadada.api.DefaultFadadaApiServiceImpl;
import com.fadada.api.FadadaApiClient;
import com.fadada.api.FadadaApiService;
import com.fadada.api.bean.req.issp.DownloadFileReq;
import com.fadada.api.bean.req.issp.UploadFileReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.document.DownLoadFileRsp;
import com.fadada.api.bean.rsp.issp.UploadFileRsp;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.PreconditionsUtil;
import com.fadada.api.utils.json.ParameterizedTypeBaseRsp;
import com.fadada.api.utils.string.StringUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName IsspLocalClient.java
 * @Description ISSP local接口
 * @Param
 * @createTime 2020年11月07日 09:24:00
 */
public class IsspLocalClient {

    private static final String UPLOAD_FILE = "issp/intranet/uploadFile";
    private static final String DOWNLOAD_FILE = "issp/intranet/downloadFile";


    /**
     * issp服务请求地址
     */
    private String isspServerUrl = "";

    private static FadadaApiService fadadaApiService = new DefaultFadadaApiServiceImpl();

    public IsspLocalClient(String isspServerUrl) {
        if (StringUtil.isBlank(isspServerUrl)) {
            PreconditionsUtil.checkArgument(true, "isspServerUrl不能为空");
        }
        this.isspServerUrl = isspServerUrl;
    }

    public static void setFadadaApiService(FadadaApiService fadadaApiService) {
        IsspLocalClient.fadadaApiService = fadadaApiService;
    }

    /**
     * 文件上传
     *
     * @param file
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp<UploadFileRsp> uploadFile(File file, UploadFileReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        Map<String, File> fileMap = new HashMap<>();
        fileMap.put("file", file);
        Map<String, String> bodyMap = new HashMap<>();
        bodyMap.put("bizContent", fadadaApiService.toJson(req));
        String resultStr = fadadaApiService.http(isspServerUrl + UPLOAD_FILE, "POST", null, bodyMap, fileMap);
        return fadadaApiService.toJavaBean(resultStr, new ParameterizedTypeBaseRsp(UploadFileRsp.class));
    }

    /**
     * 文件下载
     *
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp<DownLoadFileRsp> downloadFile(DownloadFileReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        Map<String, String> bodyMap = new HashMap<>();
        bodyMap.put("bizContent", fadadaApiService.toJson(req));
        Object result = fadadaApiService.httpDownLoad(isspServerUrl + DOWNLOAD_FILE, "POST", null, bodyMap);
        String resultString = null;
        if (result instanceof String) {
            resultString = result.toString();
        } else {
            resultString = FadadaApiClient.getFadadaApiService().toJson(result);
        }
        return FadadaApiClient.getFadadaApiService().toJavaBean(resultString,
                new ParameterizedTypeBaseRsp(DownLoadFileRsp.class));
    }

}
