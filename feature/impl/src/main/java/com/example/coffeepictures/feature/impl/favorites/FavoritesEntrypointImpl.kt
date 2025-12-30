package com.example.coffeepictures.feature.impl.favorites

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coffeepictures.feature.api.FavoritesEntrypoint
import com.example.coffeepictures.feature.impl.favorites.view.FavoritesHost
import com.example.coffeepictures.navigator.AppScreenNavigator

class FavoritesEntrypointImpl : FavoritesEntrypoint {
    @Composable
    override fun Content(
        modifier: Modifier,
        appScreenNavigator: AppScreenNavigator,
    ) {
        FavoritesHost(
            modifier = modifier,
            appScreenNavigator = appScreenNavigator,
        )
    }
}
