import com.fadada.api.bean.req.sign.*;
import com.fadada.api.bean.req.sign.batch.*;
import com.fadada.api.bean.req.sign.draft.CreateTaskByDraftIdReq;
import com.fadada.api.bean.req.sign.draft.DraftTaskSignerReq;
import com.fadada.api.bean.req.sign.file.*;
import com.fadada.api.bean.req.sign.template.CreateByDraftIdReq;
import com.fadada.api.bean.req.sign.template.ExternalSigner;
import com.fadada.api.bean.req.sign.template.TemplateSignerReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.sign.*;
import com.fadada.api.bean.rsp.sign.batch.BatchCreateByDraftIdRsp;
import com.fadada.api.bean.rsp.sign.batch.BatchGetSignUrlRsp;
import com.fadada.api.bean.rsp.sign.batch.BatchGetSigntasksByBatchNoRsp;
import com.fadada.api.client.SignTaskClient;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.string.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gengxl
 * @create 2020-03-10 20:37
 */
public class SignTest extends BaseTest {

    //            private static String taskId = "d98c5ba4a29d46f5892b66c9ac3edcfd";
//    private static String taskId = "47c62e4fe7cf43a3a0feca47a825730b";
    private static String taskId = "624488341fe343a29b2d791d4d5ddb0e";
    //    private static String taskId = "445be2a5f1f7420783075e75a8fcba3a";
//    private static String taskId = "077995540f2f4be5816794cd716f609c";
    //hujian
//    private static String fileId = "1603269335347199392";
    private static String fileId = "1606221464218180236";
    private static String draftId = "1606786963305135178";
    private String batchNo = "47b7d26852c6459bb5fab625c5dceea0";

    private String mobile = "13082916760";

    private static SignTaskClient signClient;

    public static void main(String[] args) throws ApiException {
        SignTest signTest = new SignTest();
        signTest.getToken();
        signClient = new SignTaskClient(client);
//        signTest.createByTemplate();
        signTest.createTaskByFile();
//        signTest.getSignPreviewUrl();
//        signTest.cancelSignTask();
//        signTest.createSignTaskByFileId();
//        signTest.getSentUrl();
//        signTest.urgeSign();
//        signTest.getTaskDetailByTaskId();
//        signTest.createTaskByFile();
        signTest.getSignUrl();

        signTest.createSignTaskByDraftId();

        // 批量签署方法
//        signTest.batchCreateByDraftId();
//        signTest.batchAddByDraftId();
//        signTest.batchSent();
//        signTest.batchGetSigntasksByBatchNo();
//        signTest.batchGetSignUrl();
    }


    public void getTaskDetailByTaskId() throws ApiException {
        GetTaskDetailReq req = new GetTaskDetailReq();
        req.setToken(token);
        req.setTaskId(taskId);
        req.setUnionId(unionId);
        BaseRsp<GetTaskDetailsRes> rsp = signClient.getTaskDetailByTaskId(req);
        System.out.println(rsp.toString());
    }

