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

class SecondViewModel : ViewModel() {
    val liveStats = MutableLiveData<List<CryptoStats>> (ArrayList())
    var isLoading = MutableLiveData(false)

    lateinit var transDao: TransDao
    private var _points = MutableLiveData<Double>()
    var Points = _points

    private var repo = CryptoRepo()

    fun dbInit(context: Context) {
        transDao = AppDB.getInstance(context).transDao
        getPoints()
    }

    private val _error = MutableLiveData<Throwable>()
    private fun getPoints() {
        try {
            viewModelScope.launch {
                val points = transDao.getWorth()
                _points.postValue(points)
            }
        } catch (e: Exception) {
            e.fillInStackTrace()
            _error.postValue(e)
            Log.d("MainView", "Error: ${e.message}")
        }
    }

    fun atInstall() {
        try {
            viewModelScope.launch {
                val portFolio = PortFolio("USD", 10000.0, 10000.0)
                transDao.insertPortfolio(portFolio)
                getPoints()
            }
        } catch (e: Exception) {
            e.fillInStackTrace()
            _error.postValue(e)
            Log.d("InstallationGift", "Error: ${e.message}")
        }
    }

    fun refresh() {
        isLoading.value = true
        viewModelScope.launch {
            var result = withContext(Dispatchers.IO) {
                repo.getCryptoSummary()
            }
            isLoading.value = false
            liveStats.value = result
        }
    }
}