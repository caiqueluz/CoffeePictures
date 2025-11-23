package com.example.coffeepictures.app.di

import com.example.coffeepictures.apptoolbar.di.appToolbarModule
import com.example.coffeepictures.core.compositeModule
import com.example.coffeepictures.database.databaseModule
import com.example.coffeepictures.designsystem.di.designSystemModule
import com.example.coffeepictures.designsystem.feedbackmessagepresenter.FeedbackMessagePresenter
import com.example.coffeepictures.home.di.homeModule
import com.example.coffeepictures.image.imageModule
import com.example.coffeepictures.network.networkModule

fun appModule(feedbackMessagePresenter: FeedbackMessagePresenter) =
    compositeModule(
        designSystemModule(feedbackMessagePresenter),
        databaseModule,
        imageModule,
        networkModule,
        appToolbarModule,
        homeModule,
    )
