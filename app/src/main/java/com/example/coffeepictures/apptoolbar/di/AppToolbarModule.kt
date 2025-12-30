package com.example.coffeepictures.apptoolbar.di

import com.example.coffeepictures.apptoolbar.presentation.logic.AppToolbarViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appToolbarModule =
    module {
        viewModelOf(::AppToolbarViewModel)
    }
