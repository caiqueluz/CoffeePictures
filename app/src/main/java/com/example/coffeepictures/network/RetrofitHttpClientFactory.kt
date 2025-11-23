package com.example.coffeepictures.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

class RetrofitHttpClientFactory(
    private val okHttpClientFactory: OkHttpClientFactory,
) {
    private val retrofit by lazy {
        createRetrofit()
    }

    fun <HttpClientT : Any> create(klass: KClass<HttpClientT>): HttpClientT {
        return retrofit.create(klass.java)
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
