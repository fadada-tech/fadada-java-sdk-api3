package com.fadada.api;

/**
 * @author yh128
 * @className FadadaApiConfig
 * @description 请求的配置信息
 * @createTime 2020年8月13日 15:31:04
 */
public class FadadaApiConfig {
    /**
     * 请求服务端签名加密方式，目前仅支持HMAC-SHA256，请勿修改
     */
    private String signType = "HMAC-SHA256";
    /**
     * http连接超时时间
     */
    private int connectTimeout;
    /**
     * http读超时时间
     */
    private int readTimeout;
    /**
     * http是否打开代理
     */
    private Boolean proxyFlag = false;
    /**
     * http代理ip
     */
    private String proxyHost;
    /**
     * http代理端口号
     */
    private Integer proxyPort;


    static FadadaApiService fadadaApiService = new DefaultFadadaApiServiceImpl();


    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public Boolean getProxyFlag() {
        return proxyFlag;
    }

    public void setProxyFlag(Boolean proxyFlag) {
        this.proxyFlag = proxyFlag;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public Integer getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }
}
