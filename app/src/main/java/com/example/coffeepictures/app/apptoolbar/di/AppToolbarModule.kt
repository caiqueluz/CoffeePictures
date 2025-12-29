package com.example.coffeepictures.app.apptoolbar.di

import com.example.coffeepictures.app.apptoolbar.presentation.logic.AppToolbarViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appToolbarModule =
    module {
        viewModelOf(::AppToolbarViewModel)
    }
