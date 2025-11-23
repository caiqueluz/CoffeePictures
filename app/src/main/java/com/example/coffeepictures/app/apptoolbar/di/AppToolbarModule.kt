package com.example.coffeepictures.app.apptoolbar.di

import com.example.coffeepictures.app.apptoolbar.presentation.logic.AppToolbarViewModel
import com.example.coffeepictures.app.navigator.AppScreenNavigator
import com.example.coffeepictures.core.compositeModule
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private val presentationModule =
    module {
        viewModel { (appScreenNavigator: AppScreenNavigator) ->
            AppToolbarViewModel(
                appScreenNavigator = appScreenNavigator,
            )
        }
    }

val appToolbarModule =
    compositeModule(
        presentationModule,
    )
