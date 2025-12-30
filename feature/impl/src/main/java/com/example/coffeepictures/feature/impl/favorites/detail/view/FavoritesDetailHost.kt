package com.example.coffeepictures.feature.impl.favorites.detail.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onFirstVisible
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coffeepictures.feature.impl.favorites.detail.logic.FavoritesDetailViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoritesDetailHost(
    modifier: Modifier = Modifier,
    imageUrl: String,
) {
    val viewModel = koinViewModel<FavoritesDetailViewModel>()
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    FavoritesDetailView(
        modifier =
            modifier
                .onFirstVisible {
                    viewModel.onFavoritesDetailStarted(url = imageUrl)
                },
        viewState = viewState,
        onToolbarBackIconClicked = viewModel::onToolbarBackIconClicked,
        onToolbarDeleteIconClicked = viewModel::onToolbarDeleteIconClicked,
    )
}
