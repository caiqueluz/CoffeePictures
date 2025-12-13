package com.example.coffeepictures.favorites.di

import com.example.coffeepictures.app.navigator.AppScreenNavigator
import com.example.coffeepictures.core.compositeModule
import com.example.coffeepictures.favorites.data.LoadAllFavoriteImagesTaskImpl
import com.example.coffeepictures.favorites.domain.LoadAllFavoriteImagesTask
import com.example.coffeepictures.favorites.presentation.logic.FavoritesViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private val domainModule =
    module {
        factory<LoadAllFavoriteImagesTask> {
            LoadAllFavoriteImagesTaskImpl(
                imagesDao = get(),
            )
        }
    }

private val presentationModule =
    module {
        viewModel { (appScreenNavigator: AppScreenNavigator) ->
            FavoritesViewModel(
                loadAllFavoriteImagesTask = get(),
                appScreenNavigator = appScreenNavigator,
            )
        }
    }

val favoritesModule =
    compositeModule(
        domainModule,
        presentationModule,
    )
