package com.example.coffeepictures.applogic.di

import com.example.coffeepictures.applogic.api.AddImageToFavoritesTask
import com.example.coffeepictures.applogic.api.LoadAllFavoriteImagesTask
import com.example.coffeepictures.applogic.api.LoadRandomImageTask
import com.example.coffeepictures.applogic.impl.AddImageToFavoritesTaskImpl
import com.example.coffeepictures.applogic.impl.LoadAllFavoriteImagesTaskImpl
import com.example.coffeepictures.applogic.impl.LoadRandomImageTaskImpl
import com.example.coffeepictures.applogic.impl.RandomImagesHttpClient
import com.example.coffeepictures.applogic.impl.RandomImagesRetrofitClient
import com.example.coffeepictures.infrastructure.network.api.RetrofitHttpClientFactory
import org.koin.dsl.module

val appLogicModule =
    module {
        factory<RandomImagesRetrofitClient> {
            get<RetrofitHttpClientFactory>()
                .create(RandomImagesRetrofitClient::class)
        }

        factory<LoadAllFavoriteImagesTask> {
            LoadAllFavoriteImagesTaskImpl(
                imagesDao = get(),
            )
        }

        factory {
            RandomImagesHttpClient(
                randomImagesRetrofitClient = get(),
            )
        }

        factory<LoadRandomImageTask> {
            LoadRandomImageTaskImpl(
                httpClient = get(),
            )
        }

        factory<AddImageToFavoritesTask> {
            AddImageToFavoritesTaskImpl(
                imagesDao = get(),
            )
        }
    }
