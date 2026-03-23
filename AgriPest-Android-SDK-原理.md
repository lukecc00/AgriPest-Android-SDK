# AgriPest Android SDK 技术原理

## 1. 核心架构
本 SDK 基于 **OpenAPI Specification (OAS 3.0)** 标准自动生成，采用业界主流的 Android 网络层技术栈：
- **网络库**: [Retrofit2](https://github.com/square/retrofit) - 负责将 Java/Kotlin 接口转换为 RESTful 请求。
- **异步框架**: [RxJava3](https://github.com/ReactiveX/RxJava) - 提供响应式编程支持，方便处理线程切换与链式调用。
- **序列化**: [Gson](https://github.com/google/gson) - 负责 JSON 与 Kotlin 数据对象之间的转换。
- **底层传输**: [OkHttp3](https://github.com/square/okhttp) - 负责 HTTP 链接管理、拦截器、超时控制等。

## 2. 自动化流水线
SDK 的维护采用全自动流水线：
1. **服务端定义**: Spring Boot 通过 `springdoc-openapi` 实时导出 API 规范。
2. **代码生成**: 使用 `openapi-generator-maven-plugin` 按照模板生成符合 RxJava3 规范的 Kotlin 代码。
3. **结构重构**: 通过脚本对原始生成的冗余代码进行精简，将 Model 分为 `request` 和 `response` 两个包，并将所有接口统一合并至 `ApiService` 中。
4. **持续集成**: 自动推送到 GitHub 并由 [JitPack](https://jitpack.io/) 监听 Git Tag 进行云端编译发布。

## 3. 设计思想
- **简洁性**: 客户端只需关注 `ApiService` 一个入口。
- **类型安全**: 所有请求参数与响应体均有对应的实体类，且字段配有 `@Schema` 注释说明。
- **一致性**: SDK 中的业务错误码与服务端 [API.md] 文档保持同步。
