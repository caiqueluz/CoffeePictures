package com.example.coffeepictures.infrastructure.network.impl

import com.example.coffeepictures.infrastructure.network.api.OkHttpClientFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import kotlin.time.Duration.Companion.seconds

class OkHttpClientFactoryImpl : OkHttpClientFactory {
    override fun create(): OkHttpClient {
        val loggingInterceptor =
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

        return OkHttpClient.Builder()
            .connectTimeout(GENERAL_TIMEOUT_DURATION)
            .readTimeout(GENERAL_TIMEOUT_DURATION)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private companion object {
        val GENERAL_TIMEOUT_DURATION = 10.seconds
    }
}
