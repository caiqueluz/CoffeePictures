package com.example.coffeepictures.feature.impl.home.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onFirstVisible
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coffeepictures.feature.impl.home.logic.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeHost(
    modifier: Modifier = Modifier,
) {
    val viewModel = koinViewModel<HomeViewModel>()
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    HomeView(
        modifier = modifier.onFirstVisible(callback = viewModel::onHomeStarted),
        viewState = viewState,
        onLoadNewButtonClicked = viewModel::onLoadNewButtonClicked,
        onAddToFavoritesButtonClicked = viewModel::onAddToFavoritesButtonClicked,
    )
}
