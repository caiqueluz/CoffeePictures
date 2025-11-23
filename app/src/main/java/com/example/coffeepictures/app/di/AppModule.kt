package com.example.coffeepictures.app.di

import com.example.coffeepictures.compositeModule
import com.example.coffeepictures.home.di.homeModule

val appModule =
    compositeModule(
        homeModule,
    )
