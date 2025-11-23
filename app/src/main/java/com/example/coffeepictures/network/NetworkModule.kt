package com.example.coffeepictures.network

import org.koin.dsl.module

val networkModule =
    module {
        single {
            OkHttpClientFactory()
        }

        single {
            RetrofitHttpClientFactory(
                okHttpClientFactory = get(),
            )
        }
    }
