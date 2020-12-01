import com.fadada.api.bean.req.seal.*;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.seal.AddCompanySealRsp;
import com.fadada.api.bean.rsp.seal.CompanySealDetailRsp;
import com.fadada.api.bean.rsp.seal.CompanySealListRsp;
import com.fadada.api.client.SealClient;
import com.fadada.api.exception.ApiException;

import java.io.File;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName SealTest.java
 * @Description 签章测试
 * @Param
 * @createTime 2020年06月17日 15:36:00
 */
public class SealTest extends BaseTest {

    private final String sealId = "1585377565938165435";
    private static SealClient sealClient;

    public static void main(String[] args) throws ApiException {
        SealTest sealTest = new SealTest();
        sealTest.getToken();
        sealClient = new SealClient(client);
        sealTest.addCompanySeal();
        sealTest.delCompanySeal();
        sealTest.sealAuth();
        sealTest.cancelSealAuth();
        sealTest.companySealList();
        sealTest.companySealDetail();
    }

    /**
     * 上传企业签章
     */
    public void addCompanySeal() throws ApiException {
        AddCompanySealReq req = new AddCompanySealReq();
        req.setToken(token);
        req.setSealInfo(null, "sdk签章");
        File imageFile = new File("E:\\图片\\9.jpg");
        BaseRsp<AddCompanySealRsp> rsp = sealClient.addCompanySeal(req, imageFile);
        System.out.println(rsp);
    }

    /**
     * 删除企业签章
     */
    public void delCompanySeal() throws ApiException {
        DelCompanySealReq req = new DelCompanySealReq();
        req.setToken(token);
        req.setSealInfo(sealId);
        BaseRsp rsp = sealClient.delCompanySeal(req);
        System.out.println(rsp);
    }

    /**
     * 签章授权
     */
    public void sealAuth() throws ApiException {
        SealAuthReq req = new SealAuthReq();
        req.setToken(token);
        SealAuthReq.EmployeeInfo employeeInfo = new SealAuthReq.EmployeeInfo();
        employeeInfo.setUnionId(unionId);
        req.setEmployeeInfo(employeeInfo);
        SealAuthReq.SealInfo sealInfo = new SealAuthReq.SealInfo();
        sealInfo.setSealId(sealId);
        req.setSealInfo(sealInfo);
        BaseRsp rsp = sealClient.sealAuth(req);
        System.out.println(rsp);
    }

    /**
     * 签章取消授权
     */
    public void cancelSealAuth() throws ApiException {
        CancelSealAuthReq req = new CancelSealAuthReq();
        req.setToken(token);
        req.setEmployeeInfo(unionId);
        req.setSealInfo(sealId);
        BaseRsp rsp = sealClient.cancelSealAuth(req);
        System.out.println(rsp);
    }

    /**
     * 企业签章列表
     */
    public void companySealList() throws ApiException {
        CompanySealListReq req = new CompanySealListReq();
        req.setToken(token);
        req.setSealInfo(1);
        BaseRsp<CompanySealListRsp> rsp = sealClient.companySealList(req);
        System.out.println(rsp);
    }

    /**
     * 企业签章详请
     */
    public void companySealDetail() throws ApiException {
        CompanySealDetailReq req = new CompanySealDetailReq();
        req.setToken(token);
        CompanySealDetailReq.SealInfo sealInfo = new CompanySealDetailReq.SealInfo();
        sealInfo.setSealId(sealId);
        req.setSealInfo(sealInfo);
        BaseRsp<CompanySealDetailRsp> rsp = sealClient.companySealDetail(req);
        System.out.println(rsp);
    }
}
