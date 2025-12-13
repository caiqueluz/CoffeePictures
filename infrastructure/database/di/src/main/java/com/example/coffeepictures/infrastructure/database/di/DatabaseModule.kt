package com.example.coffeepictures.infrastructure.database.di

import com.example.coffeepictures.infrastructure.database.api.ImagesDao
import com.example.coffeepictures.infrastructure.database.impl.AppDatabase
import com.example.coffeepictures.infrastructure.database.impl.AppDatabaseProvider
import com.example.coffeepictures.infrastructure.database.impl.RoomDatabaseBuilderFactory
import com.example.coffeepictures.infrastructure.database.impl.RoomDatabaseBuilderFactoryImpl
import org.koin.dsl.module

val databaseModule =
    module {
        factory<RoomDatabaseBuilderFactory> {
            RoomDatabaseBuilderFactoryImpl(
                applicationContext = get(),
            )
        }

        single {
            AppDatabaseProvider(
                databaseBuilderFactory = get(),
            )
        }

        single {
            get<AppDatabaseProvider>().get()
        }

        single<ImagesDao> {
            get<AppDatabase>().imagesDao()
        }
    }