    public void createSignTaskByFileId()
            throws ApiException {

        List<SignerReq> signerReqs = new ArrayList();
        SignerReq signerReq = new SignerReq();
        signerReq.setAuthorizedUnionId(null);
        signerReq.setUnionId(unionId);
        signerReq.setSignOrder(203);
        signerReq.setSignIntendWay(1);


        List<FileSignReq> fileSignReqs = new ArrayList();
        List<SignHereReq> signHereReqs = new ArrayList();
        SignHereReq signHereReq = new SignHereReq();
        signHereReq.setPageNumber(0);
        signHereReq.setXCoordinate(118.94499969482422);
        signHereReq.setYCoordinate(716.2100219726562);
        signHereReqs.add(signHereReq);


        FileSignReq fileSignReq = new FileSignReq();
        fileSignReq.setFileId(fileId);
        fileSignReq.setSignHeres(signHereReqs);
        fileSignReqs.add(fileSignReq);

        signerReq.setFileSigns(fileSignReqs);
        signerReqs.add(signerReq);

        SignerReq signerReq1 = new SignerReq();
        signerReq1.setSignOrder(999);
//        signerReq1.setAuthorizedUnionId(unionId);
        signerReq1.setUnionId(unionId);
//        ExternalSigner externalSigner = new ExternalSigner();
//        externalSigner.setMobile("15527435516");
//        externalSigner.setPersonName("杨晓辉");
        List<FileSignReq> fileSignReqs1 = new ArrayList();
        List<SignHereReq> signHereReqs1 = new ArrayList();
        SignHereReq signHereReq1 = new SignHereReq();
        signHereReq1.setPageNumber(0);
        signHereReq1.setXCoordinate(80.25);
        signHereReq1.setYCoordinate(230.52);
        signerReq1.setSignIntendWay(1);
        signHereReqs1.add(signHereReq1);


        FileSignReq fileSignReq1 = new FileSignReq();
        fileSignReq1.setFileId(fileId);
        fileSignReq1.setSignHeres(signHereReqs1);
        fileSignReqs1.add(fileSignReq1);

        signerReq1.setFileSigns(fileSignReqs1);
//        signerReq1.setExternalSigner(externalSigner);
        signerReqs.add(signerReq1);


        SignerReq signerReq2 = new SignerReq();
        signerReq2.setSignOrder(888);
        signerReq2.setAuthorizedUnionId(unionId);
        signerReq2.setSignIntendWay(2);
        ExternalSigner externalSigner2 = new ExternalSigner();
        externalSigner2.setMobile("15527435518");
        externalSigner2.setPersonName("刘子昊");
        externalSigner2.setCompanyName("刘子昊产品集团");
        List<FileSignReq> fileSignReqs2 = new ArrayList();
        List<SignHereReq> signHereReqs2 = new ArrayList();
        SignHereReq signHereReq2 = new SignHereReq();
        signHereReq2.setPageNumber(0);
        signHereReq2.setXCoordinate(800.25);
        signHereReq2.setYCoordinate(630.52);
        signHereReqs2.add(signHereReq2);


        FileSignReq fileSignReq2 = new FileSignReq();
        fileSignReq2.setFileId(fileId);
        fileSignReq2.setSignHeres(signHereReqs2);
        fileSignReqs2.add(fileSignReq2);

        signerReq2.setFileSigns(fileSignReqs2);
        signerReq2.setExternalSigner(externalSigner2);
//        signerReqs.add(signerReq2);

        List<FileReq> fileReqs = new ArrayList();
        FileReq fileReq = new FileReq();
        fileReq.setFileId(fileId);
        fileReqs.add(fileReq);


        FileSignTaskReq req = new FileSignTaskReq();
        req.setAutoArchive(2);
        req.setSender(null);

        req.setSort(1);
        req.setStatus("sent");
        req.setTaskSubject("ISSP请求");
        req.setAutoArchive(1);

        req.setSigners(signerReqs);
        req.setFiles(fileReqs);


        req.setToken(token);
        BaseRsp<FileSignTaskRsp> rsp = signClient.createSignTaskByFileId(req);
        System.out.println(rsp.toString());
    }

    public SignerReqV2 getSignerReq(String personUnionId, String companyUnionId,
                                    Integer signWay, Integer signIntendWay,
                                    String personSealId, String companySealId) {

        SignerReqV2 signerReq1 = new SignerReqV2();
        if (StringUtil.isNotBlank(personUnionId)) {
            SignatoryReq signatory = new SignatoryReq();
            signatory.setSignerId(personUnionId);
            if (StringUtil.isNotBlank(personSealId)) {
                SealReq sealReq = new SealReq();
                sealReq.setSealId(personSealId);
                signatory.setSeal(sealReq);
            }
            signerReq1.setSignatory(signatory);
        }
        if (StringUtil.isNotBlank(companyUnionId)) {
            CorpReq corp = new CorpReq();
            corp.setCorpId(companyUnionId);
            if (StringUtil.isNotBlank(companySealId)) {
                SealReq sealReq = new SealReq();
                sealReq.setSealId(companySealId);
                corp.setSeal(sealReq);
            }
            signerReq1.setCorp(corp);
        }
        if (signWay != null || signIntendWay != null) {
            SignActionReq signAction = new SignActionReq();
            signAction.setSignIntendWay(signIntendWay);
            signAction.setSignWay(signWay);
            signerReq1.setSignAction(signAction);
        }

        return signerReq1;
    }

