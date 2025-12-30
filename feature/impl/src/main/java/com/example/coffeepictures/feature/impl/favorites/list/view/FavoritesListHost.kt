package com.example.coffeepictures.feature.impl.favorites.list.view

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onFirstVisible
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coffeepictures.feature.impl.favorites.list.logic.FavoritesListViewModel
import com.example.coffeepictures.feature.impl.favorites.navigator.FavoritesScreenNavigator
import com.example.coffeepictures.navigator.AppScreenNavigator
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun FavoritesListHost(
    modifier: Modifier = Modifier,
    appScreenNavigator: AppScreenNavigator,
    favoritesScreenNavigator: FavoritesScreenNavigator,
) {
    val viewModel =
        koinViewModel<FavoritesListViewModel> {
            parametersOf(
                appScreenNavigator,
                favoritesScreenNavigator,
            )
        }

    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    BackHandler(
        onBack = viewModel::onBackButtonClicked,
    )

    FavoritesListView(
        modifier = modifier.onFirstVisible(callback = viewModel::onFavoritesStarted),
        viewState = viewState,
        onToolbarBackIconClicked = viewModel::onToolbarBackIconClicked,
        onToolbarDeleteIconClicked = viewModel::onToolbarDeleteIconClicked,
        onItemClicked = viewModel::onItemClicked,
    )
}
