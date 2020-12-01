import com.fadada.api.bean.req.account.NoticeReq;
import com.fadada.api.bean.req.revise.*;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.revise.CreateReviseTaskRsp;
import com.fadada.api.bean.rsp.revise.GetFillFileUrlRsp;
import com.fadada.api.bean.rsp.revise.ReviseTaskDetailRsp;
import com.fadada.api.client.ReviseTaskClient;
import com.fadada.api.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gengxl
 * @create 2020-03-06 18:17
 */
public class ReviseTest extends BaseTest {

    private static ReviseTaskClient reviseTaskClient;
    private String taskId = "d4f374ef78ae453a86aeb0ac70b161d3";
    private String templateId = "1606283413370186589";


    public static void main(String[] args) throws ApiException {
        ReviseTest reviseTest = new ReviseTest();
        reviseTest.getToken();
        reviseTaskClient = new ReviseTaskClient(client);
//        reviseTest.createReviseTask();
//        reviseTest.getFillFileUrl();
        reviseTest.reviseTaskDetail();
//        reviseTest.saveFillValues();
//        reviseTest.cancelReviseTask();
    }


    private void createReviseTask() throws ApiException {
        CreateReviseTaskReq req = new CreateReviseTaskReq();
        req.setToken(token);
        req.setTemplateId(templateId);
        req.setTaskSubject("主题");
        req.setSort(1);
        req.setFinalizeWay(1);
        List<CreateReviseTaskReq.FillRoleInfo> roles = new ArrayList<>();
        CreateReviseTaskReq.FillRoleInfo fillRoleInfo = new CreateReviseTaskReq.FillRoleInfo();
        fillRoleInfo.setUnionId("ea2b5853b65541edb41c4af92a9b76ed");
        fillRoleInfo.setRoleName("YH");
        NoticeReq noticeReq = new NoticeReq();
        noticeReq.setNotifyAddress("15527435516");
        noticeReq.setNotifyWay(1);
        fillRoleInfo.setNotice(noticeReq);

        CreateReviseTaskReq.FillRoleInfo fillRoleInfo1 = new CreateReviseTaskReq.FillRoleInfo();
        fillRoleInfo1.setUnionId("ea2b5853b65541edb41c4af92a9b76ed");
        fillRoleInfo1.setRoleName("HY");
        NoticeReq noticeReq1 = new NoticeReq();
        noticeReq1.setNotifyAddress("15527435516");
        noticeReq1.setNotifyWay(1);
        fillRoleInfo1.setNotice(noticeReq);
        roles.add(fillRoleInfo);
        roles.add(fillRoleInfo1);
        req.setFillRoles(roles);
        BaseRsp<CreateReviseTaskRsp> rsp = reviseTaskClient.createReviseTask(req);
        System.out.println(rsp.toString());
    }

    private void getFillFileUrl() throws ApiException {
        GetFillFileUrlReq req = new GetFillFileUrlReq();
        req.setToken(token);
        req.setTaskId(taskId);
        req.setRoleName("YH");
        BaseRsp<GetFillFileUrlRsp> rsp = reviseTaskClient.getFillFileUrl(req);
        System.out.println(rsp.toString());
    }

    private void reviseTaskDetail() throws ApiException {
        ReviseTaskDetailReq req = new ReviseTaskDetailReq();
        req.setToken(token);
        req.setTaskId(taskId);
        BaseRsp<ReviseTaskDetailRsp> rsp = reviseTaskClient.reviseTaskDetail(req);
        System.out.println(rsp.toString());
    }

    private void saveFillValues() throws ApiException {
        SaveFillValuesReq req = new SaveFillValuesReq();
        req.setToken(token);
        req.setTaskId(taskId);
        List<SaveFillValuesReq.RoleFillValueInfo> fillValueInfos = new ArrayList<>();
        SaveFillValuesReq.RoleFillValueInfo valueInfo = new SaveFillValuesReq.RoleFillValueInfo();
        valueInfo.setRoleName("HY");
        List<SaveFillValuesReq.FillValueInfo> valueInfos = new ArrayList<>();
        SaveFillValuesReq.FillValueInfo fillValueInfo = new SaveFillValuesReq.FillValueInfo();
        fillValueInfo.setFileId("1606299420496151769");
        fillValueInfo.setValues("{\"name\":\"1\",\"address\":\"2\"}");
        valueInfos.add(fillValueInfo);
        valueInfo.setFillValues(valueInfos);
        fillValueInfos.add(valueInfo);
        req.setRoleFillValues(fillValueInfos);
        BaseRsp rsp = reviseTaskClient.saveFillValues(req);
        System.out.println(rsp.toString());
    }

    private void cancelReviseTask() throws ApiException {
        CancelReviseTaskReq req = new CancelReviseTaskReq();
        req.setToken(token);
        req.setTaskId(taskId);
        BaseRsp rsp = reviseTaskClient.cancelReviseTask(req);
        System.out.println(rsp.toString());
    }


}