    private List<CreateTaskByFileReq.SignRegionInfo> getSignRegion(int p, double x, double y, String fileId) {
        List<CreateTaskByFileReq.SignRegionInfo> signRegionsReq = new ArrayList<>();
        CreateTaskByFileReq.SignRegionInfo signRegionReq = new CreateTaskByFileReq.SignRegionInfo();
        List<SignHereReq> signHereReqs = new ArrayList<>();
        SignHereReq signHereReq = new SignHereReq();
        signHereReq.setPageNumber(p);
        signHereReq.setXCoordinate(x);
        signHereReq.setYCoordinate(y);
        signHereReqs.add(signHereReq);
        signRegionReq.setSignHeres(signHereReqs);
        signRegionReq.setFileId(fileId);
        signRegionsReq.add(signRegionReq);
        return signRegionsReq;
    }

    /**
     * 根据草稿id创建签署任务
     *
     * @throws ApiException
     */
    public void createSignTaskByDraftId()
            throws ApiException {
        CreateTaskByDraftIdReq req = new CreateTaskByDraftIdReq();
        req.setToken(token);
        req.setDraftId(draftId);
        req.setSort(2);
        req.setTaskSubject("多文件测试");
        req.setAutoArchive(1);
        req.setStatus("sent");

        CreateTaskByDraftIdReq.CreateTaskSignerInfo createTaskSignerInfo =
                new CreateTaskByDraftIdReq.CreateTaskSignerInfo();
        createTaskSignerInfo.setTemplateRoleName("HY");
        ExternalSignerReq externalSignerReq = new ExternalSignerReq();
        externalSignerReq.setMobile("15527435516");
        externalSignerReq.setPersonName("测试");
        createTaskSignerInfo.setExternalSigner(externalSignerReq);
        CreateTaskByDraftIdReq.SignerInfo signerInfo = new CreateTaskByDraftIdReq.SignerInfo();
        CreateTaskByDraftIdReq.SignatoryInfo signatoryInfo = new CreateTaskByDraftIdReq.SignatoryInfo();
        signatoryInfo.setSignerId(unionId);
        signerInfo.setSignatory(signatoryInfo);
        createTaskSignerInfo.setSigner(signerInfo);
        List<CreateTaskByDraftIdReq.CreateTaskSignerInfo> infos = new ArrayList<>();
        infos.add(createTaskSignerInfo);
        req.setSigners(infos);
        BaseRsp<CreateTaskByDraftIdRsp> rsp = signClient.createTaskByDraftId(req);
        System.out.println(rsp.toString());
    }


