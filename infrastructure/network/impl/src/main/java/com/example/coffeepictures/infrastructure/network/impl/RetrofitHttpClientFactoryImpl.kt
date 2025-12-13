package com.example.coffeepictures.infrastructure.network.impl

import com.example.coffeepictures.infrastructure.network.api.OkHttpClientFactory
import com.example.coffeepictures.infrastructure.network.api.RetrofitHttpClientFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

class RetrofitHttpClientFactoryImpl(
    private val okHttpClientFactory: OkHttpClientFactory,
) : RetrofitHttpClientFactory {
    private val retrofit by lazy {
        createRetrofit()
    }

    override fun <HttpClientT : Any> create(klass: KClass<HttpClientT>): HttpClientT {
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
