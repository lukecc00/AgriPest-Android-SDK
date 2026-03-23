package com.agri.pest.client.api

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import okhttp3.RequestBody
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.Completable
import com.google.gson.annotations.SerializedName

import com.agri.pest.client.model.ChangePhoneRequest
import com.agri.pest.client.model.ProfileUpdateRequest
import com.agri.pest.client.model.ResultListString
import com.agri.pest.client.model.ResultObject
import com.agri.pest.client.model.ResultString
import com.agri.pest.client.model.ResultUserProfileDto
import com.agri.pest.client.model.ResultVoid

import okhttp3.MultipartBody

interface DefaultApi {
    /**
     * 
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