    public void createTaskByFileTest() throws ApiException {
        CreateTaskByFileReq req = new CreateTaskByFileReq();
        req.setToken(token);
        req.setTaskSubject("房屋租赁");
        req.setSort(2);
        req.setStatus("sent");

        CreateTaskByFileReq.SignerInfo signerInfo1 = new CreateTaskByFileReq.SignerInfo();
        //应用内部签署方对象1  个人手动签署, 设置签署文件对应签署坐标
        signerInfo1.setSigner(getSignerReq("ea2b5853b65541edb41c4af92a9b76ed",
                null, 0, null, null, null));

        signerInfo1.setSignRegions(getSignRegion(0, 600D, 600D,
                "1606380052088127729"));


        CreateTaskByFileReq.SignerInfo signerInfo2 = new CreateTaskByFileReq.SignerInfo();
        //应用内部企业自动签署的场景， companyUnionId必须是平台方企业，或者，作过授权自动签署给平台方的企业
        signerInfo2.setSigner(getSignerReq(null,
                "70062afe0c1c4142ad6b9b3d29e54d58", 1, null, null, null));
        signerInfo2.setSignRegions(getSignRegion(0, 300D, 300D,
                "1606380052088127729"));

        CreateTaskByFileReq.SignerInfo signerInfo3 = new CreateTaskByFileReq.SignerInfo();
        //应用内部企业手动签署的场景
        signerInfo3.setSigner(getSignerReq(null,
                "70062afe0c1c4142ad6b9b3d29e54d58", 1, null, null, null));
        signerInfo3.setSignRegions(getSignRegion(0, 900D, 900D,
                "1606380052088127729"));


        //签署列表
        List<CreateTaskByFileReq.SignerInfo> signers = new ArrayList<>();
        signers.add(signerInfo1);
        signers.add(signerInfo2);
        signers.add(signerInfo3);
        req.setSigners(signers);

        //所有的签署文件集合
        List<FileReq> fileReqs = new ArrayList<>();
        FileReq fileReq = new FileReq();
        fileReq.setFileId("1606380052088127729");
        fileReqs.add(fileReq);
        req.setFiles(fileReqs);

        BaseRsp<CreateTaskByFileRsp> rsp = signClient.createTaskByFile(req);
        System.out.println(rsp);

    }

    /**
     * 签署链接
     *
     * @throws ApiException
     */
    public void getSignUrl() throws ApiException {
        GetSignUrlReq req = new GetSignUrlReq();
        req.setToken(token);
        req.setUnionId(unionId);
        req.setMiniProgramSign(0);
        req.setRedirectUrl("http://www.fadada.com");
        req.setTaskId(taskId);
        BaseRsp<GetSignUrlRsp> rsp = signClient.getSignUrl(req);
        System.out.println(rsp);
    }

    /**
     * 预览链接
     *
     * @throws ApiException
     */
    public void getSignPreviewUrl() throws ApiException {
        GetSignPreviewUrlReq req = new GetSignPreviewUrlReq();
        req.setToken(token);
        req.setTaskId(taskId);
        BaseRsp<GetSignPreviewUrlRsp> rsp = signClient.getSignPreviewUrl(req);
        System.out.println(rsp);
    }


    /**
     * 基于模板创建签署任务
     */
    public void createByTemplate() throws ApiException {
        CreateByDraftIdReq req = new CreateByDraftIdReq();
        req.setToken(token);
        req.setTaskSubject("测试主题");
        req.setSort(1);
        req.setStatus("sent");
        req.setDraftId(draftId);
        List<TemplateSignerReq> signers = new ArrayList<>();
        TemplateSignerReq signerReq1 = new TemplateSignerReq();
        signerReq1.setUnionId(unionId);
        signerReq1.setTemplateRoleName("YH");
        signerReq1.setSignOrder(112);
        NoticeReq noticeReq1 = new NoticeReq();
        noticeReq1.setNotifyWay(1);
        noticeReq1.setNotifyAddress(mobile);
        signerReq1.setNotice(noticeReq1);
        signers.add(signerReq1);
        req.setSigners(signers);

        BaseRsp<TemplateSignTaskRsp> rsp = signClient.createSignTaskByDraftId(req);
        System.out.println(rsp);
    }

    /**
     * 撤销签署任务
     */
    public void cancelSignTask() throws ApiException {
        CancelSignTaskReq req = new CancelSignTaskReq();
        req.setToken(token);
        req.setRemark("SDK测试撤销");
        req.setTaskId(taskId);
        BaseRsp rsp = signClient.cancelSignTask(req);
        System.out.println(rsp);

    }

