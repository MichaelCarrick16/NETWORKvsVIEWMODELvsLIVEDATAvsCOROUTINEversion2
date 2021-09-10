package com.example.networkvsmvvmvscoroutineversion2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {

    private val retrofit by lazy {
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.github.com/search/")
            .build()
    }

    val api : RetroService by lazy {
        retrofit.create(RetroService::class.java)
    }
}