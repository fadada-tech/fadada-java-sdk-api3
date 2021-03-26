package com.fadada.api.constants;


/**
 * @author gengxl
 * @create 2020-03-07 10:44
 */
public class GlobalConstants {

    private GlobalConstants() {
    }

    /**
     * 公共请求参数
     **/
    public static final String FDD_APPID = "X-FDD-Api-App-Id";
    public static final String FDD_SIGN_TYPE = "X-FDD-Api-Sign-Type";
    public static final String FDD_TOKEN = "X-FDD-Api-Token";
    public static final String FDD_USER_TOKEN = "X-FDD-Api-User-Token";
    public static final String FDD_TIMESTAMP = "X-FDD-Api-Timestamp";
    public static final String FDD_NONCE = "X-FDD-Api-Nonce";
    public static final String FDD_GRANT_TYPE = "X-FDD-Api-Grant-Type";
    public static final String FDD_API_SIGN = "X-FDD-Api-Sign";
    public static final String FDD_REQEUST_ID = "X-FDD-Request-Id";

    /**
     * 默认授权类型
     **/
    public static final String CLIENT_CREDENTIAL = "client_credential";

    public static final String SUCCESS_CODE = "100000";

    public static final int SUCCESS_CODE_200 = 200;


    /**
     * 字符集
     **/
    public static final String CHARSET_UTF8 = "UTF-8";
    public static final String CHARSET_GBK = "GBK";

    /**
     * HTTP请求相关
     **/
    public static final String METHOD_POST = "POST";
    public static final String METHOD_GET = "GET";


}
