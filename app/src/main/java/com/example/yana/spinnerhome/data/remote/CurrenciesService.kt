package com.example.yana.spinnerhome.data.remote


import org.json.JSONObject
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrenciesService {

    @GET("latest")
    suspend fun loadCurrencies(@Query("access_key") key: String)
    : JSONObject
}