import com.fadada.api.bean.req.issp.DownloadFileReq;
import com.fadada.api.bean.req.issp.UploadFileReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.document.DownLoadFileRsp;
import com.fadada.api.bean.rsp.issp.UploadFileRsp;
import com.fadada.api.client.IsspLocalClient;
import com.fadada.api.exception.ApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yh128
 * @className `IsspApiTest`
 * @description ISSP api client测试
 * @createTime 2020年11月7日 09:49:17
 */
public class IsspLocalTest extends BaseTest {

    private String fileUuid = "a6a173c2889943faaffae8069323a545";
    private String fileName = "辉辉ISSP文件.pdf";
    private String taskId = "e8df29718c3c45cd9d1bf335e7cf8c5e";

    private static IsspLocalClient isspLocalClient;

    public static void main(String[] args) throws ApiException {
        isspLocalClient = new IsspLocalClient("http://127.0.0.1:8888/");
        IsspLocalTest isspLocalTest = new IsspLocalTest();
//        isspLocalTest.uploadFile();
        isspLocalTest.downloadFile();
    }


    /**
     * 文件上传
     */
    public void uploadFile() throws ApiException {
        UploadFileReq uploadFileReq = new UploadFileReq();
        uploadFileReq.setFileType(1);
        File file = new File("C:\\Users\\yangh1\\Desktop\\工作\\test.pdf");
        BaseRsp<UploadFileRsp> rsp = isspLocalClient.uploadFile(file, uploadFileReq);
        System.out.println(rsp);
    }

    /**
     * 文件下载
     */
    public void downloadFile() throws ApiException {
        DownloadFileReq downloadFileReq = new DownloadFileReq();
        DownloadFileReq.FileInfo fileInfo = new DownloadFileReq.FileInfo();
        fileInfo.setFileName(fileName);
        fileInfo.setFileType(2);
        fileInfo.setFileUuid(fileUuid);
        List<DownloadFileReq.FileInfo> list = new ArrayList<>();
        list.add(fileInfo);
        downloadFileReq.setFileInfos(list);
        BaseRsp<DownLoadFileRsp> rsp = isspLocalClient.downloadFile(downloadFileReq);
        if (rsp.isSuccess()) {
            fileSink(rsp.getData().getFileBytes(), "d:\\", "ISSP文件.zip");
        } else {
            System.out.println(rsp.toString());
        }
    }


}
