package com.fadada.api.utils.config;

/**
 * @author yanghui
 * @className SystemConfig
 * @description 解析配置文件信息
 * @createTime 2020年8月13日 15:33:58
 */
public class SystemConfig {
    private SystemConfig() {
    }

    private static String serverUrl = "https://saas-gw.fadada.com/api/v3/";


    public static void setServerUrl(String serverUrl) {
        SystemConfig.serverUrl = serverUrl;
    }

    public static String getServerUrl() {
        return serverUrl;
    }
}
