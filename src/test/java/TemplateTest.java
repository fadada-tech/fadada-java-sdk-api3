import com.fadada.api.bean.req.template.*;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.document.DownLoadFileRsp;
import com.fadada.api.bean.rsp.template.*;
import com.fadada.api.client.TemplateClient;
import com.fadada.api.exception.ApiException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gengxl
 * @create 2020-03-06 18:17
 */
public class TemplateTest extends BaseTest {
    //            private String templateId = "1600065269275198965";
    // 本地
    private String templateId = "1606283413370186589";
    private String fileId = "";

    private static TemplateClient templateClient;


    public static void main(String[] args) throws ApiException {
        TemplateTest templateTest = new TemplateTest();
        templateTest.getToken();
        templateClient = new TemplateClient(client);
//        templateTest.uploadCompanyTemplateFile();
//        templateTest.updateCompanyTemplate();
//        templateTest.getEditCompanyTemplateUrl();
//        templateTest.delCompanyTemplateFile();
//        templateTest.getCompanyTemplatePreviewUrl();
//        templateTest.queryCompanyTemplateList();
//        templateTest.downloadCompanyTemplateFile();
//        templateTest.getTemplateDetailById();
//        templateTest.createByTemplate();

        templateTest.getTemplateMainUrl();
        templateTest.getTemplateDetail();
        templateTest.templateInit();


    }

    /**
     * 上传企业模板文件附件
     */
    private void uploadCompanyTemplateFile() throws ApiException {
        UploadCompanyTemplateFileReq req = new UploadCompanyTemplateFileReq();
        req.setToken(token);
        req.setFileType(1, templateId);
        File file = new File("C:\\Users\\yangh1\\Desktop\\工作\\福州基础服务SITUAT环境CICD信息.pdf");
        BaseRsp<UploadCompanyTemplateFileRsp> result = templateClient.uploadCompanyTemplateFile(req, file);
        System.out.println(result.toString());
        if (result.isSuccess()) {
            templateId = result.getData().getTemplateId();
        }
    }

    /**
     * 模板初始化
     */
    private void templateInit() throws ApiException {
        TemplateInitReq req = new TemplateInitReq();
        req.setToken(token);
        TemplateInitReq.TemplateInfo templateInfo = new TemplateInitReq.TemplateInfo();
        templateInfo.setTemplateName("测试模板");
        templateInfo.setTemplateRemark("这是模板哦");
        req.setTemplateInfo(templateInfo);
        BaseRsp<TemplateInitRsp> rsp = templateClient.templateInit(req);
        System.out.println(rsp.toString());
    }


    /**
     * 获取模板编辑链接
     */
    private void getTemplateMainUrl() throws ApiException {
        GetTemplateMainUrlReq req = new GetTemplateMainUrlReq();
        req.setToken(token);
        GetTemplateMainUrlReq.TemplateInfo templateInfo = new GetTemplateMainUrlReq.TemplateInfo();
        templateInfo.setTemplateId(templateId);
        req.setTemplateInfo(templateInfo);
        BaseRsp<GetTemplateMainUrlRsp> rsp = templateClient.getTemplateMainUrl(req);
        System.out.println(rsp.toString());
    }

    /**
     * 获取模板详请
     */
    private void getTemplateDetail() throws ApiException {
        GetTemplateDetailReq req = new GetTemplateDetailReq();
        req.setToken(token);
        req.setTemplateId(templateId);
        BaseRsp<GetTemplateDetailRsp> rsp = templateClient.getTemplateDetail(req);
        System.out.println(rsp.toString());
    }


    /**
     * 修改企业模板信息
     */
    private void updateCompanyTemplate() throws ApiException {

        UpdateCompanyTemplateReq req = new UpdateCompanyTemplateReq();
        req.setToken(token);
        UpdateCompanyTemplateReq.TemplateInfo templateInfo = new UpdateCompanyTemplateReq.TemplateInfo();
        templateInfo.setTemplateName("OpenApiV3模板名称");
        templateInfo.setTemplateRemark("templateRemark备注");
        templateInfo.setTemplateId(templateId);
        templateInfo.setSortType(2);
        UpdateCompanyTemplateReq.Target target = new UpdateCompanyTemplateReq.Target();
        target.setRoleName("YH");
        target.setTargetId("1599473947753127806");
        target.setRoleType(1);
        target.setTargetId("1600066430054130045");

        UpdateCompanyTemplateReq.Target target1 = new UpdateCompanyTemplateReq.Target();
        target1.setRoleName("HY");
        target1.setTargetId("1599473947764150097");
        target1.setRoleType(2);
        target1.setTargetId("1600066430058162963");
        List<UpdateCompanyTemplateReq.Target> lists = new ArrayList<>();
        lists.add(target1);
        lists.add(target);
        templateInfo.setTargets(lists);
        req.setTemplateInfo(templateInfo);

        BaseRsp<UpdateCompanyTemplateRsp> result = templateClient.updateCompanyTemplate(req);

        System.out.println(result.toString());
    }

    /**
     * 获取企业模板控件维护页面url
     */
    private void getEditCompanyTemplateUrl() throws ApiException {
        GetEditCompanyTemplateUrlReq req = new GetEditCompanyTemplateUrlReq();
        req.setToken(token);
        req.setTemplateId(templateId);
        BaseRsp<GetEditCompanyTemplateUrlRsp> result = templateClient.getEditCompanyTemplateUrl(req);
        System.out.println(result.toString());
    }


