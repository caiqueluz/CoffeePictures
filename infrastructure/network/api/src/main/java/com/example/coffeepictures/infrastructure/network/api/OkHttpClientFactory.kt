package com.example.coffeepictures.infrastructure.network.api

import okhttp3.OkHttpClient

interface OkHttpClientFactory {
    fun create(): OkHttpClient
}
