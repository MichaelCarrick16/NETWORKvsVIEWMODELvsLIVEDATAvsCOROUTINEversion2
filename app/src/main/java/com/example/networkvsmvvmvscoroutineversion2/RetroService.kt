package com.example.networkvsmvvmvscoroutineversion2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    @GET("repositories")
    fun getDataFromAPI(@Query("q") query : String) : Call<RetroModel>
}