package com.example.yana.spinnerhome.data.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {


    val data = arrayListOf<String>()
    val resultSp = MutableLiveData<String>()


    fun getResult(value: Double, first: Double, second: Double) {
        val result = (first / second) * value
        resultSp.postValue(result.toString())

    }
}