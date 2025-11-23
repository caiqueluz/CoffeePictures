package com.example.coffeepictures.app.di

import com.example.coffeepictures.core.compositeModule
import com.example.coffeepictures.home.di.homeModule
import com.example.coffeepictures.image.imageModule
import com.example.coffeepictures.network.networkModule

val appModule =
    compositeModule(
        imageModule,
        networkModule,
        homeModule,
    )
