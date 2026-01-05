package com.example.coffeepictures.infrastructure.database.impl

import com.example.coffeepictures.infrastructure.database.api.ImagesDao
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
