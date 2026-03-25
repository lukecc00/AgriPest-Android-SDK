# AgriPest Android SDK

这是 AgriPest 系统的官方 Android (Kotlin) 客户端 SDK。

## 当前版本: 1.0.80

## 🚀 快速开始

### 1. 添加依赖
在您的 `build.gradle` 中添加：
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    // 推荐使用 HTTPS 格式引入，无需配置 SSH Key
    implementation 'com.github.lukecc00:AgriPest-Android-SDK:v1.0.80'
}
```

## 🛠 技术原理

本 SDK 基于 **OpenAPI Specification (OAS 3.0)** 标准自动生成，采用业界主流的 Android 网络层技术栈：
- **网络库**: [Retrofit2](https://github.com/square/retrofit)
- **异步框架**: [RxJava3](https://github.com/ReactiveX/RxJava)
- **序列化**: [Gson](https://github.com/google/gson)
- **底层传输**: [OkHttp3](https://github.com/square/okhttp)

### 设计思想
- **简洁性**: 客户端只需关注 `ApiService` 一个入口。
- **类型安全**: 所有请求与响应均有对应的实体类。
- **一致性**: 业务错误码与服务端实时同步。

## 📖 使用指南

### 1. 初始化 ApiClient
建议在 `Application` 中初始化：
```kotlin
val apiClient = ApiClient().apply {
    setBasePath("http://115.191.67.35:8080") 
    setBearerToken("your_jwt_token_here")
}
val apiService = apiClient.createService(ApiService::class.java)
```

### 2. 发起请求 (RxJava3)
```kotlin
apiService.login(LoginRequest(usernameOrPhone = "...", password = "..."))
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe({ response ->
        if (response.code == ServiceCode.SUCCESS) {
            // 成功逻辑
        }
    }, { error ->
        error.printStackTrace()
    })
```


