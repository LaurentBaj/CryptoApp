package com.example.androidexam.repos

import com.example.androidexam.datasources.LiveSource
import com.example.androidexam.datasources.retrofit.CryptoApiClient
import com.example.androidexam.model.CryptoStats

class CryptoRepo {

    private val cryptoApiClient = CryptoApiClient()

    suspend fun getCryptoSummary() : List<CryptoStats> {
        var list = cryptoApiClient.getSummary()
        return list.sortedByDescending { it.price }
    }
}

