package com.example.coffeepictures.network

import okhttp3.OkHttpClient
import kotlin.time.Duration.Companion.seconds

class OkHttpClientFactory {
    fun create(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(GENERAL_TIMEOUT_DURATION)
            .readTimeout(GENERAL_TIMEOUT_DURATION)
            .build()
    }

    private companion object {
        val GENERAL_TIMEOUT_DURATION = 30.seconds
    }
}
