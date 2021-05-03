package com.example.androidexam.datasources.retrofit

import com.example.androidexam.model.CryptoStats

data class SummaryResponse(var CryptoCurrencies: List<CryptoStats>? ) {
}