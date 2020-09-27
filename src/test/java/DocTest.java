import com.fadada.api.bean.req.document.*;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.document.DownLoadFileRsp;
import com.fadada.api.bean.rsp.document.LookUpCoordinatesRsp;
import com.fadada.api.bean.rsp.document.UploadFileRsp;
import com.fadada.api.bean.rsp.document.VerifySignatureRsp;
import com.fadada.api.client.DocumentClient;
import com.fadada.api.exception.ApiException;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * @author gengxl
 * @create 2020-03-10 20:37
 */
public class DocTest extends BaseTest {

    private String tempId = "1599805284380152637";
    private String taskId = "6114f417931949f2a88971b88bf6fb7a";
    private String fileId = "1598337773971139853";
    private String draftId = "1599207723039151762";
    private String draftFileId = "1593433243523180119";

    private static DocumentClient docClient;

    public static void main(String[] args) throws ApiException {

        DocTest docTest = new DocTest();
        docTest.getToken();
        docClient = new DocumentClient(client);
//        docTest.uploadFile();
//        docTest.getByDraftFileId();
//        docTest.getBySignFileId();
//        docTest.lookUpCoordinates();
//        docTest.verifySignature();
//        docTest.contractReportDownload();
        docTest.downloadEvidenceReport();
    }


    /**
     * 上传文件
     */
    public void uploadFile() throws ApiException {

        UploadFileReq uploadFileReq = new UploadFileReq();
        uploadFileReq.setFileType(1);
        File file = new File("C:\\Users\\yangh1\\Desktop\\工作\\哈哈哈.pdf");
        BaseRsp<UploadFileRsp> rsp = docClient.uploadFile(token, uploadFileReq, file);
        fileId = rsp.getData().getFileId();
        System.out.println(rsp);
    }


    /**
     * 下载签署文件 简单单元测试
     */
    public void getBySignFileId() throws ApiException {

        GetBySignFileIdReq req = new GetBySignFileIdReq();
        req.setTaskId(taskId);
//        req.setSignFileId(fileId);
        BaseRsp<DownLoadFileRsp> rsp = docClient.getBySignFileId(token, req);
        if (rsp.isSuccess()) {
            fileSink(rsp.getData().getFileBytes(), "d:\\", "签署文件.zip");
        } else {
            System.out.println(rsp.toString());
        }
    }


    public void getByDraftFileId() throws ApiException {
        GetByDraftIdReq req = new GetByDraftIdReq();
        req.setDraftId(draftId);
        req.setDraftFileId(draftFileId);
        BaseRsp<DownLoadFileRsp> rsp = docClient.getByDraftId(token, req);
        if (rsp.isSuccess()) {
            fileSink(rsp.getData().getFileBytes(), "d:\\", "草稿文件.zip");
        } else {
            System.out.println(rsp.toString());
        }
    }

    public void lookUpCoordinates() throws ApiException {
        LookUpCoordinatesReq req = new LookUpCoordinatesReq();
        LookUpCoordinatesReq.QueryInfo queryInfo = new LookUpCoordinatesReq.QueryInfo();
        queryInfo.setFileId(fileId);
        queryInfo.setKeyword("备");
//        queryInfo.setPageNumber(0);
//        queryInfo.setKeywordStrategy(2);
        req.setQueryInfo(queryInfo);
        BaseRsp<LookUpCoordinatesRsp> result = docClient.lookUpCoordinates(token, req);
        System.out.println(result.toString());
    }

    public void verifySignature() throws ApiException {
        VerifySignatureReq req = new VerifySignatureReq();
        File file = new File("C:\\Users\\yangh1\\Desktop\\工作\\1、指定签署位置.pdf");
        BaseRsp<VerifySignatureRsp> result = docClient.verifySignature(token, req, file);
        System.out.println(result.toString());
    }

    public void contractReportDownload() throws ApiException {
        ContractReportDownloadReq req = new ContractReportDownloadReq();
        ContractReportDownloadReq.ContractInfo contractInfo = new ContractReportDownloadReq.ContractInfo();
        contractInfo.setTaskId(taskId);
        req.setContractInfo(contractInfo);
        BaseRsp<DownLoadFileRsp> result = docClient.contractReportDownload(token, req);
        if (result.isSuccess()) {
            fileSink(result.getData().getFileBytes(), "d:\\", "报告.zip");
        } else {
            System.out.println(result.toString());
        }
    }


    public void downloadEvidenceReport() throws ApiException {
        DownloadEvidenceReportReq req = new DownloadEvidenceReportReq();
        DownloadEvidenceReportReq.QueryInfo queryInfo = new DownloadEvidenceReportReq.QueryInfo();
        queryInfo.setTaskId("59729f83216844c7b5d2c064e339f479");
        queryInfo.setType(3);
//        queryInfo.setUnionId("ee4cc23a61aa4e01b456962c038518d0");
        queryInfo.setUnionId("4e35bfcf869d4769a9fb0b8a851178be");
        req.setQueryInfo(queryInfo);
        BaseRsp<DownLoadFileRsp> result = docClient.downloadEvidenceReport(token, req);
        if (result.isSuccess()) {
            byte[] fds = result.getData().getFileBytes();
//            byte[] fds = DocTest.streamToZip((byte[]) fileBytes);
            fileSink(fds, "d:\\", "企业保全报告.zip");
        } else {
            System.out.println(result.toString());
        }
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

    /**
     * byte[]压缩
     *
     * @param data
     * @return
     */
    public static byte[] streamToZip(byte[] data) {


        byte[] res = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(bos);
            gzip.write(data);
            gzip.finish();
            gzip.close();
            res = bos.toByteArray();
            bos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return res;
    }
}
