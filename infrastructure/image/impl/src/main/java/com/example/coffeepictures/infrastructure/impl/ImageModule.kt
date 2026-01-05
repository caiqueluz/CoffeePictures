package com.example.coffeepictures.infrastructure.impl

import com.example.coffeepictures.infrastructure.api.CoilImageLoaderFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val imageModule =
    module {
        singleOf(::CoilImageLoaderFactoryImpl).bind<CoilImageLoaderFactory>()
    }
