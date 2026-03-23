# AgriPest Android SDK

这是 AgriPest 系统的官方 Android (Kotlin) 客户端 SDK。

## 当前版本: 1.0.7

## 快速开始

### 1. 添加依赖
在您的 `build.gradle` 中添加：
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    implementation 'com.github.lukecc00:AgriPest-Android-SDK:v1.0.7'
}
```

### 2. 初始化与使用
```kotlin
// Android 端已配置为 RxJava3 + Retrofit2 模式
val apiClient = ApiClient().setBearerToken("YOUR_JWT_TOKEN")
val authApi = apiClient.createService(AuthApi::class.java)

authApi.login(loginRequest)
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe({ response ->
        if (response.code == 200) {
            // 登录成功
        }
    }, { error ->
        // 处理错误
    })
```
