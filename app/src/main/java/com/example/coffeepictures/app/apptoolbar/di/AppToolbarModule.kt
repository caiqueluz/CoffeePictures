package com.example.coffeepictures.app.apptoolbar.di

import com.example.coffeepictures.app.app.presentation.AppScreenModel
import com.example.coffeepictures.app.apptoolbar.presentation.logic.AppToolbarViewModel
import com.example.coffeepictures.core.compositeModule
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private val presentationModule =
    module {
        viewModel { (appScreenFlow: StateFlow<AppScreenModel>) ->
            AppToolbarViewModel(
                appScreenFlow = appScreenFlow,
            )
        }
    }

val appToolbarModule =
    compositeModule(
        presentationModule,
    )
