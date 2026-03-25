package com.agri.pest.client.api

import com.agri.pest.client.model.request.*
import com.agri.pest.client.model.response.*

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import okhttp3.RequestBody
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.Completable
import com.google.gson.annotations.SerializedName


import okhttp3.MultipartBody

interface ApiService {
    /**
     * 发表评论
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @param commentRequest 
     * @return [Call]<[ResultCommentResponseDto]>
     */
    @POST("api/posts/{id}/comments")
    fun addComment(@Path("id") id: kotlin.Long, @Body commentRequest: CommentRequest): Single<ResultCommentResponseDto>

    /**
     * 换绑手机号
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param changePhoneRequest 
     * @return [Call]<[ResultVoid]>
     */
    @PUT("api/users/me/phone")
    fun changePhone(@Body changePhoneRequest: ChangePhoneRequest): Single<ResultVoid>

    /**
     * 发布新帖子
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param postCreateRequest 
     * @return [Call]<[ResultPostResponseDto]>
     */
    @POST("api/posts")
    fun createPost(@Body postCreateRequest: PostCreateRequest): Single<ResultPostResponseDto>

    /**
     * 管理员创建用户
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param adminUserUpdateDto 
     * @return [Call]<[ResultAdminUserResponseDto]>
     */
    @POST("api/admin/users")
    fun createUser(@Body adminUserUpdateDto: AdminUserUpdateDto): Single<ResultAdminUserResponseDto>

    /**
     * 管理员删除评论
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultVoid]>
     */
    @DELETE("api/admin/community/comments/{id}")
    fun deleteComment(@Path("id") id: kotlin.Long): Single<ResultVoid>

    /**
     * 管理员删除帖子
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultVoid]>
     */
    @DELETE("api/admin/community/posts/{id}")
    fun deletePost(@Path("id") id: kotlin.Long): Single<ResultVoid>

    /**
     * 管理员删除用户
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultVoid]>
     */
    @DELETE("api/admin/users/{id}")
    fun deleteUser(@Path("id") id: kotlin.Long): Single<ResultVoid>

    /**
     * 收藏指定帖子
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultVoid]>
     */
    @POST("api/posts/{id}/favorite")
    fun favoritePost(@Path("id") id: kotlin.Long): Single<ResultVoid>

    /**
     * 关注用户
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultVoid]>
     */
    @POST("api/users/{id}/follow")
    fun followUser(@Path("id") id: kotlin.Long): Single<ResultVoid>

    /**
     * 获取当前用户的预警消息列表 (首页专用)
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 5)
     * @return [Call]<[ResultPageResultMessageResponseDto]>
     */
    @GET("api/messages/alerts")
    fun getAlertMessages(@Query("page") page: kotlin.Int? = 0, @Query("size") size: kotlin.Int? = 5): Single<ResultPageResultMessageResponseDto>

    /**
     * 获取所有评论列表 (分页)
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 10)
     * @return [Call]<[ResultPageResultCommentResponseDto]>
     */
    @GET("api/admin/community/comments")
    fun getAllComments(@Query("page") page: kotlin.Int? = 0, @Query("size") size: kotlin.Int? = 10): Single<ResultPageResultCommentResponseDto>

    /**
     * 获取所有帖子列表 (分页)
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param tag  (optional)
     * @param q  (optional)
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 10)
     * @return [Call]<[ResultPageResultPostResponseDto]>
     */
    @GET("api/admin/community/posts")
    fun getAllPosts(@Query("tag") tag: kotlin.String? = null, @Query("q") q: kotlin.String? = null, @Query("page") page: kotlin.Int? = 0, @Query("size") size: kotlin.Int? = 10): Single<ResultPageResultPostResponseDto>

    /**
     * 获取帖子评论列表
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 10)
     * @return [Call]<[ResultPageResultCommentResponseDto]>
     */
    @GET("api/posts/{id}/comments")
    fun getComments(@Path("id") id: kotlin.Long, @Query("page") page: kotlin.Int? = 0, @Query("size") size: kotlin.Int? = 10): Single<ResultPageResultCommentResponseDto>

    /**
     * 获取当前用户资料
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @return [Call]<[ResultUserProfileDto]>
     */
    @GET("api/users/me")
    fun getCurrentUserProfile(): Single<ResultUserProfileDto>

