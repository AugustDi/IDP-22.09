package com.triare.idp_trainee_junior.data.rest

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.triare.idp_trainee_junior.BuildConfig
import com.triare.idp_trainee_junior.data.rest.service.RandomCoffeeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {
    private val gson: Gson by lazy {
        GsonBuilder()
            .setLenient()
            .create()
    }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    val randomCoffeeService: RandomCoffeeService by lazy {
        retrofit.create(RandomCoffeeService::class.java)
    }
}