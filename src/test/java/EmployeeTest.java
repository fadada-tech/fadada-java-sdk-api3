import com.fadada.api.bean.req.organization.AddEmployeeReq;
import com.fadada.api.bean.req.organization.DelEmployeeReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.client.EmployeeClient;
import com.fadada.api.exception.ApiException;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName EmployeeTest.java
 * @Description 员工测试
 * @Param
 * @createTime 2020年06月17日 15:36:00
 */
public class EmployeeTest extends BaseTest {
    private static EmployeeClient employeeClient;

    public static void main(String[] args) throws ApiException {
        EmployeeTest employeeTest = new EmployeeTest();
        employeeTest.getToken();
        employeeClient = new EmployeeClient(client);

        employeeTest.addEmployee();
        employeeTest.delEmployee();
    }

    /**
     * 新增员工
     */
    public void addEmployee() throws ApiException {
        AddEmployeeReq req = new AddEmployeeReq();
        req.setToken(token);
        req.setEmployeeInfo(unionId);
        BaseRsp baseRsp = employeeClient.addEmployee(req);
        System.out.println(baseRsp);
    }


    /**
     * 删除员工
     */
    public void delEmployee() throws ApiException {
        DelEmployeeReq req = new DelEmployeeReq();
        req.setToken(token);
        req.setEmployeeInfo(unionId);
        BaseRsp baseRsp = employeeClient.delEmployee(req);
        System.out.println(baseRsp);
    }
}
