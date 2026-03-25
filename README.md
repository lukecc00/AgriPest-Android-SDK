# AgriPest Android SDK

这是 AgriPest 系统的官方 Android (Kotlin) 客户端 SDK。

## 当前版本: 1.0.76

## 🚀 快速开始

### 1. 添加依赖
在您的 `build.gradle` 中添加：
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    // 推荐使用 HTTPS 格式引入，无需配置 SSH Key
    implementation 'com.github.lukecc00:AgriPest-Android-SDK:v1.0.76'
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

| 模块分类      | 业务 Code | 错误信息 (Message)                 | 场景说明            |
| --------- | ------- | ------------------------------ | --------------- |
| **系统**    | 200     | Success                        | 请求成功            |
| **系统**    | 400     | 参数校验失败的具体信息                    | 客户端提交的参数不符合要求   |
| **系统**    | 5000    | Internal server error          | 服务器内部异常         |
| **认证/用户** | 4000    | Invalid request parameters     | 请求参数缺失或不合法      |
| **认证/用户** | 4001    | Username already exists        | 用户名已被占用         |
| **认证/用户** | 4002    | Phone number already exists    | 手机号已被绑定         |
| **认证/用户** | 4004    | User not found                 | 用户不存在           |
| **认证/用户** | 4005    | Invalid username or password   | 账号或密码错误         |
| **认证/用户** | 4006    | Invalid token or token expired | Token失效或已超时     |
| **认证/用户** | 4007    | Failed to send SMS code        | 短信发送失败          |
| **认证/用户** | 4008    | Invalid or expired SMS code    | 验证码错误或过期        |
| **认证/用户** | 4009    | Username length error          | 用户名长度不符 (2-15位) |
| **认证/用户** | 4003    | Access denied                  | 权限不足            |
| **社区/帖子** | 4101    | Post not found                 | 帖子不存在           |
| **社区/帖子** | 4102    | Comment not found              | 评论不存在           |
| **社区/帖子** | 4103    | Post already liked             | 不能重复点赞          |
| **社区/帖子** | 4104    | Post already favorited         | 不能重复收藏          |
| **社区/帖子** | 4105    | No permission                  | 越权操作            |
| **我的作物**  | 4201    | Crop not found                 | 作物不存在           |
| **我的作物**  | 4202    | Medication plan not found      | 用药计划不存在         |
| **识别预警**  | 4301    | Detection record not found     | 识别记录不存在         |
| **识别预警**  | 4302    | AI service unavailable         | AI 服务不可用        |
| **文件服务**  | 4401    | File upload failed             | 上传失败            |
| **文件服务**  | 4402    | File size exceeds limit        | 文件超过 10MB       |
| **文件服务**  | 4403    | Invalid file type              | 格式不支持 (仅限图片)    |
| **文件服务**  | 4404    | Storage service error          | 存储服务异常          |
| **消息通知**  | 4501    | Message not found              | 消息不存在           |
| **消息通知**  | 4502    | Admin record not found         | 管理员发布记录不存在      |
