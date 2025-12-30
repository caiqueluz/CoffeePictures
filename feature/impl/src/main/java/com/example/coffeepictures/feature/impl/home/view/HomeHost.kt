package com.example.coffeepictures.feature.impl.home.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onFirstVisible
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coffeepictures.feature.impl.home.logic.HomeViewModel
import com.example.coffeepictures.navigator.AppScreenNavigator
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun HomeHost(
    modifier: Modifier = Modifier,
    appScreenNavigator: AppScreenNavigator,
) {
    val viewModel =
        koinViewModel<HomeViewModel> {
            parametersOf(appScreenNavigator)
        }

    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    HomeView(
        modifier = modifier.onFirstVisible(callback = viewModel::onHomeStarted),
        viewState = viewState,
        onToolbarStarIconClicked = viewModel::onToolbarStarIconClicked,
        onLoadNewButtonClicked = viewModel::onLoadNewButtonClicked,
        onAddToFavoritesButtonClicked = viewModel::onAddToFavoritesButtonClicked,
    )
}
