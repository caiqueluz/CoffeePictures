package com.example.coffeepictures.feature.impl.apptoolbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coffeepictures.feature.api.AppToolbarEntrypoint
import com.example.coffeepictures.feature.impl.apptoolbar.view.AppToolbarHost
import com.example.coffeepictures.navigator.AppScreenNavigator

class AppToolbarEntrypointImpl : AppToolbarEntrypoint {
    @Composable
    override fun Content(
        modifier: Modifier,
        appScreenNavigator: AppScreenNavigator,
    ) {
        AppToolbarHost(
            appScreenNavigator = appScreenNavigator,
        )
    }
}
