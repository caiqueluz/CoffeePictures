package com.example.coffeepictures.app.di

import com.example.coffeepictures.core.compositeModule
import com.example.coffeepictures.home.di.homeModule

val appModule =
    compositeModule(
        homeModule,
    )
