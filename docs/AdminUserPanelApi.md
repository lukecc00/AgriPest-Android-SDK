# AdminUserPanelApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUser**](AdminUserPanelApi.md#createUser) | **POST** api/admin/users | Create user
[**deleteUser**](AdminUserPanelApi.md#deleteUser) | **DELETE** api/admin/users/{id} | Delete user
[**getUserById**](AdminUserPanelApi.md#getUserById) | **GET** api/admin/users/{id} | Get user by ID
[**getUsers**](AdminUserPanelApi.md#getUsers) | **GET** api/admin/users | Get user list (Paginated)
[**updateUser**](AdminUserPanelApi.md#updateUser) | **PUT** api/admin/users/{id} | Update user



Create user

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(AdminUserPanelApi::class.java)
val adminUserUpdateDto : AdminUserUpdateDto =  // AdminUserUpdateDto | 

val result : ResultAdminUserResponseDto = webService.createUser(adminUserUpdateDto)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **adminUserUpdateDto** | [**AdminUserUpdateDto**](AdminUserUpdateDto.md)|  |

### Return type

[**ResultAdminUserResponseDto**](ResultAdminUserResponseDto.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


Delete user

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(AdminUserPanelApi::class.java)
val id : kotlin.Long = 789 // kotlin.Long | 

val result : ResultVoid = webService.deleteUser(id)
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


Get user by ID

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(AdminUserPanelApi::class.java)
val id : kotlin.Long = 789 // kotlin.Long | 

val result : ResultAdminUserResponseDto = webService.getUserById(id)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**|  |

### Return type

[**ResultAdminUserResponseDto**](ResultAdminUserResponseDto.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


Get user list (Paginated)

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(AdminUserPanelApi::class.java)
val page : kotlin.Int = 56 // kotlin.Int | 
val size : kotlin.Int = 56 // kotlin.Int | 

val result : ResultPageAdminUserResponseDto = webService.getUsers(page, size)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **kotlin.Int**|  | [optional] [default to 0]
 **size** | **kotlin.Int**|  | [optional] [default to 10]

### Return type

[**ResultPageAdminUserResponseDto**](ResultPageAdminUserResponseDto.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


Update user

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(AdminUserPanelApi::class.java)
val id : kotlin.Long = 789 // kotlin.Long | 
val adminUserUpdateDto : AdminUserUpdateDto =  // AdminUserUpdateDto | 

val result : ResultAdminUserResponseDto = webService.updateUser(id, adminUserUpdateDto)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**|  |
 **adminUserUpdateDto** | [**AdminUserUpdateDto**](AdminUserUpdateDto.md)|  |

### Return type

[**ResultAdminUserResponseDto**](ResultAdminUserResponseDto.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

