package com.example.yana.spinnerhome.ui.currencies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yana.spinnerhome.data.remote.CurrenciesInteractor
import kotlinx.coroutines.launch

class CurrenciesViewModel(private val service: CurrenciesInteractor) : ViewModel() {

    fun loadCurrencies() {
        viewModelScope.launch {
            kotlin.runCatching {
                val result = service.loadCurrencies()
                val rates = result.getAsJsonObject("rates")
                val keys = result.getAsJsonObject("rates").keySet().toTypedArray()
                val values = arrayListOf<Cuurrencies>()

                for (key in keys) {
                    values.add(Cuurrencies(key, rates.getAsJsonPrimitive(key).asDouble))
                }

            }.onFailure {
                Log.d("aasasdfasd", "sdfgsdfdfdf")
            }
        }
    }
}

data class Cuurrencies(val name: String, val value: Double)