import com.fadada.api.bean.req.seal.*;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.seal.AddCompanySealRsp;
import com.fadada.api.bean.rsp.seal.CompanySealDetailRsp;
import com.fadada.api.bean.rsp.seal.CompanySealListRsp;
import com.fadada.api.client.SealClient;
import com.fadada.api.exception.ApiException;

import java.io.File;

/**
 * @author yanghui
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
//        sealTest.addCompanySeal();
//        sealTest.delCompanySeal();
//        sealTest.sealAuth();
//        sealTest.cancelSealAuth();
//        sealTest.companySealList();
        sealTest.companySealDetail();
    }

    /**
     * 上传企业签章
     */
    public void addCompanySeal() throws ApiException {
        AddCompanySealReq addCompanySealReq = new AddCompanySealReq();
        addCompanySealReq.setSealInfo(null, "sdk签章");
        File imageFile = new File("E:\\图片\\9.jpg");
        BaseRsp<AddCompanySealRsp> rsp = sealClient.addCompanySeal(token, addCompanySealReq, imageFile);
        System.out.println(rsp);
    }

    /**
     * 删除企业签章
     */
    public void delCompanySeal() throws ApiException {
        DelCompanySealReq delCompanySealReq = new DelCompanySealReq();
        delCompanySealReq.setSealInfo(sealId);
        BaseRsp rsp = sealClient.delCompanySeal(token, delCompanySealReq);
        System.out.println(rsp);
    }

    /**
     * 签章授权
     */
    public void sealAuth() throws ApiException {
        SealAuthReq sealAuthReq = new SealAuthReq();
        sealAuthReq.setEmployeeInfo(unionId);
        sealAuthReq.setSealInfo(sealId);
        BaseRsp rsp = sealClient.sealAuth(token, sealAuthReq);
        System.out.println(rsp);
    }

    /**
     * 签章取消授权
     */
    public void cancelSealAuth() throws ApiException {
        CancelSealAuthReq cancelSealAuthReq = new CancelSealAuthReq();
        cancelSealAuthReq.setEmployeeInfo(unionId);
        cancelSealAuthReq.setSealInfo(sealId);
        BaseRsp rsp = sealClient.cancelSealAuth(token, cancelSealAuthReq);
        System.out.println(rsp);
    }

    /**
     * 企业签章列表
     */
    public void companySealList() throws ApiException {
        CompanySealListReq companySealListReq = new CompanySealListReq();
        companySealListReq.setSealInfo(1);
        BaseRsp<CompanySealListRsp> rsp = sealClient.companySealList(token, companySealListReq);
        System.out.println(rsp);
    }

    /**
     * 企业签章详请
     */
    public void companySealDetail() throws ApiException {
        CompanySealDetailReq companySealDetailReq = new CompanySealDetailReq();
        companySealDetailReq.setSealInfo(sealId);
        BaseRsp<CompanySealDetailRsp> rsp = sealClient.companySealDetail(token, companySealDetailReq);
        System.out.println(rsp);
    }
}
