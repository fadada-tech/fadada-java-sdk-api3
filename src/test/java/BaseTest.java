import com.fadada.api.DefaultFadadaApiClient;
import com.fadada.api.FadadaApiConfig;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.oauth2.AccessTokenRsp;
import com.fadada.api.client.Oauth2Client;
import com.fadada.api.exception.ApiException;

import java.io.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.zip.GZIPOutputStream;

/**
 * @author gengxl
 * @create 2020-03-06 18:17
 */
public class BaseTest {


    // 0本地环境，1sit环境，2uat环境
    public static int num = 0;

    public static String APPID = new String[]{
            "000003",
            "FA25444835",
            "FA18769044"}[num];
    public static String APPKEY = new String[]{
            "30BOgfz4vcEu7h6TjpYPa1EJ",
            "XONZ3L2ADXEEVLA9CC3AXZVVXYAQ8SDD",
            "IIODEQWAGQUPVDSIHJDPLB3DJ7KI2ZYH"}[num];
    public String unionId = new String[]{
            "ea2b5853b65541edb41c4af92a9b76ed",
            "103166a264e941f78b7dc68b0468eb20",
            "0dbc41f8081c427d82438371812e1f2f"}[num];

    public String companyUnionId = new String[]{
            "70062afe0c1c4142ad6b9b3d29e54d58",
            "103166a264e941f78b7dc68b0468eb20",
            "0dbc41f8081c427d82438371812e1f2f"}[num];
    // 服务地址
    public String SERVERURL = new String[]{
            "http://127.0.0.1:8004/api/v3/",
//            "http://192.168.30.100:8004/api/v3/",
            "https://sit-gw.fadada.com/api/v3/",
            "https://v4demo-gw.fadada.com/api/v3/"}[num];


    public static String token = "f53c042ee2d741289c738023051b740d";
    public static String userToken = "e99c9b2581ee425b9bcf0c0e99a81e13";


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


    /**
     * byte[]压缩
     *
     * @param data
     * @return
     */
    public byte[] streamToZip(byte[] data) {
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

}
