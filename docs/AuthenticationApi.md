# AuthenticationApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**login**](AuthenticationApi.md#login) | **POST** api/auth/login | 用户登录
[**loginBySms**](AuthenticationApi.md#loginBySms) | **POST** api/auth/login-by-sms | 手机号验证码登录
[**refresh**](AuthenticationApi.md#refresh) | **POST** api/auth/refresh | 刷新 Token
[**register**](AuthenticationApi.md#register) | **POST** api/auth/register | 用户注册
[**sendSmsCode**](AuthenticationApi.md#sendSmsCode) | **POST** api/auth/send-code | 发送短信验证码



用户登录

使用用户名或手机号加上密码进行登录，成功后返回 JWT Token

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(AuthenticationApi::class.java)
val loginRequest : LoginRequest =  // LoginRequest | 

val result : ResultAuthResponse = webService.login(loginRequest)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **loginRequest** | [**LoginRequest**](LoginRequest.md)|  |

### Return type

[**ResultAuthResponse**](ResultAuthResponse.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


手机号验证码登录

使用手机号和验证码进行登录，如果手机号未注册将自动注册

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(AuthenticationApi::class.java)
val smsLoginRequest : SmsLoginRequest =  // SmsLoginRequest | 

val result : ResultAuthResponse = webService.loginBySms(smsLoginRequest)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **smsLoginRequest** | [**SmsLoginRequest**](SmsLoginRequest.md)|  |

### Return type

[**ResultAuthResponse**](ResultAuthResponse.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


刷新 Token

使用有效的 Refresh Token 获取新的 Access Token

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(AuthenticationApi::class.java)
val refreshTokenRequest : RefreshTokenRequest =  // RefreshTokenRequest | 

val result : ResultAuthResponse = webService.refresh(refreshTokenRequest)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **refreshTokenRequest** | [**RefreshTokenRequest**](RefreshTokenRequest.md)|  |

### Return type

[**ResultAuthResponse**](ResultAuthResponse.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


用户注册

提供用户名、手机号和密码进行注册，注册成功后自动下发 JWT Token

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(AuthenticationApi::class.java)
val registerRequest : RegisterRequest =  // RegisterRequest | 

val result : ResultAuthResponse = webService.register(registerRequest)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **registerRequest** | [**RegisterRequest**](RegisterRequest.md)|  |

### Return type

[**ResultAuthResponse**](ResultAuthResponse.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


发送短信验证码

使用阿里云短信认证服务发送验证码（如果未配置AK，则使用模拟发送并在控制台打印）

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(AuthenticationApi::class.java)
val sendSmsRequest : SendSmsRequest =  // SendSmsRequest | 

val result : ResultVoid = webService.sendSmsCode(sendSmsRequest)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sendSmsRequest** | [**SendSmsRequest**](SendSmsRequest.md)|  |

### Return type

[**ResultVoid**](ResultVoid.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

