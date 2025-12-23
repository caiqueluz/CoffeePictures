package com.example.coffeepictures.app.apptoolbar.di

import com.example.coffeepictures.app.apptoolbar.presentation.logic.AppToolbarViewModel
import com.example.coffeepictures.app.navigator.AppScreenNavigator
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appToolbarModule =
    module {
        viewModel { (appScreenNavigator: AppScreenNavigator) ->
            AppToolbarViewModel(
                appScreenNavigator = appScreenNavigator,
            )
        }
    }
