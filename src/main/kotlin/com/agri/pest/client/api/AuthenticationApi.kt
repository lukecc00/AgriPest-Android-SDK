package com.agri.pest.client.api

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import okhttp3.RequestBody
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.Completable
import com.google.gson.annotations.SerializedName

import com.agri.pest.client.model.LoginRequest
import com.agri.pest.client.model.RefreshTokenRequest
import com.agri.pest.client.model.RegisterRequest
import com.agri.pest.client.model.ResultAuthResponse
import com.agri.pest.client.model.ResultObject
import com.agri.pest.client.model.ResultVoid
import com.agri.pest.client.model.SendSmsRequest
import com.agri.pest.client.model.SmsLoginRequest

interface AuthenticationApi {
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

}
