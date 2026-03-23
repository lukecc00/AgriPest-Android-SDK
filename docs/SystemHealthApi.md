# SystemHealthApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**health**](SystemHealthApi.md#health) | **GET** api/health | 健康检查



健康检查

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import com.agri.pest.client.model.*

val apiClient = ApiClient()
apiClient.setBearerToken("TOKEN")
val webService = apiClient.createWebservice(SystemHealthApi::class.java)

val result : ResultString = webService.health()
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ResultString**](ResultString.md)

### Authorization


Configure BearerAuth:
    ApiClient().setBearerToken("TOKEN")

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

