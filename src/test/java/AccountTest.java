import com.fadada.api.bean.req.account.*;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.account.*;
import com.fadada.api.client.AccountClient;
import com.fadada.api.exception.ApiException;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;

/**
 * @author gengxl
 * @create 2020-03-06 18:17
 */
public class AccountTest extends BaseTest {

    private String returnUrl = "https://www.baidu.com";

    private static AccountClient accountClient;

    public static void main(String[] args) throws ApiException {
        AccountTest accountTest = new AccountTest();
        accountTest.getToken();
        accountClient = new AccountClient(client);
//        accountTest.getAuthurl();
        accountTest.getCompanyInfo();
//        accountTest.getPersonInfo();
//        accountTest.getPersonUnionIdUrl();
//        accountTest.getCompanyUnionIdUrl();
//        accountTest.checkAccountInfo();


//        accountTest.getAccessObjectInfo();
    }

    public static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void getAuthurl() throws ApiException {
        GetAuthorizeUrlReq req = new GetAuthorizeUrlReq();
        req.setUnionId(unionId);
        req.setRedirectUrl(returnUrl);
        req.setScope("1");
        BaseRsp<GetAuthorizeUrlRsp> rsp = accountClient.getAuthorizeUrl(token, req);
        System.out.println(rsp.toString());
    }

    public void getAccessObjectInfo() throws ApiException {
        BaseRsp<GetAccessObjectInfoRsp> rsp = accountClient.getAccessObjectInfo(token);
        System.out.println(rsp.toString());
    }

    public void getPersonUnionIdUrl() throws ApiException {
        GetPersonUnionIdUrlReq req = new GetPersonUnionIdUrlReq();
        req.setClientId(this.clientId);
        req.setRedirectUrl(returnUrl);
        PersonReq person = new PersonReq();
        person.setMobile("15527435516");

        String base64 = convertFileToBase64("C:\\Users\\yangh1\\Desktop\\工作\\图片\\身份证正面.png");
//        String base64 = convertFileToBase64("C:\\Users\\yangh1\\Desktop\\工作\\12.bmp");
        person.setBackIdCardImgBase64(base64);
        person.setIdCardImgBase64(base64);
        person.setIdPhotoOptional(1);
        person.setIsMiniProgram(0);
        person.setIdentType("1");
        person.setIdentNo("533221202001123396");
        person.setName("杨大哥");
        person.setIsMiniProgram(1);
        person.setIdPhotoOptional(1);
        person.setBankCardNo("62141548754578");
        req.setAuthScheme(1);
        req.setPerson(person);
        BaseRsp<GetUnionIdUrlRsp> rsp = accountClient.getPersonUnionIdUrl(token, req);
        System.out.println(rsp.toString());
    }

    public void getPersonInfo() throws ApiException {
        GetPersonInfoReq req = new GetPersonInfoReq();
        req.setUnionId(unionId);
        BaseRsp<GetPersonInfoRsp> rsp = accountClient.getPersonInfo(token, req);
        System.out.println(rsp.toString());
    }


    public void getCompanyUnionIdUrl() throws ApiException {
        GetCompanyUnionIdUrlReq req = new GetCompanyUnionIdUrlReq();
        req.setClientId(clientId);
        req.setRedirectUrl("http://www.baidu.com");
        CompanyReq company = new CompanyReq();
        company.setCompanyName("张三找小宋");
        company.setCreditNo("NUIK8676ijhj");
        company.setLegalName("张三");
        company.setOrganizationType("2");
//        String base64 = convertFileToBase64("E:\\图片\\3.jpg");
//        company.setAuthorizationFileBase64(base64);
//        company.setCreditImageBase64(base64);


        req.setCompany(company);
        BankReq bankReq = new BankReq();
        bankReq.setBandBranchName("车公庙支行");
        bankReq.setBankCardNo("6214587524544547745");
        bankReq.setBankCityName("深圳市");
        bankReq.setBankName("招商银行");
        bankReq.setBankProvinceName("广东省");
        req.setBank(bankReq);
        ApplicantReq applicant = new ApplicantReq();
        applicant.setUnionId("103166a264e941f78b7dc68b0468eb20");
//        applicant.setApplicantType(1);
        req.setApplicant(applicant);
        BaseRsp<GetUnionIdUrlRsp> rsp = accountClient.getCompanyUnionIdUrl(token, req);
        System.out.println(rsp.toString());
    }


    public void getCompanyInfo() throws ApiException {
        GetCompanyInfoReq req = new GetCompanyInfoReq();
        req.setUnionId(unionId);
        BaseRsp<GetCompanyInfoRsp> rsp = accountClient.getCompanyInfo(token, req);
        System.out.println(rsp.toString());
    }

    public void checkAccountInfo() throws ApiException {
        CheckAccountInfoReq req = new CheckAccountInfoReq();
        req.setMobile("15527435516");
        BaseRsp<CheckAccountInfoRsp> rsp = accountClient.checkAccountInfo(token, req);
        System.out.println(rsp.toString());
    }

    /**
     * 本地文件（图片、excel等）转换成Base64字符串
     *
     * @param imgPath
     */
    public static String convertFileToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            System.out.println("文件大小（字节）=" + in.available());
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组进行Base64编码，得到Base64编码的字符串
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

}
