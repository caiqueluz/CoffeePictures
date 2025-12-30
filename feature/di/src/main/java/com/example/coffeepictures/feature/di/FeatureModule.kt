package com.example.coffeepictures.feature.di

import com.example.coffeepictures.feature.api.AppToolbarEntrypoint
import com.example.coffeepictures.feature.api.FavoritesEntrypoint
import com.example.coffeepictures.feature.impl.apptoolbar.AppToolbarEntrypointImpl
import com.example.coffeepictures.feature.impl.apptoolbar.logic.AppToolbarViewModel
import com.example.coffeepictures.feature.impl.favorites.FavoritesEntrypointImpl
import com.example.coffeepictures.feature.impl.favorites.logic.FavoritesViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val featureModule =
    module {
        viewModelOf(::AppToolbarViewModel)
        singleOf(::AppToolbarEntrypointImpl).bind<AppToolbarEntrypoint>()

        viewModelOf(::FavoritesViewModel)
        singleOf(::FavoritesEntrypointImpl).bind<FavoritesEntrypoint>()
    }
