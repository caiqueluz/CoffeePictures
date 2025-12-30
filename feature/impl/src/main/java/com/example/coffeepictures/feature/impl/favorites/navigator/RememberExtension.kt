package com.example.coffeepictures.feature.impl.favorites.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberFavoritesScreenNavigator(): FavoritesScreenNavigator {
    return remember {
        FavoritesScreenNavigatorImpl()
    }
}
