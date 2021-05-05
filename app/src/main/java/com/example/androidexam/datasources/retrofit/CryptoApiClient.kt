package com.example.androidexam.datasources.retrofit

import com.example.androidexam.model.CryptoStats
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class CryptoApiClient {

    private var cryptoApi: CryptoApi
    init {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.coincap.io/v2/")
            .build()

        cryptoApi = retrofit.create(CryptoApi::class.java)
    }

    fun getSummary(): List<CryptoStats> {
        try {
            var response = cryptoApi.getSummary().execute()
            if (response.isSuccessful) {
                response.body()?.data?.let { currency ->
                    return currency
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return ArrayList()
    }

}