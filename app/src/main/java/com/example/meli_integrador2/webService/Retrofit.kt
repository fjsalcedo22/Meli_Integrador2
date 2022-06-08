package com.example.meli_integrador2.webService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {  // Singlenton

    val getRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(APIService::class.java)
    }

}