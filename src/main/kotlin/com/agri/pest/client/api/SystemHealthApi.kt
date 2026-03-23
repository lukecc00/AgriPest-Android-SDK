package com.agri.pest.client.api

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import okhttp3.RequestBody
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.Completable
import com.google.gson.annotations.SerializedName

import com.agri.pest.client.model.ResultObject
import com.agri.pest.client.model.ResultString

interface SystemHealthApi {
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

}
