package com.example.coffeepictures.infrastructure.network.di

import com.example.coffeepictures.infrastructure.network.api.OkHttpClientFactory
import com.example.coffeepictures.infrastructure.network.api.RetrofitHttpClientFactory
import com.example.coffeepictures.infrastructure.network.impl.OkHttpClientFactoryImpl
import com.example.coffeepictures.infrastructure.network.impl.RetrofitHttpClientFactoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule =
    module {
        singleOf(::OkHttpClientFactoryImpl).bind<OkHttpClientFactory>()
        singleOf(::RetrofitHttpClientFactoryImpl).bind<RetrofitHttpClientFactory>()
    }
