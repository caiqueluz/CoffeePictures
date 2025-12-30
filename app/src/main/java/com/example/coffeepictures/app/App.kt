package com.example.coffeepictures.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coffeepictures.feature.api.AppEntrypoint
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
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
        val appEntrypoint = koinInject<AppEntrypoint>()

        configureCoil()

        appEntrypoint.Content(
            modifier = modifier,
            getTextValue = getTextValue,
        )
    }
}
