package com.example.androidexam.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidexam.model.CryptoStats
import com.example.androidexam.repos.CryptoRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class SecondViewModel : ViewModel() {
    val liveStats = MutableLiveData<List<CryptoStats>> (ArrayList<CryptoStats>())
    private var repo = CryptoRepo()

    fun refresh() {
        viewModelScope.launch {
            var result = withContext(Dispatchers.IO) {
                repo.getCryptoSummary()
            }
            liveStats.value = result
        }
    }
}