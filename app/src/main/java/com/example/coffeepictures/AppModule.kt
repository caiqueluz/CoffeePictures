package com.example.coffeepictures

import com.example.coffeepictures.home.di.homeModule

val appModule =
    compositeModule(
        homeModule,
    )
