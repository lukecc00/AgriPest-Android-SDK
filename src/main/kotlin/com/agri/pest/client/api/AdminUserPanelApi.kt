package com.agri.pest.client.api

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import okhttp3.RequestBody
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.Completable
import com.google.gson.annotations.SerializedName

import com.agri.pest.client.model.AdminUserUpdateDto
import com.agri.pest.client.model.ResultAdminUserResponseDto
import com.agri.pest.client.model.ResultObject
import com.agri.pest.client.model.ResultPageAdminUserResponseDto
import com.agri.pest.client.model.ResultVoid

interface AdminUserPanelApi {
    /**
     * Create user
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
     * Delete user
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
     * Get user by ID
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
     * Get user list (Paginated)
     * 
     * Responses:
     *  - 500: Internal Server Error
     *  - 400: Bad Request
     *  - 200: OK
     *
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 10)
     * @return [Call]<[ResultPageAdminUserResponseDto]>
     */
    @GET("api/admin/users")
    fun getUsers(@Query("page") page: kotlin.Int? = 0, @Query("size") size: kotlin.Int? = 10): Single<ResultPageAdminUserResponseDto>

    /**
     * Update user
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

}
