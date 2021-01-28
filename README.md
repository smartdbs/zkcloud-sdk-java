
# 简介
欢迎使用Smart DBS开发者工具套件（SDK）1.2.0， SDK1.2.0是云API平台的配套工具。SDK实现了统一化，具有中英文语言版本的SDK使用方法相同，接口调用方式相同，统一的错误码和返回包格式这些优点。 为方便 JAVA 开发者调试和接入Smart DBS，这里向您介绍适用于 Java 的Smart DBS开发工具包，并提供首次使用开发工具包的简单示例。让您快速获取Smart DBS Java SDK 并开始调用。

# 依赖环境
1.依赖环境：JDK 8 版本及以上。 2.从 Smart DBS控制台 注册集成商账号。 3.登录集成商账号，创建应用。4.获取 AppKey、AppSecret 以及调用地址（endpoint），AppKey 是用于标识调用者的身份，AppSecret是用于加密签名字符串和服务器端验证签名字符串的密钥。AppSecret 必须严格保管，避免泄露。4.调用创建公司的方法，获取集成账号密码，集成账号密码是公司的身份识别标志，必须严格保管，避免泄露。

# 通过Maven安装（推荐）
通过 Maven 获取安装是使用 JAVA SDK 的推荐方法，Maven 是 JAVA 的依赖管理工具，支持您项目所需的依赖项，并将其安装到项目中。关于 Maven 详细可参考 Maven 官网 。
<br/>1.请访问<a href='https://maven.apache.org/'>Maven官网</a>下载对应系统Maven安装包进行安装。
<br/>2.为您的项目添加 Maven 依赖项，只需在 Maven pom.xml 添加以下依赖项即可。注意这里的版本号只是举例,您可以在<a href='https://search.maven.org/artifact/com.zkteco/zkcloud-sdk-base/1.1.1/jar'>Maven仓库</a>上找到最新的版本，当前最新版本为：
```
 <dependency>
   <groupId>com.zkteco</groupId>
   <artifactId>zkcloud-sdk-base</artifactId>
   <version>1.1.1</version>
 </dependency>
```
<br/>3.引用方法可参考示例。

# 通过源码包安装
1.前往<a href='https://github.com/smartdbs/zkcloud-sdk-java'>Github代码托管地址</a>下载源码压缩包。
2.解压源码包到您项目合适的位置。
3.引用方法可参考示例。

# 示例
以创建公司组织架构接口为例:
```
public static void main(String[] args) {

    //步骤一：初始化accessToken
    // 此初始化行为主要是为了获取DBS平台该应用的accessToken，如不使用会导致方式调用时被DBS平台权限校验拒绝
    // 初始化成功后，接下来每次调用业务方法，都会自动为发起的请求附上相应的accessToken信息，而无需手工传入
    // accessToken有效期为2小时，过期后需再次获取；建议定时更新accessToken，比如每90分钟更新一次
    // accessToken的持久化建议使用redis结合定时任务完成
    Credential credential = new Credential("appKey", "appSecret");
    DBSClient client = new DBSClient("endpoint", credential);
    client.getClientProfile().getHttpProfile().setProtocol(HttpProfile.REQ_HTTP); // 非必须，默认https
    //刷新accessToken
    client.refreshToken();

    //步骤二：创建公司，生成集成账号;若已有集成账号，可跳过此步骤
    String defaultCompanyApiUsername = "集成账号";
    String defaultCompanyApiPassword = "集成账号密码";
    CompanyRequest companyRequest = new CompanyRequest("companyCode", "companyName", "companyEmail");
    Message<CreateCompanyResponse> response = client.createCompany(companyRequest);

    if (ErrorCode.CODE_SUCCESS.equals(response.getCode())) {
        //集成账号
        defaultCompanyApiUsername = response.getPayload().getResults().getApiUser().getUserName();
        //集成账号密码
        defaultCompanyApiPassword = response.getPayload().getResults().getApiUser().getPassword();
    }

    //步骤三：使用client对象调用方法，举例：创建公司组织架构
    OrgUpdateRequest org = new OrgUpdateRequest("组织架构编码", "组织架构名称");
    org.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
    Message orgResponse = client.updateOrg(org);

}
```
更多示例可参考SDK文档的<a href='https://docs.zkclouds.com/sdk/cn/companyInfo.html'>测试用例</a> 或 在<a href='https://github.com/smartdbs/zkcloud-sdk-java/blob/main/zkcloud-sdk-base/src/test/java/com/zkcloud/api/dbs/DBSClientTest.java'>github</a>中的DBSClientTest找到更多示例。

# 语言
从1.1.1版本开始，我们添加了对公共参数Language的支持，以满足部分应用国际化的诉求。Language默认不传，通常是中文，目前可选值为中文或者英文，通过如下方法设置：
```
import com.zkcloud.api.dbs.common.Credential;
import com.zkcloud.api.dbs.common.profile.HttpProfile;
import com.zkcloud.api.dbs.common.profile.Language;
...
  Credential credential = new Credential(appKey, appSecret);
  client = new DBSClient(endpoint, credential);
  client.getClientProfile().setLanguage(Language.ZH_CN);

```




