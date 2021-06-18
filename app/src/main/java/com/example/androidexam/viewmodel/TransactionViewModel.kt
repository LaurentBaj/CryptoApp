package com.example.androidexam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TransactionViewModel : ViewModel() {

    private var _usd = MutableLiveData<Double>()
    val usd: LiveData<Double> get() = _usd

    private var _crypto = MutableLiveData<Double>()
    val crypto: LiveData<Double> get() = _crypto

    fun usdChange(double: Double) {
        _usd.postValue(double)
    }

    fun convert(worth: Double, value: Double) {
        _crypto.postValue(worth/value)
    }
}