    /**
     * 获取消息列表 (分页)
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 10)
     * @return [Call]<[ResultMessageGroupResponseDto]>
     */
    @GET("api/messages")
    fun getMyMessages(@Query("page") page: kotlin.Int? = 0, @Query("size") size: kotlin.Int? = 10): Single<ResultMessageGroupResponseDto>

    /**
     * 获取我发布的帖子列表
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 10)
     * @return [Call]<[ResultPageResultPostResponseDto]>
     */
    @GET("api/posts/mine")
    fun getMyPosts(@Query("page") page: kotlin.Int? = 0, @Query("size") size: kotlin.Int? = 10): Single<ResultPageResultPostResponseDto>

    /**
     * 获取指定帖子详情
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultPostResponseDto]>
     */
    @GET("api/posts/{id}")
    fun getPostDetail(@Path("id") id: kotlin.Long): Single<ResultPostResponseDto>

    /**
     * 获取帖子列表
     * 支持按标签过滤、关键字搜索和分页
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param tag  (optional)
     * @param q  (optional)
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 10)
     * @return [Call]<[ResultPageResultPostResponseDto]>
     */
    @GET("api/posts")
    fun getPosts(@Query("tag") tag: kotlin.String? = null, @Query("q") q: kotlin.String? = null, @Query("page") page: kotlin.Int? = 0, @Query("size") size: kotlin.Int? = 10): Single<ResultPageResultPostResponseDto>

    /**
     * 获取热门标签列表
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @return [Call]<[ResultListTagDto]>
     */
    @GET("api/tags")
    fun getTopTags(): Single<ResultListTagDto>

    /**
     * 获取未读消息数
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @return [Call]<[ResultLong]>
     */
    @GET("api/messages/unread-count")
    fun getUnreadCount(): Single<ResultLong>

    /**
     * 获取指定用户详情
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultAdminUserResponseDto]>
     */
    @GET("api/admin/users/{id}")
    fun getUserById(@Path("id") id: kotlin.Long): Single<ResultAdminUserResponseDto>

    /**
     * 获取用户列表 (分页)
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 10)
     * @return [Call]<[ResultPageResultAdminUserResponseDto]>
     */
    @GET("api/admin/users")
    fun getUsers(@Query("page") page: kotlin.Int? = 0, @Query("size") size: kotlin.Int? = 10): Single<ResultPageResultAdminUserResponseDto>

    /**
     * 健康检查
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @return [Call]<[ResultString]>
     */
    @GET("api/health")
    fun health(): Single<ResultString>

    /**
     * 给指定帖子点赞
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultVoid]>
     */
    @POST("api/posts/{id}/like")
    fun likePost(@Path("id") id: kotlin.Long): Single<ResultVoid>

    /**
     * 用户登录
     * 使用用户名或手机号加上密码进行登录，成功后返回 JWT Token
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param loginRequest 
     * @return [Call]<[ResultAuthResponse]>
     */
    @POST("api/auth/login")
    fun login(@Body loginRequest: LoginRequest): Single<ResultAuthResponse>

    /**
     * 手机号验证码登录
     * 使用手机号和验证码进行登录，如果手机号未注册将自动注册
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param smsLoginRequest 
     * @return [Call]<[ResultAuthResponse]>
     */
    @POST("api/auth/login-by-sms")
    fun loginBySms(@Body smsLoginRequest: SmsLoginRequest): Single<ResultAuthResponse>

    /**
     * 一键已读所有消息
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @return [Call]<[ResultVoid]>
     */
    @PUT("api/messages/read-all")
    fun markAllAsRead(): Single<ResultVoid>

    /**
     * 标记单条消息为已读
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultVoid]>
     */
    @PUT("api/messages/{id}/read")
    fun markAsRead(@Path("id") id: kotlin.Long): Single<ResultVoid>

    /**
     * 发布新消息 (全员或定向预警)
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param adminMessageCreateRequest 
     * @return [Call]<[ResultVoid]>
     */
    @POST("api/admin/messages")
    fun publishMessage(@Body adminMessageCreateRequest: AdminMessageCreateRequest): Single<ResultVoid>

