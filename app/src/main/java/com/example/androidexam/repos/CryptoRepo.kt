package com.example.androidexam.repos

import com.example.androidexam.datasources.DummySource
import com.example.androidexam.model.CryptoStats

class CryptoRepo {

    suspend fun getCryptoSummary() : List<CryptoStats> {
        return DummySource().getSummary()
    }
}