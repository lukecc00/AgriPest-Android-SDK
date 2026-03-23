# DefaultApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**changePhone**](DefaultApi.md#changePhone) | **PUT** api/users/me/phone | 
[**followUser**](DefaultApi.md#followUser) | **POST** api/users/{id}/follow | 关注用户
[**getCurrentUserProfile**](DefaultApi.md#getCurrentUserProfile) | **GET** api/users/me | 获取当前用户资料
[**unfollowUser**](DefaultApi.md#unfollowUser) | **DELETE** api/users/{id}/follow | 取消关注用户
[**updateProfile**](DefaultApi.md#updateProfile) | **PUT** api/users/me | 更新当前用户资料
[**uploadFile**](DefaultApi.md#uploadFile) | **POST** api/files/upload | 通用单文件上传
[**uploadFiles**](DefaultApi.md#uploadFiles) | **POST** api/files/upload/batch | 通用多文件批量上传





### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(DefaultApi::class.java)
val changePhoneRequest : ChangePhoneRequest =  // ChangePhoneRequest | 

val result : ResultVoid = webService.changePhone(changePhoneRequest)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **changePhoneRequest** | [**ChangePhoneRequest**](ChangePhoneRequest.md)|  |

### Return type

[**ResultVoid**](ResultVoid.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


关注用户

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(DefaultApi::class.java)
val id : kotlin.Long = 789 // kotlin.Long | 

val result : ResultVoid = webService.followUser(id)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**|  |

### Return type

[**ResultVoid**](ResultVoid.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


获取当前用户资料

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(DefaultApi::class.java)

val result : ResultUserProfileDto = webService.getCurrentUserProfile()
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ResultUserProfileDto**](ResultUserProfileDto.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


取消关注用户

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(DefaultApi::class.java)
val id : kotlin.Long = 789 // kotlin.Long | 

val result : ResultVoid = webService.unfollowUser(id)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**|  |

### Return type

[**ResultVoid**](ResultVoid.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


更新当前用户资料

支持部分更新，字段为空则不修改

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(DefaultApi::class.java)
val profileUpdateRequest : ProfileUpdateRequest =  // ProfileUpdateRequest | 

val result : ResultUserProfileDto = webService.updateProfile(profileUpdateRequest)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **profileUpdateRequest** | [**ProfileUpdateRequest**](ProfileUpdateRequest.md)|  |

### Return type

[**ResultUserProfileDto**](ResultUserProfileDto.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


通用单文件上传

上传单张图片/文件至对象存储，并返回可公开访问的 URL。

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(DefaultApi::class.java)
val file : java.io.File = BINARY_DATA_HERE // java.io.File | 
val prefix : kotlin.String = prefix_example // kotlin.String | 

val result : ResultString = webService.uploadFile(file, prefix)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **file** | **java.io.File**|  |
 **prefix** | **kotlin.String**|  | [optional] [default to &quot;uploads/&quot;]

### Return type

[**ResultString**](ResultString.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: */*


通用多文件批量上传

一次性上传多张图片/文件，返回按顺序排列的 URL 列表。

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(DefaultApi::class.java)
val files : kotlin.collections.List<java.io.File> = /path/to/file.txt // kotlin.collections.List<java.io.File> | 
val prefix : kotlin.String = prefix_example // kotlin.String | 

val result : ResultListString = webService.uploadFiles(files, prefix)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **files** | **kotlin.collections.List&lt;java.io.File&gt;**|  |
 **prefix** | **kotlin.String**|  | [optional] [default to &quot;uploads/&quot;]

### Return type

[**ResultListString**](ResultListString.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: */*

