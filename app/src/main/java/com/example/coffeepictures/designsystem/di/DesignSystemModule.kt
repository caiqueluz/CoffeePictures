package com.example.coffeepictures.designsystem.di

import com.example.coffeepictures.commonui.api.FeedbackMessagePresenter
import org.koin.dsl.module

fun designSystemModule(feedbackMessagePresenter: FeedbackMessagePresenter) =
    module {
        single<FeedbackMessagePresenter> {
            feedbackMessagePresenter
        }
    }
