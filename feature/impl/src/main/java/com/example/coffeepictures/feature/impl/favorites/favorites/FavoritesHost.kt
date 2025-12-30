package com.example.coffeepictures.feature.impl.favorites.favorites

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coffeepictures.feature.impl.favorites.detail.view.FavoritesDetailHost
import com.example.coffeepictures.feature.impl.favorites.list.view.FavoritesListHost
import com.example.coffeepictures.feature.impl.favorites.navigator.FavoritesScreenModel.Detail
import com.example.coffeepictures.feature.impl.favorites.navigator.FavoritesScreenModel.List
import com.example.coffeepictures.feature.impl.favorites.navigator.rememberFavoritesScreenNavigator
import com.example.coffeepictures.navigator.AppScreenNavigator

@Composable
fun FavoritesHost(
    modifier: Modifier = Modifier,
    appScreenNavigator: AppScreenNavigator,
) {
    val favoritesScreenNavigator = rememberFavoritesScreenNavigator()
    val screenModel by favoritesScreenNavigator.favoritesScreenFlow.collectAsStateWithLifecycle()

    Box(
        modifier = modifier,
    ) {
        when (val model = screenModel) {
            is Detail -> {
                FavoritesDetailHost(
                    imageUrl = model.imageUrl,
                    favoritesScreenNavigator = favoritesScreenNavigator,
                )
            }

            is List -> {
                FavoritesListHost(
                    appScreenNavigator = appScreenNavigator,
                    favoritesScreenNavigator = favoritesScreenNavigator,
                )
            }
        }
    }
}