    /**
     * 获取签署任务发起链接
     */
    public void getSentUrl() throws ApiException {
        GetSentUrlReq req = new GetSentUrlReq();
        req.setToken(token);
        req.setTaskId(taskId);
        BaseRsp<GetSentUrlRsp> rsp = signClient.getSentUrl(req);
        System.out.println(rsp);
    }

    /**
     * 催签
     *
     * @throws ApiException
     */
    public void urgeSign() throws ApiException {
        UrgeSignReq req = new UrgeSignReq();
        req.setToken(token);
        req.setTaskId(taskId);
        BaseRsp rsp = signClient.urgeSign(req);
        System.out.println(rsp);
    }

    /**
     * 创建批次号批量任务
     *
     * @throws ApiException
     */
    public void batchCreateByDraftId() throws ApiException {
        BatchCreateByDraftIdReq req = new BatchCreateByDraftIdReq();
        req.setToken(token);
        BatchCreateByDraftIdReq.SenderInfo sender = new BatchCreateByDraftIdReq.SenderInfo();
        sender.setSignIntendWay(2);
        sender.setUnionId(unionId);
        req.setSender(sender);
        List<BatchDraftIdSigntaskInfoReq> lists = new ArrayList<>();
        BatchDraftIdSigntaskInfoReq ba1 = new BatchDraftIdSigntaskInfoReq();
        ba1.setDraftId("1599531898421124534");
        TemplateSenderReq senderReq = new TemplateSenderReq();
        senderReq.setSignWay(1);
        senderReq.setSealId("1585377565938165435");
        senderReq.setTemplateRoleName("发起方");
        ba1.setSender(senderReq);
        BatchTemplateSignerReq batchTemplateSignerReq = new BatchTemplateSignerReq();
        ExternalSigner ext = new ExternalSigner();
        ext.setMobile("15527435516");
        ext.setPersonName("小辉");
        batchTemplateSignerReq.setExternalSigner(ext);
        batchTemplateSignerReq.setSignOrder(200);
        batchTemplateSignerReq.setTemplateRoleName("DBA");
        List<BatchTemplateSignerReq> signers = new ArrayList<>();
        signers.add(batchTemplateSignerReq);

        ba1.setSigners(signers);
        ba1.setSort(1);
        ba1.setTaskSubject("javaSDK测试");
        lists.add(ba1);
        req.setSigntasks(lists);
        BaseRsp<BatchCreateByDraftIdRsp> rsp = signClient.batchCreateByDraftId(req);
        System.out.println(rsp);
    }

    /**
     * 创建批次号批量任务
     *
     * @throws ApiException
     */
    public void createTaskByFile() throws ApiException {
        CreateTaskByFileReq req = new CreateTaskByFileReq();
        req.setToken(token);
        req.setTaskSubject("不服来干");
        req.setSort(1);
        req.setStatus("sent");


        CreateTaskByFileReq.TaskSenderInfo sender = new CreateTaskByFileReq.TaskSenderInfo();
        sender.setUnionId("70062afe0c1c4142ad6b9b3d29e54d58");
        req.setSender(sender);

        CreateTaskByFileReq.SignerInfo signerInfo = new CreateTaskByFileReq.SignerInfo();
        ExternalSignerReq externalSignerReq = new ExternalSignerReq();
        externalSignerReq.setMobile("15527435516");
        externalSignerReq.setPersonName("小辉");
        signerInfo.setExternalSigner(externalSignerReq);

        List<CreateTaskByFileReq.SignRegionInfo> signRegions = new ArrayList<>();
        CreateTaskByFileReq.SignRegionInfo signRegionInfo = new CreateTaskByFileReq.SignRegionInfo();
        signRegionInfo.setFileId(fileId);

        List<SignHereReq> signHeres = new ArrayList<>();
        SignHereReq signHereReq = new SignHereReq();
        signHereReq.setPageNumber(0);
        signHereReq.setXCoordinate(234.8);
        signHereReq.setYCoordinate(786.2);
        signHeres.add(signHereReq);
        signRegionInfo.setSignHeres(signHeres);
        signRegions.add(signRegionInfo);

        signerInfo.setSignRegions(signRegions);

        List<CreateTaskByFileReq.SignerInfo> signers = new ArrayList<>();
        signers.add(signerInfo);
        req.setSigners(signers);

        List<FileReq> fileReqs = new ArrayList<>();
        FileReq fileReq = new FileReq();
        fileReq.setFileId(fileId);
        fileReqs.add(fileReq);
        req.setFiles(fileReqs);

        BaseRsp<CreateTaskByFileRsp> rsp = signClient.createTaskByFile(req);
        System.out.println(rsp);
    }


