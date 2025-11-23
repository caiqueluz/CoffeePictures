package com.example.coffeepictures

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
