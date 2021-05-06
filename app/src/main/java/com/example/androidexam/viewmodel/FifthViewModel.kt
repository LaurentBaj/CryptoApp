package com.example.androidexam.viewmodel

import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FifthViewModel : ViewModel() {
    var usd = MutableLiveData<Double>(0.0)
    var crypto =  MutableLiveData<Double>(0.0)

    fun change(double: Double) {
        crypto.value = crypto.value?.div(double)
    }
}