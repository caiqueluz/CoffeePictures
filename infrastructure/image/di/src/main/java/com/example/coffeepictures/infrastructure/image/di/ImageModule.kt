package com.example.coffeepictures.infrastructure.image.di

import com.example.coffeepictures.infrastructure.api.CoilImageLoaderFactory
import com.example.coffeepictures.infrastructure.impl.CoilImageLoaderFactoryImpl
import org.koin.dsl.module

val imageModule =
    module {
        single<CoilImageLoaderFactory> {
            CoilImageLoaderFactoryImpl(
                applicationContext = get(),
                okHttpClientFactory = get(),
            )
        }
    }
