package com.example.yana.spinnerhome.data.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yana.spinnerhome.data.LengthSpinnerEnum

class SecondViewModel: ViewModel() {

    val array = arrayOf(
        LengthSpinnerEnum.MILLIMETR,
        LengthSpinnerEnum.SANTIMETR,
        LengthSpinnerEnum.METR,
        LengthSpinnerEnum.KILOMETR,
        LengthSpinnerEnum.MILYA,
        LengthSpinnerEnum.YARD,
        LengthSpinnerEnum.FUT,
        LengthSpinnerEnum.DUIM)

    val data = arrayListOf<String>()
    val resultSp = MutableLiveData<String>()


    fun getResultLen(value: Double, first: Int, second: Int) {
        val result = (array[first].value / array[second].value) * value
        resultSp.postValue(result.toString())

    }
}