package com.example.coffeepictures.home.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coffeepictures.home.presentation.logic.HomeViewModel

@Composable
fun HomeHost(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel, // TODO - get from koin.
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    HomeView(
        modifier = modifier,
        viewState = viewState,
        onLoadNewButtonClicked = viewModel::onLoadNewButtonClicked,
        onAddToFavoritesButtonClicked = viewModel::onAddToFavoritesButtonClicked,
    )
}
