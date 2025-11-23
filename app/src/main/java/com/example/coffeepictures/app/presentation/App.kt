package com.example.coffeepictures.app.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.KoinApplication
import org.koin.dsl.KoinAppDeclaration

@Composable
fun App(
    modifier: Modifier = Modifier,
    koinAppDeclaration: KoinAppDeclaration,
    configureCoil: @Composable () -> Unit,
) {
    KoinApplication(
        application = koinAppDeclaration,
    ) {
        configureCoil()

        AppHost(
            modifier = modifier,
        )
    }
}