    /**
     * 批次号批量任务新增
     *
     * @throws ApiException
     */
    public void batchAddByDraftId() throws ApiException {
        BatchAddByDraftIdReq req = new BatchAddByDraftIdReq();
        req.setToken(token);
        req.setBatchNo("237b9cf8b3f847fdbc487c2a224793a4");
        List<BatchDraftIdSigntaskInfoReq> lists = new ArrayList<>();
        BatchDraftIdSigntaskInfoReq ba1 = new BatchDraftIdSigntaskInfoReq();
        ba1.setDraftId("1599534581791193631");
        TemplateSenderReq senderReq = new TemplateSenderReq();
        senderReq.setSignWay(1);
        senderReq.setSealId("1585377565938165435");
        senderReq.setTemplateRoleName("发起方");
        senderReq.setSignOrder(52);
        ba1.setSender(senderReq);
        BatchTemplateSignerReq batchTemplateSignerReq = new BatchTemplateSignerReq();
        ExternalSigner ext = new ExternalSigner();
        ext.setMobile("15527435516");
        ext.setPersonName("小辉");
        batchTemplateSignerReq.setExternalSigner(ext);
        batchTemplateSignerReq.setSignOrder(200);
        batchTemplateSignerReq.setTemplateRoleName("DBA");
        List<BatchTemplateSignerReq> signers = new ArrayList<>();
        signers.add(batchTemplateSignerReq);

        ba1.setSigners(signers);
        ba1.setSort(1);
        ba1.setTaskSubject("javaSDK测试新增");


        lists.add(ba1);
        lists.add(ba1);
        lists.add(ba1);
        req.setSigntasks(lists);
        BaseRsp<BatchCreateByDraftIdRsp> rsp = signClient.batchAddByDraftId(req);
        System.out.println(rsp);
    }

    /**
     * 批次号下签署任务发起
     *
     * @throws ApiException
     */
    public void batchSent() throws ApiException {
        BatchSentReq req = new BatchSentReq();
        req.setToken(token);
        req.setBatchNo(batchNo);
        BaseRsp<BatchCreateByDraftIdRsp> rsp = signClient.batchSent(req);
        System.out.println(rsp);
    }

    /**
     * 批次号获取签署链接
     *
     * @throws ApiException
     */
    public void batchGetSignUrl() throws ApiException {
        BatchGetSignUrlReq req = new BatchGetSignUrlReq();
        req.setToken(token);
        req.setBatchNo(batchNo);
        BaseRsp<BatchGetSignUrlRsp> rsp = signClient.batchGetSignUrl(req);
        System.out.println(rsp);
    }

    /**
     * 根据批次号获取签署任务
     *
     * @throws ApiException
     */
    public void batchGetSigntasksByBatchNo() throws ApiException {
        BatchGetSigntasksByBatchNoReq req = new BatchGetSigntasksByBatchNoReq();
        req.setToken(token);
        req.setBatchNo(batchNo);
        BaseRsp<BatchGetSigntasksByBatchNoRsp> rsp = signClient.batchGetSigntasksByBatchNo(req);
        System.out.println(rsp);
    }


}
