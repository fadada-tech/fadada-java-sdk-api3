### **1、适用语言**

​	JAVA

[jar包下载](https://github.com/fadada-tech/fadada-java-sdk-api3/releases)

### **2、SDK支持的环境**

​	JAVA JDK 版本：  JDK 1.7-1.8

### 3、引用jar包

​		引入sdk 所依赖的jar包，提供全流程的方法，提供的方法调用云端法大大api服务。

```xml
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
            <version>4.5.12</version>
        </dependency>
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpmime</artifactId>
            <version>4.5.8</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.10.1</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.7.25</version>
        </dependency>
        <dependency>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
            <version>1.2</version>
        </dependency>

```



### 4、始化客户端

​		项目启动后必须先进行初始化，才能调用jar包方法。初始化仅需一次，之后可重复使用

​		法大大分配的appid，appkey，本地客户端地址，请求超时等信息在初始化时作为入参传入。

```java
public String APPID = "xxxxx";//法大大分配的接入id
public String APPKEY = "xxxxx";//法大大分配的appid对应的key
public String SERVERURL = "";//指定环境请求url

// 默认正式环境初始化
DefaultFadadaApiClient client = new DefaultFadadaApiClient(APPID, APPKEY);

// 指定环境初始化
DefaultFadadaApiClient client = new DefaultFadadaApiClient(APPID, APPKEY, SERVERURL);

// 配置超时时间（默认是不设置超时时间）
FadadaApiConfig fadadaApiConfig = new FadadaApiConfig();
fadadaApiConfig.setReadTimeout(10000); // 读取数据超时时间  单位（ms）
fadadaApiConfig.setConnectTimeout(10000); // 连接超时时间  单位（ms）
DefaultFadadaApiClient client = new DefaultFadadaApiClient(APPID, APPKEY, SERVERURL, fadadaApiConfig);

// DefaultFadadaApiServiceImpl实现了接口FadadaApiService接口提供了json字符串转换以及http请求方法
// 如果要自定义实现json和http方法，只需要实现FadadaApiService接口方法
FadadaApiService fadadaApiService = new DefaultFadadaApiServiceImpl();
DefaultFadadaApiClient client = new DefaultFadadaApiClient(APPID, APPKEY, SERVERURL, fadadaApiConfig,
                fadadaApiService);
//                    ^
//                    |   
// (fadadaApiService替换成自定义实现的类的对象)
// 参数SERVERURL，fadadaApiService如果为空就采用默认的参数， fadadaApiConfig为空就默认不设置超时时间
```



### 5、业务方法调用

​		基础父类DefaultFadadaClient可以构造生成对应业务模块的client，调用具体的业务方法。

- ​	Oauth2Client 为oauth授权码服务	
-  AccountClient为账号服务 
- ​	DocumentClient为文件服务
- ​	SignTaskClient为签署服务
-  EmployeeClient为员工服务
-  SealClient为签章服务
-  TemplateClient为模板服务

除了Oauth2Client外，每个业务模块的方法调用时都需要传token参数。


下面以获取个人union地址的方法调用为例展示调用过程：

```java
//1、获取AccessToken（client为上一步初始化客户端得到DefaultFadadaApiClient对象）
//token有效期2小时，获取后可缓存起来不用每次重新调用
Oauth2Client oauth2Client = new Oauth2Client(client);
String token = oauth2Client.getToken().getData().getAccessToken();
//2、封装业务请求对象。
GetPersonUnionIdUrlReq req = new GetPersonUnionIdUrlReq();
req.setToken(token);
req.setClientId("xxxxx");
req.setRedirectUrl("xxxxx");
//3、构造业务accountClient，调用对应的业务方法
AccountClient accountClient = new AccountClient(client);
BaseRsp<GetUnionIdUrlRsp> rsp = accountClient.getPersonUnionIdUrl(req);
```

更多示例详见demo代码。
