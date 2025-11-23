package com.example.coffeepictures.app.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coffeepictures.app.di.appModule
import org.koin.compose.KoinApplication

@Composable
fun App(
    modifier: Modifier = Modifier,
) {
    KoinApplication(
        application = {
            modules(appModule)
        },
    ) {
        AppHost(
            modifier = modifier,
        )
    }
}
