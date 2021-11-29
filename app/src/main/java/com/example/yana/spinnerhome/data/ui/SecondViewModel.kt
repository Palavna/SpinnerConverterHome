package com.example.yana.spinnerhome.data.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel: ViewModel() {

    val data = arrayListOf<String>()
    val resultSp = MutableLiveData<String>()


    fun getResultLen(value: Double, first: Double, second: Double) {
        val result = (first / second) * value
        resultSp.postValue(result.toString())

    }
}