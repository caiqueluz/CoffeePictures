package com.example.coffeepictures.applogic.di

import com.example.coffeepictures.applogic.api.AddImageToFavoritesTask
import com.example.coffeepictures.applogic.api.DeleteAllFavoritesTask
import com.example.coffeepictures.applogic.api.GetImageByUrlTask
import com.example.coffeepictures.applogic.api.LoadAllFavoriteImagesTask
import com.example.coffeepictures.applogic.api.LoadRandomImageTask
import com.example.coffeepictures.applogic.impl.AddImageToFavoritesTaskImpl
import com.example.coffeepictures.applogic.impl.DeleteAllFavoritesTaskImpl
import com.example.coffeepictures.applogic.impl.GetImageByUrlTaskImpl
import com.example.coffeepictures.applogic.impl.LoadAllFavoriteImagesTaskImpl
import com.example.coffeepictures.applogic.impl.LoadRandomImageTaskImpl
import com.example.coffeepictures.applogic.impl.ImagesHttpClient
import com.example.coffeepictures.applogic.impl.ImagesRetrofitClient
import com.example.coffeepictures.infrastructure.network.api.RetrofitHttpClientFactory
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appLogicModule =
    module {
        factory<ImagesRetrofitClient> {
            get<RetrofitHttpClientFactory>()
                .create(ImagesRetrofitClient::class)
        }

        factoryOf(::ImagesHttpClient)
        factoryOf(::LoadAllFavoriteImagesTaskImpl).bind<LoadAllFavoriteImagesTask>()
        factoryOf(::LoadRandomImageTaskImpl).bind<LoadRandomImageTask>()
        factoryOf(::AddImageToFavoritesTaskImpl).bind<AddImageToFavoritesTask>()
        factoryOf(::DeleteAllFavoritesTaskImpl).bind<DeleteAllFavoritesTask>()
        factoryOf(::GetImageByUrlTaskImpl).bind<GetImageByUrlTask>()
    }
