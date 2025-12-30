package com.example.coffeepictures.feature.impl.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coffeepictures.feature.api.AppEntrypoint

class AppEntrypointImpl : AppEntrypoint {
    @Composable
    override fun Content(
        modifier: Modifier,
        getTextValue: (Int) -> String,
    ) {
        AppHost(
            modifier = modifier,
            getTextValue = getTextValue,
        )
    }
}
