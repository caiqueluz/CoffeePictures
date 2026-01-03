package com.example.coffeepictures.common.ui.di

import com.example.coffeepictures.commonui.api.FeedbackMessagePresenter
import com.example.coffeepictures.common.ui.impl.FeedbackMessagePresenterImpl
import kotlinx.coroutines.CoroutineScope
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun commonUiModule(appCoroutineScope: CoroutineScope) =
    module {
        single<CoroutineScope> {
            appCoroutineScope
        }

        singleOf(::FeedbackMessagePresenterImpl).bind<FeedbackMessagePresenter>()
    }
