package com.example.coffeepictures.infrastructure.image.di

import com.example.coffeepictures.infrastructure.api.CoilImageLoaderFactory
import com.example.coffeepictures.infrastructure.impl.CoilImageLoaderFactoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val imageModule =
    module {
        singleOf(::CoilImageLoaderFactoryImpl).bind<CoilImageLoaderFactory>()
    }
