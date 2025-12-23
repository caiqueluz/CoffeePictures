package com.example.coffeepictures.favorites.di

import com.example.coffeepictures.app.navigator.AppScreenNavigator
import com.example.coffeepictures.favorites.presentation.logic.FavoritesViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val favoritesModule =
    module {
        viewModel { (appScreenNavigator: AppScreenNavigator) ->
            FavoritesViewModel(
                loadAllFavoriteImagesTask = get(),
                appScreenNavigator = appScreenNavigator,
            )
        }
    }
