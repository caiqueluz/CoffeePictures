package com.example.coffeepictures.feature.impl.favorites.view

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onFirstVisible
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coffeepictures.feature.impl.favorites.logic.FavoritesViewModel
import com.example.coffeepictures.navigator.AppScreenNavigator
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun FavoritesHost(
    modifier: Modifier = Modifier,
    appScreenNavigator: AppScreenNavigator,
) {
    val viewModel =
        koinViewModel<FavoritesViewModel> {
            parametersOf(appScreenNavigator)
        }

    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    BackHandler(
        onBack = viewModel::onBackButtonClicked,
    )

    FavoritesView(
        modifier = modifier.onFirstVisible(callback = viewModel::onFavoritesStarted),
        viewState = viewState,
    )
}
