package com.example.coffeepictures.home.di

import com.example.coffeepictures.core.compositeModule
import com.example.coffeepictures.home.domain.LoadRandomImageTask
import com.example.coffeepictures.home.domain.LoadRandomImageTaskImpl
import com.example.coffeepictures.home.presentation.logic.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private val domainModule =
    module {
        factory<LoadRandomImageTask> {
            LoadRandomImageTaskImpl()
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
        domainModule,
        presentationModule,
    )
