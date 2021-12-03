package com.example.yana.spinnerhome.data.remote

import com.google.gson.JsonObject



interface CurrenciesInteractor {
    suspend fun loadCurrencies(): JsonObject
}

class CurrenciesInteractorImpl(private val network: CurrenciesService): CurrenciesInteractor {
    override suspend fun loadCurrencies(): JsonObject {
        return network.loadCurrencies("182301b377784bcdcc617d0ee25787c6")
    }
}