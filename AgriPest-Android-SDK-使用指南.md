# AgriPest Android SDK 使用指南

## 1. 集成 SDK
在项目根目录的 `build.gradle` 中添加 JitPack 仓库：
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
```

在 Module 的 `build.gradle` 中引入依赖：
```gradle
dependencies {
    implementation 'com.github.lukecc00:AgriPest-Android-SDK:v1.0.25'
}
```

## 2. 初始化 ApiClient
建议在 `Application` 或 `Singleton` 中初始化：
```kotlin
val apiClient = ApiClient().apply {
    // 设置基础 URL (如果是本地测试环境，请确保手机能访问到该 IP)
    setBasePath("http://115.191.67.35:8080") 
    // 设置登录后获取的 JWT Token
    setBearerToken("your_jwt_token_here")
}

// 创建 ApiService 实例
val apiService = apiClient.createService(ApiService::class.java)
```

## 3. 发起请求 (RxJava3 示例)
```kotlin
apiService.login(LoginRequest(usernameOrPhone = "...", password = "..."))
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe({ response ->
        // 处理成功响应 (Result 包装类)
        if (response.code == ServiceCode.SUCCESS) {
            val authData = response.data
            // ... 存储 token 等操作
        } else {
            // 根据 ServiceCode 处理业务逻辑错误
            Log.e("API", "错误信息: ${response.message}")
        }
    }, { error ->
        // 处理网络错误 (404, 500, Timeout 等)
        error.printStackTrace()
    })
```

## 4. 业务错误码判断
SDK 提供了 `ServiceCode` 常量类，方便您进行业务逻辑判断：
```kotlin
if (response.code == ServiceCode.USERNAME_ALREADY_EXISTS) {
    // 提示用户用户名已存在
}
```
