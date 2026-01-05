package com.example.coffeepictures

import com.example.coffeepictures.applogic.impl.appLogicModule
import com.example.coffeepictures.commonui.impl.commonUiModule
import com.example.coffeepictures.feature.impl.featureModule
import com.example.coffeepictures.infrastructure.database.impl.databaseModule
import com.example.coffeepictures.infrastructure.impl.imageModule
import com.example.coffeepictures.infrastructure.network.impl.networkModule

fun appModule(appDependencies: AppDependencies) =
    compositeModule(
        databaseModule,
        imageModule,
        networkModule,
        commonUiModule(appDependencies.appCoroutineScope),
        appLogicModule,
        featureModule,
    )
