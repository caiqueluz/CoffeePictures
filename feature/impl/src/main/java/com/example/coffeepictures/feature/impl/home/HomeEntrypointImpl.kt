package com.example.coffeepictures.feature.impl.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coffeepictures.feature.api.HomeEntrypoint
import com.example.coffeepictures.feature.impl.home.view.HomeHost
import com.example.coffeepictures.navigator.AppScreenNavigator

class HomeEntrypointImpl : HomeEntrypoint {
    @Composable
    override fun Content(
        modifier: Modifier,
        appScreenNavigator: AppScreenNavigator,
    ) {
        HomeHost(
            modifier = modifier,
            appScreenNavigator = appScreenNavigator,
        )
    }
}
