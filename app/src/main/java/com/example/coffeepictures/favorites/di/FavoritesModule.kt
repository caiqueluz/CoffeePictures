package com.example.coffeepictures.favorites.di

import com.example.coffeepictures.favorites.presentation.logic.FavoritesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val favoritesModule =
    module {
        viewModelOf(::FavoritesViewModel)
    }