    /**
     * 删除企业模板文件附件
     */
    private void delCompanyTemplateFile() throws ApiException {
        DelCompanyTemplateFileReq req = new DelCompanyTemplateFileReq();
        req.setToken(token);
        req.setTemplateIdAndFileId("1604045248035119871", fileId);
        BaseRsp baseRsp = templateClient.delCompanyTemplateFile(req);
        System.out.println(baseRsp.toString());
    }

    /**
     * 获取模板在线预览链接
     */
    private void getCompanyTemplatePreviewUrl() throws ApiException {
        GetEditCompanyTemplateUrlReq req = new GetEditCompanyTemplateUrlReq();
        req.setToken(token);
        req.setTemplateId(templateId);
        BaseRsp<GetCompanyTemplatePreviewUrlRsp> result = templateClient.getCompanyTemplatePreviewUrl(req);
        System.out.println(result.toString());
    }

    /**
     * 企业模板列表查询
     */
    private void queryCompanyTemplateList() throws ApiException {
        QueryCompanyTemplateListReq req = new QueryCompanyTemplateListReq();
        req.setToken(token);
        QueryCompanyTemplateListReq.QueryInfo queryInfo = new QueryCompanyTemplateListReq.QueryInfo();
        queryInfo.setCurrentPageNo(1);
        queryInfo.setPageSize(10);
        req.setQueryInfo(queryInfo);
        BaseRsp<QueryCompanyTemplateListRsp> result = templateClient.queryCompanyTemplateList(req);
        System.out.println(result.toString());
    }

    /**
     * 模板文件下载
     */
    private void downloadCompanyTemplateFile() throws ApiException {
        DownloadCompanyTemplateFileReq req = new DownloadCompanyTemplateFileReq();
        req.setToken(token);
        DownloadCompanyTemplateFileReq.TemplateInfo templateInfo = new DownloadCompanyTemplateFileReq.TemplateInfo();
        templateInfo.setTemplateId(templateId);
        req.setTemplateInfo(templateInfo);
        BaseRsp<DownLoadFileRsp> result = templateClient.downloadCompanyTemplateFile(req);
        if (result.isSuccess()) {
            fileSink(result.getData().getFileBytes(), "d:\\", "模板文件.zip");
        } else {
            System.out.println(result.toString());
        }
    }

    /**
     * 获取模板详请
     *
     * @throws ApiException
     */
    public void getTemplateDetailById() throws ApiException {
        GetTemplateDetailByIdReq req = new GetTemplateDetailByIdReq();
        req.setToken(token);
        req.setTemplateId(templateId);
        BaseRsp<GetTemplateDetailByIdRsp> rsp = templateClient.getTemplateDetailById(req);
        System.out.println(rsp.toString());
    }


    /**
     * 模板填充接口
     *
     * @throws ApiException
     */
    public void createByTemplate() throws ApiException {
        CreateByTemplateReq req = new CreateByTemplateReq();
        CreateByTemplateReq.TemplateInfo templateInfo = new CreateByTemplateReq.TemplateInfo();
        templateInfo.setTemplateName("sfdsd");
        templateInfo.setTemplateRemark("sfdsdfsfdwer3w");
        req.setTemplateInfo(templateInfo);
        req.setToken(token);
//        req.setUserToken(userToken);
        req.setTemplateId(templateId);
        List<TemplateFileReq> templateFiles = new ArrayList<>();

        TemplateFileReq t1 = new TemplateFileReq();
        Map<String, String> f1 = new HashMap<>();
        f1.put("姓名", "校长");
        f1.put("name", "小辉辉");
//        f1.put("002", "platformName");
//        new Monitor()
//        f1.put("003", "platformName");
//        f1.put("004", "true");
//        f1.put("005", "platformName");
//        f1.put("009", "platformName");
//        f1.put("11", "platformName");
//        f1.put("姓名", "platformName");
        //uat
//        t1.setTemplateFileId("1585382593389145558");
        t1.setTemplateFileId("1605059321586132048");
        t1.setDocumentFileName("第1份文档");
        t1.setFormFields(f1);
        templateFiles.add(t1);

//        TemplateFileReq t2 = new TemplateFileReq();
//        Map<String, String> f2 = new HashMap<>();
//        f2.put("borrower1", "borrower1");
//        f2.put("platformName1", "platformName1");
//        //uat
//        t2.setTemplateFileId("1599805285857144305");
//        t2.setDocumentFileName("第2份文档");
//        t2.setFormFields(f2);
//        templateFiles.add(t2);

        req.setTemplateFiles(templateFiles);
        BaseRsp<DraftRsp> rsp = templateClient.createByTemplate(req);
        System.out.println(rsp.toString());
    }

    public void fileSink(byte[] fileBytes, String path, String fileName) {
        File f = new File(path + fileName);
        if (f.exists()) {
            f.delete();
        }
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        try (FileOutputStream fos = new FileOutputStream(f); BufferedOutputStream bw =
                new BufferedOutputStream(fos)) {
            bw.write(fileBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
