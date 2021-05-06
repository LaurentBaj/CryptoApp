package com.example.androidexam.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidexam.AppDB
import com.example.androidexam.entities.PortFolio
import com.example.androidexam.entities.TransDao
import com.example.androidexam.model.CryptoStats
import com.example.androidexam.repos.CryptoRepo
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ThirdViewModel : ViewModel() {
    lateinit var transDao: TransDao
    private val _portFolio = MutableLiveData<PortFolio>()
    val portFolio: LiveData<PortFolio> get() = _portFolio

    fun dbInit(context: Context) {
        transDao = AppDB.getInstance(context).transDao
        getPortfolio()
    }

    private val _error = MutableLiveData<Throwable>()
    private fun getPortfolio() {
        try {
            viewModelScope.launch {
                val portData = transDao.fetchData()
                _portFolio.postValue(portData)
            }
        } catch (e: Exception) {
            e.fillInStackTrace()
            _error.postValue(e)
            Log.d("MainView", "Error: ${e.message}")
        }
    }
}