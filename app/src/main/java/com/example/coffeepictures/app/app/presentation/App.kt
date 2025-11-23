package com.example.coffeepictures.app.app.presentation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.KoinApplication
import org.koin.dsl.KoinAppDeclaration

@Composable
fun App(
    modifier: Modifier = Modifier,
    koinAppDeclaration: KoinAppDeclaration,
    snackbarHostState: SnackbarHostState,
    configureCoil: @Composable () -> Unit,
) {
    KoinApplication(
        application = koinAppDeclaration,
    ) {
        configureCoil()

        AppHost(
            modifier = modifier,
            snackbarHostState = snackbarHostState,
        )
    }
}
