package com.example.coffeepictures.infrastructure.database.di

import com.example.coffeepictures.infrastructure.database.api.ImagesDao
import com.example.coffeepictures.infrastructure.database.impl.AppDatabase
import com.example.coffeepictures.infrastructure.database.impl.AppDatabaseProvider
import com.example.coffeepictures.infrastructure.database.impl.RoomDatabaseBuilderFactory
import com.example.coffeepictures.infrastructure.database.impl.RoomDatabaseBuilderFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val databaseModule =
    module {
        factoryOf(::RoomDatabaseBuilderFactoryImpl).bind<RoomDatabaseBuilderFactory>()
        singleOf(::AppDatabaseProvider)

        single {
            get<AppDatabaseProvider>().get()
        }

        single<ImagesDao> {
            get<AppDatabase>().imagesDao()
        }
    }
