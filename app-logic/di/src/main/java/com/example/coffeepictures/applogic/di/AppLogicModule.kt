package com.example.coffeepictures.applogic.di

import com.example.coffeepictures.applogic.api.AddImageToFavoritesTask
import com.example.coffeepictures.applogic.api.GetImageByUrlTask
import com.example.coffeepictures.applogic.api.LoadAllFavoriteImagesTask
import com.example.coffeepictures.applogic.api.LoadRandomImageTask
import com.example.coffeepictures.applogic.impl.AddImageToFavoritesTaskImpl
import com.example.coffeepictures.applogic.impl.GetImageByUrlTaskImpl
import com.example.coffeepictures.applogic.impl.LoadAllFavoriteImagesTaskImpl
import com.example.coffeepictures.applogic.impl.LoadRandomImageTaskImpl
import com.example.coffeepictures.applogic.impl.RandomImagesHttpClient
import com.example.coffeepictures.applogic.impl.RandomImagesRetrofitClient
import com.example.coffeepictures.infrastructure.network.api.RetrofitHttpClientFactory
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appLogicModule =
    module {
        factory<RandomImagesRetrofitClient> {
            get<RetrofitHttpClientFactory>()
                .create(RandomImagesRetrofitClient::class)
        }

        factoryOf(::RandomImagesHttpClient)
        factoryOf(::LoadAllFavoriteImagesTaskImpl).bind<LoadAllFavoriteImagesTask>()
        factoryOf(::LoadRandomImageTaskImpl).bind<LoadRandomImageTask>()
        factoryOf(::AddImageToFavoritesTaskImpl).bind<AddImageToFavoritesTask>()
        factoryOf(::GetImageByUrlTaskImpl).bind<GetImageByUrlTask>()
    }
