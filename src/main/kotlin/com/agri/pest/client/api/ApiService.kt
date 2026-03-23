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
     * 
     * 
     * Responses:
     *  - 400: Bad Request
     *  - 500: Internal Server Error
     *  - 200: OK
     *
     * @param changePhoneRequest 
     * @return [Call]<[ResultVoid]>
     */
    @PUT("api/users/me/phone")
    fun changePhone(@Body changePhoneRequest: ChangePhoneRequest): Single<ResultVoid>

    /**
     * Create user
     * 
     * Responses:
     *  - 400: Bad Request
     *  - 500: Internal Server Error
     *  - 200: OK
     *
     * @param adminUserUpdateDto 
     * @return [Call]<[ResultAdminUserResponseDto]>
     */
    @POST("api/admin/users")
    fun createUser(@Body adminUserUpdateDto: AdminUserUpdateDto): Single<ResultAdminUserResponseDto>

    /**
     * Delete user
     * 
     * Responses:
     *  - 400: Bad Request
     *  - 500: Internal Server Error
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultVoid]>
     */
    @DELETE("api/admin/users/{id}")
    fun deleteUser(@Path("id") id: kotlin.Long): Single<ResultVoid>

    /**
     * 关注用户
     * 
     * Responses:
     *  - 400: Bad Request
     *  - 500: Internal Server Error
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultVoid]>
     */
    @POST("api/users/{id}/follow")
    fun followUser(@Path("id") id: kotlin.Long): Single<ResultVoid>

    /**
     * 获取当前用户资料
     * 
     * Responses:
     *  - 400: Bad Request
     *  - 500: Internal Server Error
     *  - 200: OK
     *
     * @return [Call]<[ResultUserProfileDto]>
     */
    @GET("api/users/me")
    fun getCurrentUserProfile(): Single<ResultUserProfileDto>

    /**
     * Get user by ID
     * 
     * Responses:
     *  - 400: Bad Request
     *  - 500: Internal Server Error
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultAdminUserResponseDto]>
     */
    @GET("api/admin/users/{id}")
    fun getUserById(@Path("id") id: kotlin.Long): Single<ResultAdminUserResponseDto>

    /**
     * Get user list (Paginated)
     * 
     * Responses:
     *  - 400: Bad Request
     *  - 500: Internal Server Error
     *  - 200: OK
     *
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 10)
     * @return [Call]<[ResultPageAdminUserResponseDto]>
     */
    @GET("api/admin/users")
    fun getUsers(@Query("page") page: kotlin.Int? = 0, @Query("size") size: kotlin.Int? = 10): Single<ResultPageAdminUserResponseDto>

    /**
     * 健康检查
     * 
     * Responses:
     *  - 400: Bad Request
     *  - 500: Internal Server Error
     *  - 200: OK
     *
     * @return [Call]<[ResultString]>
     */
    @GET("api/health")
    fun health(): Single<ResultString>

    /**
     * 用户登录
     * 使用用户名或手机号加上密码进行登录，成功后返回 JWT Token
     * Responses:
     *  - 400: Bad Request
     *  - 500: Internal Server Error
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
     *  - 400: Bad Request
     *  - 500: Internal Server Error
     *  - 200: OK
     *
     * @param smsLoginRequest 
     * @return [Call]<[ResultAuthResponse]>
     */
    @POST("api/auth/login-by-sms")
    fun loginBySms(@Body smsLoginRequest: SmsLoginRequest): Single<ResultAuthResponse>

    /**
     * 刷新 Token
     * 使用有效的 Refresh Token 获取新的 Access Token
     * Responses:
     *  - 400: Bad Request
     *  - 500: Internal Server Error
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
     *  - 400: Bad Request
     *  - 500: Internal Server Error
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
     *  - 400: Bad Request
     *  - 500: Internal Server Error
     *  - 200: OK
     *
     * @param sendSmsRequest 
     * @return [Call]<[ResultVoid]>
     */
    @POST("api/auth/send-code")
    fun sendSmsCode(@Body sendSmsRequest: SendSmsRequest): Single<ResultVoid>

    /**
     * 取消关注用户
     * 
     * Responses:
     *  - 400: Bad Request
     *  - 500: Internal Server Error
     *  - 200: OK
     *
     * @param id 
     * @return [Call]<[ResultVoid]>
     */
    @DELETE("api/users/{id}/follow")
    fun unfollowUser(@Path("id") id: kotlin.Long): Single<ResultVoid>

    /**
     * 更新当前用户资料
     * 支持部分更新，字段为空则不修改
     * Responses:
     *  - 400: Bad Request
     *  - 500: Internal Server Error
     *  - 200: OK
     *
     * @param profileUpdateRequest 
     * @return [Call]<[ResultUserProfileDto]>
     */
    @PUT("api/users/me")
    fun updateProfile(@Body profileUpdateRequest: ProfileUpdateRequest): Single<ResultUserProfileDto>

    /**
     * Update user
     * 
     * Responses:
     *  - 400: Bad Request
     *  - 500: Internal Server Error
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
     *  - 400: Bad Request
     *  - 500: Internal Server Error
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
     *  - 400: Bad Request
     *  - 500: Internal Server Error
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
