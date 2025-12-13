package com.example.coffeepictures.infrastructure.network.api

import kotlin.reflect.KClass

interface RetrofitHttpClientFactory {
    fun <HttpClientT : Any> create(klass: KClass<HttpClientT>): HttpClientT
}
