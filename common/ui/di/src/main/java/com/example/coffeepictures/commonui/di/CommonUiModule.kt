package com.example.coffeepictures.common.ui.di

import com.example.coffeepictures.common.ui.api.FeedbackMessagePresenter
import com.example.coffeepictures.common.ui.impl.FeedbackMessagePresenterImpl
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

fun commonUiModule(appCoroutineScope: CoroutineScope) =
    module {
        single<CoroutineScope> {
            appCoroutineScope
        }

        single<FeedbackMessagePresenter> {
            FeedbackMessagePresenterImpl(
                coroutineScope = get(),
            )
        }
    }
