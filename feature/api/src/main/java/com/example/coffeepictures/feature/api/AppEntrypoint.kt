package com.example.coffeepictures.feature.api

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface AppEntrypoint {
    @Composable
    fun Content(
        modifier: Modifier = Modifier,
        getTextValue: (Int) -> String,
    )
}
