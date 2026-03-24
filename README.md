# AgriPest Android SDK

这是 AgriPest 系统的官方 Android (Kotlin) 客户端 SDK。

## 当前版本: 1.0.48

## 🚀 快速开始

### 1. 添加依赖
在您的 `build.gradle` 中添加：
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    // 推荐使用 HTTPS 格式引入，无需配置 SSH Key
    implementation 'com.github.lukecc00:AgriPest-Android-SDK:v1.0.48'
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

## 3. 全局业务错误码说明

| 模块分类 | 业务 Code | 错误信息 (Message) | 场景说明 |
|---|---|---|---|
| **系统** | 200 | Success | 请求成功 |
| **系统** | 400 | 参数校验失败的具体信息 | 客户端提交的参数不符合要求（例如手机号格式错误） |
| **系统** | 5000 | Internal server error | 服务器内部发生未捕获的异常 |
| **认证/用户** | 4000 | Invalid request parameters | 请求参数缺失或不合法 |
| **认证/用户** | 4001 | Username already exists | 注册时用户名已被占用 |
| **认证/用户** | 4002 | Phone number already exists | 注册时手机号已被绑定 |
| **认证/用户** | 4004 | User not found | 登录或刷新时未找到该用户 |
| **认证/用户** | 4005 | Invalid username or password | 账号或密码错误 |
| **认证/用户** | 4006 | Invalid token or token expired | Token无效、伪造、版本号过期或已超时 |
| **认证/用户** | 4007 | Failed to send SMS code | 短信验证码发送失败（第三方服务异常等） |
| **认证/用户** | 4008 | Invalid or expired SMS code | 短信验证码填写错误或已过期 |
| **社区/帖子** | 4101 | Post not found | 请求查看或操作的帖子不存在 |
| **社区/帖子** | 4102 | Comment not found | 请求操作的评论不存在 |
| **社区/帖子** | 4103 | Post already liked | 用户已经对该帖子点过赞，不能重复点赞 |
| **社区/帖子** | 4104 | Post already favorited | 用户已经收藏过该帖子，不能重复收藏 |
| **社区/帖子** | 4105 | No permission to perform this action | 越权操作（例如尝试删除别人的帖子） |
| **我的作物** | 4201 | Crop not found | 请求操作的作物不存在或不属于当前用户 |
| **我的作物** | 4202 | Medication plan not found | 用药打卡计划不存在 |
| **识别预警** | 4301 | Detection record not found | 识别记录不存在 |
| **识别预警** | 4302 | AI service is currently unavailable | 大模型识别服务不可用、超时或配置错误 |
| **文件服务** | 4401 | File upload failed | 文件上传到存储服务失败 |
| **文件服务** | 4402 | File size exceeds the maximum limit | 文件大小超过了服务器限制（通常为 10MB） |
| **文件服务** | 4403 | Invalid file type | 文件格式不允许（例如要求图片却上传了文本文件） |
