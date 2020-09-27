import com.fadada.api.DefaultFadadaApiClient;
import com.fadada.api.FadadaApiConfig;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.account.AccessTokenRsp;
import com.fadada.api.client.Oauth2Client;
import com.fadada.api.exception.ApiException;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author gengxl
 * @create 2020-03-06 18:17
 */
public class BaseTest {


    // 0本地环境，1sit环境，2uat环境
    public static int num = 1;

    public static String APPID = new String[]{
            "000003",
            "FA25444835",
            "FA12570596"}[num];
    public static String APPKEY = new String[]{
            "30BOgfz4vcEu7h6TjpYPa1EJ",
            "XONZ3L2ADXEEVLA9CC3AXZVVXYAQ8SDD",
            "HEECPISOQXV100EMGWV4UOB6JQOH77PK"}[num];
    public String unionId = new String[]{
            "ea2b5853b65541edb41c4af92a9b76ed",
            "103166a264e941f78b7dc68b0468eb20",
            "0dbc41f8081c427d82438371812e1f2f"}[num];

    // 服务地址
    public String SERVERURL = new String[]{
            "http://10.99.90.163:8004/api/v3/",
//            "http://192.168.30.100:8004/api/v3/",
            "https://sit-gw.fadada.com/api/v3/",
            "https://v4demo-gw.fadada.com/api/v3/"}[num];


    public static String token = "a3dac4c7c4aa40458d449f00f9e59e7a";


    public String clientId;
    public static DefaultFadadaApiClient client = null;


    public void before() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        clientId = "clientId" + sdf.format(ts);
//        client = new DefaultFadadaApiClient(APPID, APPKEY);
        client = new DefaultFadadaApiClient(APPID, APPKEY, SERVERURL);
        FadadaApiConfig fadadaApiConfig = new FadadaApiConfig();
        fadadaApiConfig.setReadTimeout(10000);
        fadadaApiConfig.setConnectTimeout(10000);
//        client = new DefaultFadadaApiClient(APPID, APPKEY, SERVERURL, fadadaApiConfig);
    }

    public void getToken() throws ApiException {
        before();
        Oauth2Client oauth2Client = new Oauth2Client(client);
        BaseRsp<AccessTokenRsp> rsp = oauth2Client.getToken();
        token = rsp.getData().getAccessToken();
        System.out.println(oauth2Client.getToken());
    }

    public static void main(String[] args) throws ApiException {
        new BaseTest().getToken();
    }


}
