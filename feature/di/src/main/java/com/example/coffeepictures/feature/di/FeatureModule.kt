package com.example.coffeepictures.feature.di

import com.example.coffeepictures.feature.api.AppEntrypoint
import com.example.coffeepictures.feature.api.FavoritesEntrypoint
import com.example.coffeepictures.feature.api.HomeEntrypoint
import com.example.coffeepictures.feature.impl.app.AppEntrypointImpl
import com.example.coffeepictures.feature.impl.favorites.FavoritesEntrypointImpl
import com.example.coffeepictures.feature.impl.favorites.detail.logic.FavoritesDetailViewModel
import com.example.coffeepictures.feature.impl.favorites.list.logic.FavoritesListViewModel
import com.example.coffeepictures.feature.impl.home.HomeEntrypointImpl
import com.example.coffeepictures.feature.impl.home.logic.HomeViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val featureModule =
    module {
        singleOf(::AppEntrypointImpl).bind<AppEntrypoint>()

        viewModelOf(::FavoritesListViewModel)
        viewModelOf(::FavoritesDetailViewModel)
        singleOf(::FavoritesEntrypointImpl).bind<FavoritesEntrypoint>()

        viewModelOf(::HomeViewModel)
        singleOf(::HomeEntrypointImpl).bind<HomeEntrypoint>()
    }
