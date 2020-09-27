import com.fadada.api.bean.req.sign.*;
import com.fadada.api.bean.req.sign.batch.*;
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

import java.util.ArrayList;
import java.util.List;

/**
 * @author gengxl
 * @create 2020-03-10 20:37
 */
public class SignTest extends BaseTest {

    //            private static String taskId = "d98c5ba4a29d46f5892b66c9ac3edcfd";
//    private static String taskId = "47c62e4fe7cf43a3a0feca47a825730b";
    private static String taskId = "e4806954aabf4f0faf32660d04dfe2b3";
    //    private static String taskId = "445be2a5f1f7420783075e75a8fcba3a";
//    private static String taskId = "077995540f2f4be5816794cd716f609c";
    //hujian
    private static String fileId = "1599557047441167526";
    private static String draftId = "1597212486462113570";
    private String batchNo = "237b9cf8b3f847fdbc487c2a224793a4";

    private String mobile = "13082916760";

    private static SignTaskClient signClient;

    public static void main(String[] args) throws ApiException {
        SignTest signTest = new SignTest();
        signTest.getToken();
        signClient = new SignTaskClient(client);
//        signTest.createByTemplate();
//        signTest.getSignUrl();
//        signTest.getSignPreviewUrl();
//        signTest.cancelSignTask();
//        signTest.createSignTaskByFileId();
//        signTest.getSentUrl();
//        signTest.urgeSign();
        signTest.getTaskDetailByTaskId();

        // 批量签署方法
        signTest.batchCreateByDraftId();
//        signTest.batchAddByDraftId();
//        signTest.batchSent();
//        signTest.batchGetSigntasksByBatchNo();
//        signTest.batchGetSignUrl();
    }


    public void getTaskDetailByTaskId() throws ApiException {
        GetTaskDetailReq req = new GetTaskDetailReq();
        req.setTaskId("74196d4107dc486796bccf385cf8d65c");
        req.setUnionId("660ff073ad3a487ea2a4c1d47c9b1cce");
        BaseRsp<GetTaskDetailsRes> rsp = signClient.getTaskDetailByTaskId(token, req);
        System.out.println(rsp.toString());
    }

    public void createSignTaskByFileId()
            throws ApiException {

        List<SignerReq> signerReqs = new ArrayList();
        SignerReq signerReq = new SignerReq();
        signerReq.setAuthorizedUnionId(null);
        signerReq.setUnionId(unionId);
        signerReq.setSignOrder(203);
        signerReq.setSignIntendWay(2);


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
        signerReq1.setAuthorizedUnionId(unionId);
        ExternalSigner externalSigner = new ExternalSigner();
        externalSigner.setMobile("15527435516");
        externalSigner.setPersonName("杨晓辉");
        List<FileSignReq> fileSignReqs1 = new ArrayList();
        List<SignHereReq> signHereReqs1 = new ArrayList();
        SignHereReq signHereReq1 = new SignHereReq();
        signHereReq1.setPageNumber(0);
        signHereReq1.setXCoordinate(80.25);
        signHereReq1.setYCoordinate(230.52);
        signerReq1.setSignIntendWay(2);
        signHereReqs1.add(signHereReq1);


        FileSignReq fileSignReq1 = new FileSignReq();
        fileSignReq1.setFileId(fileId);
        fileSignReq1.setSignHeres(signHereReqs1);
        fileSignReqs1.add(fileSignReq1);

        signerReq1.setFileSigns(fileSignReqs1);
        signerReq1.setExternalSigner(externalSigner);
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
        signerReqs.add(signerReq2);

        List<FileReq> fileReqs = new ArrayList();
        FileReq fileReq = new FileReq();
        fileReq.setFileId(fileId);
        fileReqs.add(fileReq);


        FileSignTaskReq signTaskReq = new FileSignTaskReq();
        signTaskReq.setAutoArchive(2);
        signTaskReq.setSender(null);

        signTaskReq.setSort(1);
        signTaskReq.setStatus("sent");
        signTaskReq.setTaskSubject("合同测试主题");
        signTaskReq.setAutoArchive(0);

        signTaskReq.setSigners(signerReqs);
        signTaskReq.setFiles(fileReqs);


        BaseRsp<FileSignTaskRsp> rsp = signClient.createSignTaskByFileId(token, signTaskReq);
        System.out.println(rsp.toString());
    }

    /**
     * 签署链接
     *
     * @throws ApiException
     */
    public void getSignUrl() throws ApiException {
        GetSignUrlReq req = new GetSignUrlReq();
        req.setUnionId(unionId);
        req.setMiniProgramSign(0);
        req.setRedirectUrl("http://www.fadada.com");
        req.setTaskId(taskId);
        BaseRsp<GetSignUrlRsp> rsp = signClient.getSignUrl(token, req);
        System.out.println(rsp);
    }

