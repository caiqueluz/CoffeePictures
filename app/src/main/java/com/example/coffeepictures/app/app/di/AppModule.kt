package com.example.coffeepictures.app.app.di

import com.example.coffeepictures.app.apptoolbar.di.appToolbarModule
import com.example.coffeepictures.core.compositeModule
import com.example.coffeepictures.designsystem.di.designSystemModule
import com.example.coffeepictures.designsystem.feedbackmessagepresenter.FeedbackMessagePresenter
import com.example.coffeepictures.favorites.di.favoritesModule
import com.example.coffeepictures.home.di.homeModule
import com.example.coffeepictures.infrastructure.database.di.databaseModule
import com.example.coffeepictures.infrastructure.image.di.imageModule
import com.example.coffeepictures.infrastructure.network.di.networkModule

fun appModule(feedbackMessagePresenter: FeedbackMessagePresenter) =
    compositeModule(
        designSystemModule(feedbackMessagePresenter),
        databaseModule,
        imageModule,
        networkModule,
        appToolbarModule,
        homeModule,
        favoritesModule,
    )
