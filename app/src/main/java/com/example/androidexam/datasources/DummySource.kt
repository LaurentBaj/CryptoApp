package com.example.androidexam.datasources

import com.example.androidexam.model.CryptoStats

class DummySource {

    fun getSummary(): List<CryptoStats> {
        var list = ArrayList<CryptoStats>()

        list.add(CryptoStats( "Bitcoin", "BTC", "56878", "-1.15"))
        list.add(CryptoStats( "Ethereum", "ETH", "2953", "-1.15"))
        list.add(CryptoStats( "Binance Coin", "BNB", "621", "-1.15"))
        list.add(CryptoStats( "XRP", "XRP", "1.565", "-1.15"))
        list.add(CryptoStats( "Tether", "USDT", "1", "-1.15"))
        list.add(CryptoStats( "Dogecoin", "DOGE", "0.38", "-1.15"))
        list.add(CryptoStats( "Cardano", "ADA", "1.32", "-1.15"))
        list.add(CryptoStats( "Polkadot", "DOT", "36.42", "-1.15"))
        list.add(CryptoStats( "Uniswap", "UNI", "42.41", "-1.15"))

        return list
    }


}