package com.example.coffeepictures.commonui.di

import com.example.coffeepictures.commonui.api.FeedbackMessagePresenter
import com.example.coffeepictures.commonui.impl.FeedbackMessagePresenterImpl
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
