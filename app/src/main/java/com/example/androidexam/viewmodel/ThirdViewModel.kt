package com.example.androidexam.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidexam.AppDB
import com.example.androidexam.entities.Currency
import com.example.androidexam.entities.TransDao
import kotlinx.coroutines.launch
import java.lang.Exception

class ThirdViewModel : ViewModel() {
    lateinit var transDao: TransDao
    private val _currency = MutableLiveData<Currency>()
    val currency: LiveData<Currency> get() = _currency

    fun dbInit(context: Context) {
        transDao = AppDB.getInstance(context).transDao
        getPortfolio()
    }

    private val _error = MutableLiveData<Throwable>()
    private fun getPortfolio() {
        try {
            viewModelScope.launch {
                val currencyData = transDao.fetchData()
                _currency.postValue(currencyData)
            }
        } catch (e: Exception) {
            e.fillInStackTrace()
            _error.postValue(e)
            Log.d("MainView", "Error: ${e.message}")
        }
    }
}