    /**
     * 预览链接
     *
     * @throws ApiException
     */
    public void getSignPreviewUrl() throws ApiException {
        GetSignPreviewUrlReq req = new GetSignPreviewUrlReq();
        req.setTaskId(taskId);
        BaseRsp<GetSignPreviewUrlRsp> rsp = signClient.getSignPreviewUrl(token, req);
        System.out.println(rsp);
    }


    /**
     * 基于模板创建签署任务
     */
    public void createByTemplate() throws ApiException {
        CreateByDraftIdReq templateSignTaskReq = new CreateByDraftIdReq();
        templateSignTaskReq.setTaskSubject("测试主题");
        templateSignTaskReq.setSort(1);
        templateSignTaskReq.setStatus("sent");
        templateSignTaskReq.setDraftId(draftId);
        List<TemplateSignerReq> signers = new ArrayList<>();
        TemplateSignerReq signerReq1 = new TemplateSignerReq();
        signerReq1.setUnionId(unionId);
        signerReq1.setTemplateRoleName("DBA");
        signerReq1.setSignOrder(112);
        NoticeReq noticeReq1 = new NoticeReq();
        noticeReq1.setNotifyWay(1);
        noticeReq1.setNotifyAddress(mobile);
        signerReq1.setNotice(noticeReq1);
        signers.add(signerReq1);
        templateSignTaskReq.setSigners(signers);

        BaseRsp<TemplateSignTaskRsp> rsp = signClient.createSignTaskByDraftId(token, templateSignTaskReq);
        System.out.println(rsp);
    }

    /**
     * 撤销签署任务
     */
    public void cancelSignTask() throws ApiException {
        CancelSignTaskReq cancelSignTaskReq = new CancelSignTaskReq();
        cancelSignTaskReq.setRemark("SDK测试撤销");
        cancelSignTaskReq.setTaskId(taskId);
        BaseRsp rsp = signClient.cancelSignTask(token, cancelSignTaskReq);
        System.out.println(rsp);

    }

    /**
     * 获取签署任务发起链接
     */
    public void getSentUrl() throws ApiException {
        GetSentUrlReq getSentUrlReq = new GetSentUrlReq();
        getSentUrlReq.setTaskId(taskId);
        BaseRsp<GetSentUrlRsp> rsp = signClient.getSentUrl(token, getSentUrlReq);
        System.out.println(rsp);
    }

    /**
     * 催签
     *
     * @throws ApiException
     */
    public void urgeSign() throws ApiException {
        UrgeSignReq urgeSignReq = new UrgeSignReq();
        urgeSignReq.setTaskId(taskId);
        BaseRsp rsp = signClient.urgeSign(token, urgeSignReq);
        System.out.println(rsp);
    }

    /**
     * 创建批次号批量任务
     *
     * @throws ApiException
     */
    public void batchCreateByDraftId() throws ApiException {
        BatchCreateByDraftIdReq req = new BatchCreateByDraftIdReq();
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
        BaseRsp<BatchCreateByDraftIdRsp> rsp = signClient.batchCreateByDraftId(token, req);
        System.out.println(rsp);
    }


    /**
     * 批次号批量任务新增
     *
     * @throws ApiException
     */
    public void batchAddByDraftId() throws ApiException {
        BatchAddByDraftIdReq req = new BatchAddByDraftIdReq();
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
        BaseRsp<BatchCreateByDraftIdRsp> rsp = signClient.batchAddByDraftId(token, req);
        System.out.println(rsp);
    }

    /**
     * 批次号下签署任务发起
     *
     * @throws ApiException
     */
    public void batchSent() throws ApiException {
        BatchSentReq req = new BatchSentReq();
        req.setBatchNo(batchNo);
        BaseRsp<BatchCreateByDraftIdRsp> rsp = signClient.batchSent(token, req);
        System.out.println(rsp);
    }

    /**
     * 批次号获取签署链接
     *
     * @throws ApiException
     */
    public void batchGetSignUrl() throws ApiException {
        BatchGetSignUrlReq req = new BatchGetSignUrlReq();
        req.setBatchNo(batchNo);
        BaseRsp<BatchGetSignUrlRsp> rsp = signClient.batchGetSignUrl(token, req);
        System.out.println(rsp);
    }

    /**
     * 根据批次号获取签署任务
     *
     * @throws ApiException
     */
    public void batchGetSigntasksByBatchNo() throws ApiException {
        BatchGetSigntasksByBatchNoReq req = new BatchGetSigntasksByBatchNoReq();
        req.setBatchNo(batchNo);
        BaseRsp<BatchGetSigntasksByBatchNoRsp> rsp = signClient.batchGetSigntasksByBatchNo(token, req);
        System.out.println(rsp);
    }


}
