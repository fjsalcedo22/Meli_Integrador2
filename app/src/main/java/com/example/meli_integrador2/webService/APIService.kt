package com.example.meli_integrador2.webService

import com.example.meli_integrador2.model.Activity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
/**
   Interface to create consumption methods
 */
interface APIService {

    // function that searches an activity with participants and prices
    @GET("activity")
    suspend fun getActivity(@Query("type") typeActivity : String, @Query("participants") participants : String, @Query("price") price : String) : Response<Activity>


    // functions that searches for a random activity with specific participants and price
    @GET("activity")
    suspend fun getActivityRandom(@Query("participants") participants : String, @Query("price") price : String) : Response<Activity>

}