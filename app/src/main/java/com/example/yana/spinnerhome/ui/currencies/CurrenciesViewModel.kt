package com.example.yana.spinnerhome.ui.currencies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yana.spinnerhome.data.remote.CurrenciesInteractor
import kotlinx.coroutines.launch

class CurrenciesViewModel(private val service: CurrenciesInteractor) : ViewModel() {

    val array = arrayListOf<Cuurrencies>()

    val data = arrayListOf<String>()
    val resultSp = MutableLiveData<ArrayList<Cuurrencies>>()
    val resultCur = MutableLiveData<String>()


    fun loadCurrencies() {
        viewModelScope.launch {
            kotlin.runCatching {
                val result = service.loadCurrencies()
                val rates = result.getAsJsonObject("rates")
                val keys = result.getAsJsonObject("rates").keySet().toTypedArray()
                val values = arrayListOf<Cuurrencies>()

                for (key in keys) {
                    values.add(Cuurrencies(key, rates.getAsJsonPrimitive(key).asDouble))
                    Log.d("aasasdfasd", "sdfgsdfdfdf")
                }
                resultSp.postValue(values)

            }.onFailure {
                Log.d("aasasdfasd", "sdfgsdfdfdf")
            }
        }
    }
    fun getResult(value: Double, first: Int, second: Int) {
        val firstValue = (resultSp.value?.get(first)?.value ?: 0.0)
        val secondValue = (resultSp.value?.get(second)?.value ?: 0.0)
        val result = firstValue / secondValue * value

        resultCur.postValue(result.toString())
    }
}


data class Cuurrencies(val name: String, val value: Double)