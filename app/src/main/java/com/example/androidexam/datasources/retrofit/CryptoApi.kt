package com.example.androidexam.datasources.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface CryptoApi {
    @GET("assets")
    fun getSummary(): Call<SummaryResponse>
}