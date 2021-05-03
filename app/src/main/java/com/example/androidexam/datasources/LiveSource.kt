package com.example.androidexam.datasources

import com.example.androidexam.model.CryptoStats
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class LiveSource {

    fun getSummary(): List<CryptoStats> {
        val list = ArrayList<CryptoStats>()

        var response = get("https://api.coincap.io/v2/assets")

        if(response.isSuccessful) {
            var cryptoCurrencies = JSONObject(response.body).optJSONArray("data")

            cryptoCurrencies.let {
                for(i in 0 until cryptoCurrencies.length()) {
                    list.add(
                        CryptoStats(
                            cryptoCurrencies.getJSONObject(i).getString("name"),
                            cryptoCurrencies.getJSONObject(i).getString("symbol"),
                            cryptoCurrencies.getJSONObject(i).getString("priceUsd"),
                            cryptoCurrencies.getJSONObject(i).getString("changePercent24Hr"),
                        ))
                }
            }
        }

        return list
    }

    private fun get(endpointURL: String): HTTPResponse {

        val url = URL(endpointURL)
        val connection = url.openConnection() as HttpURLConnection
        try {
            connection.requestMethod = "GET"

            connection.connect()

            val stream = if (connection.responseCode in 200..300) connection.inputStream else connection.errorStream

            val responseBody = try {
                stream.bufferedReader(Charsets.UTF_8).use { it.readText() }
            } catch (e: Throwable) {
                ""
            }

            return HTTPResponse(connection.responseCode, responseBody)
        } catch (e: Throwable) {
            return HTTPResponse(connection.responseCode, "")
        } finally {
            connection.disconnect()
        }
    }


    class HTTPResponse (private val statusCode: Int, val body : String) {
        val isSuccessful = statusCode in 200..300
    }
}

