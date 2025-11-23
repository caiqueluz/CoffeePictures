package com.example.coffeepictures.image

import org.koin.dsl.module

val imageModule =
    module {
        single {
            CoilImageLoaderFactory(
                applicationContext = get(),
                okHttpClientFactory = get(),
            )
        }
    }
