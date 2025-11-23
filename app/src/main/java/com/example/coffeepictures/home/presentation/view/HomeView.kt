package com.example.coffeepictures.home.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.coffeepictures.R
import com.example.coffeepictures.designsystem.CoffeePicturesPreview
import com.example.coffeepictures.designsystem.component.DSButton
import com.example.coffeepictures.designsystem.component.DSErrorMessageAlert
import com.example.coffeepictures.designsystem.component.DSLoading
import com.example.coffeepictures.designsystem.core.DSSpacing
import com.example.coffeepictures.home.presentation.logic.HomeViewState

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    viewState: HomeViewState,
    onLoadNewButtonClicked: () -> Unit,
    onAddToFavoritesButtonClicked: () -> Unit,
) {
    Column(
        modifier = modifier.padding(all = DSSpacing.medium),
    ) {
        ImageSection(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(300.dp),
            isLoadingVisible = viewState.isLoadingVisible,
            isErrorVisible = viewState.isErrorVisible,
            imageUrl = viewState.imageUrl,
        )

        Spacer(
            modifier = Modifier.height(DSSpacing.small),
        )

        Spacer(
            modifier = Modifier.weight(1F),
        )

        ButtonSection(
            modifier = Modifier.fillMaxWidth(),
            onLoadNewButtonClicked = onLoadNewButtonClicked,
            onAddToFavoritesButtonClicked = onAddToFavoritesButtonClicked,
        )
    }
}

@Composable
private fun ImageSection(
    modifier: Modifier = Modifier,
    isLoadingVisible: Boolean,
    isErrorVisible: Boolean,
    imageUrl: String?,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        if (isLoadingVisible) {
            DSLoading(
                modifier = Modifier.fillMaxSize(),
            )
        }

        if (isErrorVisible) {
            DSErrorMessageAlert(
                modifier = Modifier.fillMaxSize(),
                text = stringResource(id = R.string.home_error_text),
            )
        }

        imageUrl?.let { url ->
            Image(
                modifier = Modifier.fillMaxSize(),
                url = url,
            )
        }
    }
}

@Composable
private fun Image(
    modifier: Modifier = Modifier,
    url: String,
) {
    // TODO - show real image.

    Box(
        modifier = modifier,
    )
}

@Composable
private fun ButtonSection(
    modifier: Modifier = Modifier,
    onLoadNewButtonClicked: () -> Unit,
    onAddToFavoritesButtonClicked: () -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(DSSpacing.small),
    ) {
        DSButton(
            modifier = Modifier.weight(1F),
            text = stringResource(id = R.string.home_load_new_button_text),
            onButtonClicked = onLoadNewButtonClicked,
        )

        DSButton(
            modifier = Modifier.weight(1F),
            text = stringResource(id = R.string.home_add_to_favorites_button_text),
            onButtonClicked = onAddToFavoritesButtonClicked,
        )
    }
}

private class HomeViewPreviewProvider : PreviewParameterProvider<HomeViewState> {
    override val values: Sequence<HomeViewState> =
        sequenceOf(
            // Loading.
            HomeViewState(
                isLoadingVisible = true,
                isErrorVisible = false,
                imageUrl = null,
            ),
            // Error.
            HomeViewState(
                isLoadingVisible = false,
                isErrorVisible = true,
                imageUrl = null,
            ),
            // Success.
            HomeViewState(
                isLoadingVisible = false,
                isErrorVisible = false,
                imageUrl = "example.com", // TODO - use real image url.
            ),
        )
}

@Preview
@Composable
private fun HomeViewPreview(
    @PreviewParameter(HomeViewPreviewProvider::class) viewState: HomeViewState,
) {
    CoffeePicturesPreview {
        HomeView(
            modifier = Modifier.fillMaxSize(),
            viewState = viewState,
            onLoadNewButtonClicked = {},
            onAddToFavoritesButtonClicked = {},
        )
    }
}
