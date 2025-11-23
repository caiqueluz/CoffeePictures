package com.example.coffeepictures.database

import com.example.coffeepictures.database.provider.AppDatabaseProvider
import com.example.coffeepictures.database.provider.RoomDatabaseBuilderFactory
import com.example.coffeepictures.database.provider.RoomDatabaseBuilderFactoryImpl
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
    }
