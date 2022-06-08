package com.example.meli_integrador2.webService

import com.example.meli_integrador2.model.Activity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("activity")
    suspend fun getActivity(@Query("type") typeActivity : String, @Query("participants") participants : String) : Response<Activity>

    @GET("activity")
    suspend fun getActivityrandom(@Query("participants") participants : String) : Response<Activity>

}