package com.example.androidexam.datasources

import com.example.androidexam.model.CryptoStats

class DummySource {

    fun getSummary(): List<CryptoStats> {
        var list = ArrayList<CryptoStats>()

        list.add(CryptoStats( "Bitcoin", "btc", "56878", "-1.15"))
        list.add(CryptoStats( "Ethereum", "eth", "2953", "-1.15"))
        list.add(CryptoStats( "Binance Coin", "bnb", "621", "-1.15"))
        list.add(CryptoStats( "XRP", "xrp", "1.565", "-1.15"))
        list.add(CryptoStats( "Tether", "usdt", "1", "-1.15"))
        list.add(CryptoStats( "Dogecoin", "doge", "0.38", "-1.15"))
        list.add(CryptoStats( "Cardano", "ada", "1.32", "-1.15"))
        list.add(CryptoStats( "Polkadot", "dot", "36.42", "-1.15"))
        list.add(CryptoStats( "Uniswap", "uni", "42.41", "-1.15"))

        return list
    }


}