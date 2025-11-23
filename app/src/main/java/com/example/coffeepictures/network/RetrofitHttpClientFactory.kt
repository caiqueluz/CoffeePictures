package com.example.coffeepictures.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitHttpClientFactory(
    private val okHttpClientFactory: OkHttpClientFactory,
) {
    private val retrofit by lazy {
        createRetrofit()
    }

    fun <HttpClientT> create(): HttpClientT {
        return retrofit.create()
    }

    private fun createRetrofit(): Retrofit {
        val okHttpClient = okHttpClientFactory.create()
        val gsonConverterFactory = GsonConverterFactory.create()

        return Retrofit.Builder()
            .baseUrl("https://coffee.alexflipnote.dev")
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }
}
