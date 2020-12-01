import com.fadada.api.bean.req.account.GetAuthorizeUrlReq;
import com.fadada.api.bean.req.oauth2.CancelAuthSignAuthReq;
import com.fadada.api.bean.req.oauth2.GetAutoSignAuthUrlReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.account.GetAuthorizeUrlRsp;
import com.fadada.api.bean.rsp.oauth2.AccessTokenRsp;
import com.fadada.api.bean.rsp.oauth2.GetAutoSignAuthUrlRsp;
import com.fadada.api.client.Oauth2Client;
import com.fadada.api.exception.ApiException;

/**
 * @author gengxl
 * @create 2020-03-06 18:17
 */
public class Oauth2Test extends BaseTest {

    private String returnUrl = "https://www.baidu.com";

    private static Oauth2Client oauth2Client;

    public static void main(String[] args) throws ApiException {
        Oauth2Test oauth2Test = new Oauth2Test();
        oauth2Test.getToken();
        oauth2Client = new Oauth2Client(client);

        oauth2Test.getAuthorizeUrl();
        oauth2Test.getAutoSignAuthUrl();
        oauth2Test.getToken();
        oauth2Test.cancelAuthSignAuth();

    }

    /**
     * 获取授权地址
     *
     * @throws ApiException
     */
    public void getAuthorizeUrl() throws ApiException {
        GetAuthorizeUrlReq req = new GetAuthorizeUrlReq();
        req.setToken(token);
        req.setRedirectUrl(returnUrl);
        req.setUnionId(unionId);
        req.setScope("");
        BaseRsp<GetAuthorizeUrlRsp> rsp = oauth2Client.getAuthorizeUrl(req);
        System.out.println(rsp.toString());
    }

    /**
     * 获取自动签授权地址
     *
     * @throws ApiException
     */
    public void getAutoSignAuthUrl() throws ApiException {
        GetAutoSignAuthUrlReq req = new GetAutoSignAuthUrlReq();
        req.setToken(token);
        req.setUnionId(unionId);
        req.setRedirectUrl(returnUrl);
        BaseRsp<GetAutoSignAuthUrlRsp> rsp = oauth2Client.getAutoSignAuthUrl(req);
        System.out.println(rsp.toString());
    }

    /**
     * 获取token
     *
     * @throws ApiException
     */
    public void getToken() throws ApiException {
        BaseRsp<AccessTokenRsp> rsp = oauth2Client.getToken();
        System.out.println(rsp.toString());
    }

    /**
     * 取消自动签授权
     *
     * @throws ApiException
     */
    public void cancelAuthSignAuth() throws ApiException {
        CancelAuthSignAuthReq req = new CancelAuthSignAuthReq();
        req.setToken(token);
        req.setUnionId(unionId);
        BaseRsp rsp = oauth2Client.cancelAuthSignAuth(req);
        System.out.println(rsp.toString());
    }


}
