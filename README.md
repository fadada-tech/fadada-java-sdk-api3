### **1、适用语言**

​	JAVA

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
- ​    AccountClient为账号服务 
- ​	DocumentClient为文件服务
- ​	SignTaskClient为签署服务
- ​    EmployeeClient为员工服务
- ​    SealClient为签章服务
- ​    TemplateClient为模板服务

除了Oauth2Client外，每个业务模块的方法调用时都需要传token参数。

详情见[方法|接口列表](#方法|接口列表)

下面以获取个人union地址的方法调用为例展示调用过程：

```java
//1、获取AccessToken（client为上一步初始化客户端得到DefaultFadadaApiClient对象）
//token有效期2小时，获取后可缓存起来不用每次重新调用
Oauth2Client oauth2Client = new Oauth2Client(client);
String token = oauth2Client.getToken().getData().getAccessToken();
//2、封装业务请求对象。
GetPersonUnionIdUrlReq req = new GetPersonUnionIdUrlReq();
req.setClientId("xxxxx");
req.setRedirectUrl("xxxxx");
//3、构造业务accountClient，调用对应的业务方法
AccountClient accountClient = new AccountClient(client);
BaseRsp<GetUnionIdUrlRsp> rsp = accountClient.getPersonUnionIdUrl(token,req);
```

更多示例详见接口文档及demo代码。

### 6、方法列表
请求接口对应方法如下，请求以及响应参数信息请查看api文档。

| 请求接口                                 | client类       | 方法名                       | 备注                     |
| ---------------------------------------- | -------------- | ---------------------------- | ------------------------ |
| 获取token                                | Oauth2Client   | getToken                     |                          |
| 获取个人unionId地址                      | AccountClient  | getPersonUnionIdUrl          |                          |
| 获取企业unionId地址                      | AccountClient  | getCompanyUnionIdUrl         |                          |
| 获取用户授权地址                         | AccountClient  | getAuthorizeUrl              |                          |
| 获取个人实名信息                         | AccountClient  | getPersonInfo                |                          |
| 获取企业实名信息                         | AccountClient  | getCompanyInfo               |                          |
| 账号信息校验                             | AccountClient  | checkAccountInfo             |                          |
| 接入方信息查询                           | AccountClient  | getAccessObjectInfo          |                          |
| 原始文件上传                             | DocumentClient | uploadFile                   | hash值已计算，不用传该值 |
| 草稿文件下载                             | DocumentClient | getByDraftId                 |                          |
| 签署文件下载                             | DocumentClient | getBySignFileId              |                          |
| 技术报告下载                             | DocumentClient | contractReportDownload       |                          |
| 在线文件验签                             | DocumentClient | verifySignature              | has值已计算，不用传该值  |
| 关键字查询坐标                           | DocumentClient | lookUpCoordinates            |                          |
| 公证处保全报告下载                       | DocumentClient | downloadEvidenceReport       |                          |
| 依据原始文件创建签署任务                 | SignTaskClient | createSignTaskByFileId       |                          |
| 获取签署任务发起链接                     | SignTaskClient | getSentUrl                   |                          |
| 依据模板创建签署任务                     | SignTaskClient | createSignTaskByDraftId      |                          |
| 获取签署链接                             | SignTaskClient | getSignUrl                   |                          |
| 查询签署任务详情                         | SignTaskClient | getTaskDetailByTaskId        |                          |
| 撤销签署任务                             | SignTaskClient | cancelSignTask               |                          |
| 签署任务催签                             | SignTaskClient | urgeSign                     |                          |
| 签署文件在线预览链接                     | SignTaskClient | getSignPreviewUrl            |                          |
| 依据草稿id批量创建签署任务               | SignTaskClient | batchCreateByDraftId         |                          |
| 根据批次号添加签署任务（依据草稿id创建） | SignTaskClient | batchAddByDraftId            |                          |
| 根据批次号批量发起签署任务               | SignTaskClient | batchSent                    |                          |
| 根据批次号获取签署链接                   | SignTaskClient | batchGetSignUrl              |                          |
| 根据批次号查询签署任务                   | SignTaskClient | batchGetSigntasksByBatchNo   |                          |
| 新增员工                                 | EmployeeClient | addEmployee                  |                          |
| 删除员工                                 | EmployeeClient | delEmployee                  |                          |
| 上传企业印章                             | SealClient     | addCompanySeal               | hash值已计算，不用传该值 |
| 删除企业印章                             | SealClient     | delCompanySeal               |                          |
| 印章授权                                 | SealClient     | sealAuth                     |                          |
| 取消授权                                 | SealClient     | cancelSealAuth               |                          |
| 查询企业印章列表                         | SealClient     | companySealList              |                          |
| 查询企业印章详情                         | SealClient     | companySealDetail            |                          |
| 模板文件上传（模板创建第一步）           | TemplateClient | uploadCompanyTemplateFile    | hash值已计算，不用传该值 |
| 新增或更新模板信息（模板创建第二步）     | TemplateClient | updateCompanyTemplate        |                          |
| 获取模板编辑链接（模板创建第三步）       | TemplateClient | getEditCompanyTemplateUrl    |                          |
| 模板文件删除                             | TemplateClient | delCompanyTemplateFile       |                          |
| 模板列表查询                             | TemplateClient | queryCompanyTemplateList     |                          |
| 模板文件下载                             | TemplateClient | downloadCompanyTemplateFile  |                          |
| 模板在线预览链接                         | TemplateClient | getCompanyTemplatePreviewUrl |                          |
| 获取模板详情                             | TemplateClient | getTemplateDetailById        |                          |
| 模板填充                                 | TemplateClient | createByTemplate             |                          |
