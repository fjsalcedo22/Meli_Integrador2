package com.example.meli_integrador2.webService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
  Retrofit object that works as a singleton
 */
object Retrofit {

    val getRetrofit: APIService by lazy {  // getRetrofit variable that returns the services api
        Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(APIService::class.java)
    }

}