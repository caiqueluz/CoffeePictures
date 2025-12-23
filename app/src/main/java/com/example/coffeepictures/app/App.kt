package com.example.coffeepictures.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coffeepictures.app.app.presentation.AppHost
import org.koin.compose.KoinApplication
import org.koin.dsl.KoinAppDeclaration

@Composable
fun App(
    modifier: Modifier = Modifier,
    koinAppDeclaration: KoinAppDeclaration,
    configureCoil: @Composable () -> Unit,
    getTextValue: (Int) -> String,
) {
    KoinApplication(
        application = koinAppDeclaration,
    ) {
        configureCoil()

        AppHost(
            modifier = modifier,
            getTextValue = getTextValue,
        )
    }
}
