package com.example.coffeepictures

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

class CoffeePicturesApplication : Application() {
    lateinit var appDependencies: AppDependencies
        private set

    override fun onCreate() {
        super.onCreate()

        val appCoroutineScope = MainScope()

        appDependencies =
            AppDependenciesImpl(
                appCoroutineScope = appCoroutineScope,
            )
    }
}

private class AppDependenciesImpl(
    override val appCoroutineScope: CoroutineScope,
) : AppDependencies
