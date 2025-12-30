package com.example.coffeepictures.feature.api

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coffeepictures.navigator.AppScreenNavigator

interface AppToolbarEntrypoint {
    @Composable
    fun Content(
        modifier: Modifier = Modifier,
        appScreenNavigator: AppScreenNavigator,
    )
}
