# AgriPest Android SDK

这是 AgriPest 系统的官方 Android (Kotlin) 客户端 SDK。

## 当前版本: 1.0.6

## 快速开始

### 1. 添加依赖
在您的 `build.gradle` 中添加：
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    implementation 'com.github.lukecc00:AgriPest-Android-SDK:v1.0.6'
}
```

### 2. 初始化与使用
```kotlin
val apiClient = ApiClient().setBearerToken("YOUR_JWT_TOKEN")
val userApi = apiClient.createService(UserApi::class.java)
// 开始调用接口...
```
