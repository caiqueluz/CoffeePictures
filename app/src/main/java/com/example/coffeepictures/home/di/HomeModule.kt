package com.example.coffeepictures.home.di

import com.example.coffeepictures.home.presentation.logic.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val homeModule =
    module {
        viewModel {
            HomeViewModel(
                loadRandomImageTask = get(),
                addImageToFavoritesTask = get(),
                feedbackMessagePresenter = get(),
            )
        }
    }
