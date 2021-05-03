package com.example.androidexam.repos

import com.example.androidexam.datasources.DummySource
import com.example.androidexam.datasources.LiveSource
import com.example.androidexam.model.CryptoStats

class CryptoRepo {

    private val liveSource = LiveSource()

    suspend fun getCryptoSummary() : List<CryptoStats> {
        var list = liveSource.getSummary()
        return list.sortedByDescending { it.price }
    }
}