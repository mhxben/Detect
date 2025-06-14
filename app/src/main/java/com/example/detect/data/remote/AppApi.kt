package com.example.detect.data.remote

import com.example.detect.data.model.*
import retrofit2.Response
import retrofit2.http.*

interface AppApi {
    @POST("/auth/register/")
    suspend fun registerAuth(@Body request: RegisterRequest): Response<RegisterResponse>

    @GET("package/list")
    suspend fun getPackagesList(): Response<List<Package>>

    @GET("package/{id}")
    suspend fun getPackageById(@Path("id") id: Int): Response<Package>

    @PATCH("package/{id}")
    suspend fun getPackageStatePane(
        @Path("id") id: Int,
        @Body predetect: PannePredetect
    ): Response<PanneState>

}