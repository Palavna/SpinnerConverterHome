package com.example.yana.spinnerhome.ui.firstFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yana.spinnerhome.data.SpinnerEnum

class FirstViewModel : ViewModel() {

    val array = arrayOf(
        SpinnerEnum.MILLIGRAMM,
        SpinnerEnum.GRAMM,
        SpinnerEnum.KILLOGRAMM,
        SpinnerEnum.TONNA,
        SpinnerEnum.FUNT,
        SpinnerEnum.STON,
        SpinnerEnum.UNCIYA
    )
    val data = arrayListOf<String>()
    val resultSp = MutableLiveData<String>()

    fun getResult(value: Double, first: Int, second: Int) {
        val result = (array[first].value / array[second].value) * value
        resultSp.postValue(result.toString())

    }
}