import com.fadada.api.bean.req.issp.SyncContractFileInfoReq;
import com.fadada.api.bean.req.issp.SyncTemplateFileInfoReq;
import com.fadada.api.bean.req.issp.WitnessReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.issp.SyncContractFileInfoRsp;
import com.fadada.api.bean.rsp.issp.SyncTemplateFileInfoRsp;
import com.fadada.api.client.IsspApiClient;
import com.fadada.api.exception.ApiException;

/**
 * @author yh128
 * @className `IsspApiTest`
 * @description ISSP api client测试
 * @createTime 2020年11月7日 09:49:17
 */
public class IsspApiTest extends BaseTest {

    private String templateId = "null";
    private String fileUuid = "bb668abd8d074b9fa1e0e3c9c880ea98";
    private String fileName = "辉辉ISSP文件.pdf";
    private String taskId = "e8df29718c3c45cd9d1bf335e7cf8c5e";

    private static IsspApiClient isspApiClient;

    public static void main(String[] args) throws ApiException {

        IsspApiTest isspApiTest = new IsspApiTest();
        isspApiTest.getToken();
        isspApiClient = new IsspApiClient(client);
//        isspApiTest.syncContractFileInfo();
        isspApiTest.syncTemplateFileInfo();
//        isspApiTest.witness();

    }


    /**
     * 同步模板文件数据信息
     */
    public void syncTemplateFileInfo() throws ApiException {
        SyncTemplateFileInfoReq req = new SyncTemplateFileInfoReq();
        req.setToken(token);
        req.setFileName(fileName);
        req.setFileType(2);
        req.setFileUuid(fileUuid);
        req.setTemplateId(templateId);
        req.setDeleteStatus(2);
        BaseRsp<SyncTemplateFileInfoRsp> rsp = isspApiClient.syncTemplateFileInfo(req);
        System.out.println(rsp);
    }

    /**
     * 同步合同文件数据信息
     */
    public void syncContractFileInfo() throws ApiException {
        SyncContractFileInfoReq req = new SyncContractFileInfoReq();
        req.setToken(token);
        req.setFileName(fileName);
        req.setFileType(1);
        req.setFileUuid(fileUuid);
        req.setDeleteStatus(2);
        BaseRsp<SyncContractFileInfoRsp> rsp = isspApiClient.syncContractFileInfo(req);
        System.out.println(rsp);
    }


    /**
     * 合同文件归档
     */
    public void witness() throws ApiException {
        WitnessReq req = new WitnessReq();
        req.setToken(token);
        req.setTaskId(taskId);
        BaseRsp rsp = isspApiClient.witness(req);
        System.out.println(rsp);
    }


}
