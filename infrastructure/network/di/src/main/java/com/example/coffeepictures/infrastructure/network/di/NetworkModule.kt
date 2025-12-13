package com.example.coffeepictures.infrastructure.network.di

import com.example.coffeepictures.infrastructure.network.api.OkHttpClientFactory
import com.example.coffeepictures.infrastructure.network.api.RetrofitHttpClientFactory
import com.example.coffeepictures.infrastructure.network.impl.OkHttpClientFactoryImpl
import com.example.coffeepictures.infrastructure.network.impl.RetrofitHttpClientFactoryImpl
import org.koin.dsl.module

val networkModule =
    module {
        single<OkHttpClientFactory> {
            OkHttpClientFactoryImpl()
        }

        single<RetrofitHttpClientFactory> {
            RetrofitHttpClientFactoryImpl(
                okHttpClientFactory = get(),
            )
        }
    }
