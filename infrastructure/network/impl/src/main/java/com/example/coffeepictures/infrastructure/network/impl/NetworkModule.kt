package com.example.coffeepictures.infrastructure.network.impl

import com.example.coffeepictures.infrastructure.network.api.OkHttpClientFactory
import com.example.coffeepictures.infrastructure.network.api.RetrofitHttpClientFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule =
    module {
        singleOf(::OkHttpClientFactoryImpl).bind<OkHttpClientFactory>()
        singleOf(::RetrofitHttpClientFactoryImpl).bind<RetrofitHttpClientFactory>()
    }
