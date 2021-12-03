package com.example.yana.spinnerhome.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CurrenciesRetrofit {

    fun buildRetrofit(): CurrenciesService {
        return Retrofit.Builder()
            .baseUrl("http://data.fixer.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrenciesService::class.java)
    }
}