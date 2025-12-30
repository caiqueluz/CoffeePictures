package com.example.coffeepictures.feature.di

import com.example.coffeepictures.feature.api.AppToolbarEntrypoint
import com.example.coffeepictures.feature.impl.apptoolbar.AppToolbarEntrypointImpl
import com.example.coffeepictures.feature.impl.apptoolbar.logic.AppToolbarViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val featureModule =
    module {
        viewModelOf(::AppToolbarViewModel)
        singleOf(::AppToolbarEntrypointImpl).bind<AppToolbarEntrypoint>()
    }
