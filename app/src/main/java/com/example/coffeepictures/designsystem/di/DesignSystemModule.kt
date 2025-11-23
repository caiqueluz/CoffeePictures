package com.example.coffeepictures.designsystem.di

import com.example.coffeepictures.designsystem.feedbackmessagepresenter.FeedbackMessagePresenter
import org.koin.dsl.module

fun designSystemModule(feedbackMessagePresenter: FeedbackMessagePresenter) =
    module {
        single<FeedbackMessagePresenter> {
            feedbackMessagePresenter
        }
    }
