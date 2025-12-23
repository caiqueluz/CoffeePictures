package com.example.coffeepictures.home.di

import com.example.coffeepictures.core.compositeModule
import com.example.coffeepictures.home.presentation.logic.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private val presentationModule =
    module {
        viewModel {
            HomeViewModel(
                loadRandomImageTask = get(),
                addImageToFavoritesTask = get(),
                feedbackMessagePresenter = get(),
            )
        }
    }

val homeModule =
    compositeModule(
        presentationModule,
    )
