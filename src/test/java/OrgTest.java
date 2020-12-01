import com.fadada.api.bean.req.organization.*;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.organization.*;
import com.fadada.api.client.OrgClient;
import com.fadada.api.exception.ApiException;

import java.util.List;

/**
 * @author gengxl
 * @create 2020-03-06 18:17
 */
public class OrgTest extends BaseTest {


    private static OrgClient orgClient;

    public static void main(String[] args) throws ApiException {
        OrgTest orgTest = new OrgTest();
        orgTest.getToken();
        orgClient = new OrgClient(client);
//        orgTest.delSubEmployee();
        orgTest.getAddEmployeeUrl();
//        orgTest.getAddSubCompanyUrl();
//        orgTest.getChangeCompanyMajorUrl();
//        orgTest.getChildCompanyList();
//        orgTest.getEmployee();
//        orgTest.removeSubCompany();
    }

    /**
     * 移除员工
     *
     * @throws ApiException
     */
    public void delSubEmployee() throws ApiException {
        DelSubEmployeeReq req = new DelSubEmployeeReq();
        req.setToken(token);
        req.setCompany(unionId);
        req.setEmployeeInfo(unionId);
        req.setUnionId(unionId);
        BaseRsp rsp = orgClient.delSubEmployee(req);
        System.out.println(rsp.toString());
    }

    /**
     * 获取添加员工url
     *
     * @throws ApiException
     */
    public void getAddEmployeeUrl() throws ApiException {
        GetAddEmployeeUrlReq req = new GetAddEmployeeUrlReq();
        req.setToken(token);
        req.setCompany(companyUnionId);
        req.setUserToken(userToken);
        GetAddEmployeeUrlReq.EmployeeInfo employeeInfo = new GetAddEmployeeUrlReq.EmployeeInfo();
        employeeInfo.setUnionId(companyUnionId);
        req.setEmployeeInfo(employeeInfo);
        BaseRsp<GetAddEmployeeUrlRsp> rsp = orgClient.getAddEmployeeUrl(req);
        System.out.println(rsp.toString());
    }

    /**
     * 获取新增子公司url
     *
     * @throws ApiException
     */
    public void getAddSubCompanyUrl() throws ApiException {
        GetAddSubCompanyUrlReq req = new GetAddSubCompanyUrlReq();
        req.setToken(token);
        req.setParentCompany("");
        req.setSubCompany("");
        BaseRsp<GetAddSubCompanyUrlRsp> rsp = orgClient.getAddSubCompanyUrl(req);
        System.out.println(rsp.toString());
    }

    /**
     * 获取变更公司管理员url
     *
     * @throws ApiException
     */
    public void getChangeCompanyMajorUrl() throws ApiException {
        GetChangeCompanyMajorUrlReq req = new GetChangeCompanyMajorUrlReq();
        req.setToken(token);
        req.setUnionId(unionId);
        BaseRsp<GetChangeCompanyMajorUrlRsp> rsp = orgClient.getChangeCompanyMajorUrl(req);
        System.out.println(rsp.toString());
    }

    /**
     * 获取子公司列表
     *
     * @throws ApiException
     */
    public void getChildCompanyList() throws ApiException {
        GetChildCompanyListReq req = new GetChildCompanyListReq();
        req.setToken(token);
        req.setCompany("");
        BaseRsp<List<GetChildCompanyListRsp>> rsp = orgClient.getChildCompanyList(req);
        System.out.println(rsp.toString());
    }

    /**
     * 获取员工列表
     *
     * @throws ApiException
     */
    public void getEmployee() throws ApiException {
        GetEmployeeReq req = new GetEmployeeReq();
        req.setToken(token);
        req.setCompany("");
        BaseRsp<List<GetEmployeeRsp>> rsp = orgClient.getEmployee(req);
        System.out.println(rsp.toString());
    }

    /**
     * 移除子公司
     *
     * @throws ApiException
     */
    public void removeSubCompany() throws ApiException {
        RemoveSubCompanyReq req = new RemoveSubCompanyReq();
        req.setToken(token);
        req.setParentCompany("");
        req.setSubCompany("");
        BaseRsp rsp = orgClient.removeSubCompany(req);
        System.out.println(rsp.toString());
    }


}