    /**
     * 刷新 Token
     * 使用有效的 Refresh Token 获取新的 Access Token
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param refreshTokenRequest 
     * @return [Call]<[ResultAuthResponse]>
     */
    @POST("api/auth/refresh")
    fun refresh(@Body refreshTokenRequest: RefreshTokenRequest): Single<ResultAuthResponse>

    /**
     * 用户注册
     * 提供用户名、手机号和密码进行注册，注册成功后自动下发 JWT Token
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param registerRequest 
     * @return [Call]<[ResultAuthResponse]>
     */
    @POST("api/auth/register")
    fun register(@Body registerRequest: RegisterRequest): Single<ResultAuthResponse>

    /**
     * 发送短信验证码
     * 使用阿里云短信认证服务发送验证码（如果未配置AK，则使用模拟发送并在控制台打印）
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param sendSmsRequest 
     * @return [Call]<[ResultVoid]>
     */
    @POST("api/auth/send-code")
    fun sendSmsCode(@Body sendSmsRequest: SendSmsRequest): Single<ResultVoid>

    /**
     * 取消收藏
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultVoid]>
     */
    @DELETE("api/posts/{id}/favorite")
    fun unfavoritePost(@Path("id") id: kotlin.Long): Single<ResultVoid>

    /**
     * 取消关注用户
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultVoid]>
     */
    @DELETE("api/users/{id}/follow")
    fun unfollowUser(@Path("id") id: kotlin.Long): Single<ResultVoid>

    /**
     * 取消点赞
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultVoid]>
     */
    @DELETE("api/posts/{id}/like")
    fun unlikePost(@Path("id") id: kotlin.Long): Single<ResultVoid>

    /**
     * 管理员修改评论内容
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @param commentRequest 
     * @return [Call]<[ResultCommentResponseDto]>
     */
    @PUT("api/admin/community/comments/{id}")
    fun updateComment(@Path("id") id: kotlin.Long, @Body commentRequest: CommentRequest): Single<ResultCommentResponseDto>

    /**
     * 修改登录密码
     * 修改成功后当前Token将立即失效，需重新登录
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param newPassword 
     * @return [Call]<[ResultVoid]>
     */
    @PUT("api/users/me/password")
    fun updatePassword(@Query("newPassword") newPassword: kotlin.String): Single<ResultVoid>

    /**
     * 管理员修改帖子内容
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @param postCreateRequest 
     * @return [Call]<[ResultPostResponseDto]>
     */
    @PUT("api/admin/community/posts/{id}")
    fun updatePost(@Path("id") id: kotlin.Long, @Body postCreateRequest: PostCreateRequest): Single<ResultPostResponseDto>

    /**
     * 更新当前用户资料
     * 支持部分更新，字段为空则不修改
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param profileUpdateRequest 
     * @return [Call]<[ResultUserProfileDto]>
     */
    @PUT("api/users/me")
    fun updateProfile(@Body profileUpdateRequest: ProfileUpdateRequest): Single<ResultUserProfileDto>

    /**
     * 管理员更新用户
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param id 
     * @param adminUserUpdateDto 
     * @return [Call]<[ResultAdminUserResponseDto]>
     */
    @PUT("api/admin/users/{id}")
    fun updateUser(@Path("id") id: kotlin.Long, @Body adminUserUpdateDto: AdminUserUpdateDto): Single<ResultAdminUserResponseDto>

    /**
     * 通用单文件上传
     * 上传单张图片/文件至对象存储，并返回可公开访问的 URL。
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param file 
     * @param prefix  (optional, default to "uploads/")
     * @return [Call]<[ResultString]>
     */
    @Multipart
    @POST("api/files/upload")
    fun uploadFile(@Part file: MultipartBody.Part, @Query("prefix") prefix: kotlin.String? = "uploads/"): Single<ResultString>

    /**
     * 通用多文件批量上传
     * 一次性上传多张图片/文件，返回按顺序排列的 URL 列表。
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param files 
     * @param prefix  (optional, default to "uploads/")
     * @return [Call]<[ResultListString]>
     */
    @Multipart
    @POST("api/files/upload/batch")
    fun uploadFiles(@Part files: MultipartBody.Part, @Query("prefix") prefix: kotlin.String? = "uploads/"): Single<ResultListString>

}
