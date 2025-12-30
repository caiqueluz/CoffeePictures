package com.example.coffeepictures.app.app.di

import com.example.coffeepictures.AppDependencies
import com.example.coffeepictures.applogic.di.appLogicModule
import com.example.coffeepictures.common.ui.di.commonUiModule
import com.example.coffeepictures.core.compositeModule
import com.example.coffeepictures.favorites.di.favoritesModule
import com.example.coffeepictures.feature.di.featureModule
import com.example.coffeepictures.home.di.homeModule
import com.example.coffeepictures.infrastructure.database.di.databaseModule
import com.example.coffeepictures.infrastructure.image.di.imageModule
import com.example.coffeepictures.infrastructure.network.di.networkModule

fun appModule(appDependencies: AppDependencies) =
    compositeModule(
        databaseModule,
        imageModule,
        networkModule,
        commonUiModule(appDependencies.appCoroutineScope),
        appLogicModule,
        featureModule,
        homeModule,
        favoritesModule,
    )
