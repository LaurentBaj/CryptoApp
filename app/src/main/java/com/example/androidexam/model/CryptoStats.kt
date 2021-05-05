package com.example.androidexam.model

data class CryptoStats (
    val id: String? = "undefined",
    val rank: Int? = -1,
    val symbol: String? = "undefined",
    var name: String? = "undefined",
    val supply: String? = "undefined",
    val maxSupply: String? = "undefined",
    val marketCapUsd: String? = "undefined",
    val volumeUsd24Hr: String? = "undefined",
    var priceUsd: Float?,
    var changePercent24Hr: Float?,
    val vwap24Hr: String ? = "undefined"
    )