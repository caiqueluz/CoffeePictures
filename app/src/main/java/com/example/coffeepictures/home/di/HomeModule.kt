package com.example.coffeepictures.home.di

import com.example.coffeepictures.core.compositeModule
import com.example.coffeepictures.home.data.LoadRandomImageTaskImpl
import com.example.coffeepictures.home.data.RandomImagesHttpClient
import com.example.coffeepictures.home.data.RandomImagesRetrofitClient
import com.example.coffeepictures.home.domain.LoadRandomImageTask
import com.example.coffeepictures.home.presentation.logic.HomeViewModel
import com.example.coffeepictures.network.RetrofitHttpClientFactory
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private val dataModule =
    module {
        factory {
            val client =
                get<RetrofitHttpClientFactory>()
                    .create(RandomImagesRetrofitClient::class)

            RandomImagesHttpClient(
                randomImagesRetrofitClient = client,
            )
        }
    }

private val domainModule =
    module {
        factory<LoadRandomImageTask> {
            LoadRandomImageTaskImpl(
                httpClient = get(),
            )
        }
    }

private val presentationModule =
    module {
        viewModel {
            HomeViewModel(
                loadRandomImageTask = get(),
            )
        }
    }

val homeModule =
    compositeModule(
        dataModule,
        domainModule,
        presentationModule,
    )
