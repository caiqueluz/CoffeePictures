package com.example.coffeepictures.feature.impl.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.coffeepictures.designsystem.CoffeePicturesPreview
import com.example.coffeepictures.designsystem.CoilPreviewScope
import com.example.coffeepictures.designsystem.component.DSButton
import com.example.coffeepictures.designsystem.component.DSErrorMessageAlert
import com.example.coffeepictures.designsystem.component.DSLoading
import com.example.coffeepictures.designsystem.core.DSSpacing
import com.example.coffeepictures.feature.impl.R
import com.example.coffeepictures.feature.impl.home.logic.HomeViewState

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    viewState: HomeViewState,
    onToolbarStarIconClicked: () -> Unit,
    onLoadNewButtonClicked: () -> Unit,
    onAddToFavoritesButtonClicked: () -> Unit,
) {
    Scaffold(
        topBar = {
            Toolbar(
                onToolbarStarIconClicked = onToolbarStarIconClicked,
            )
        },
    ) {
        Content(
            modifier = modifier.padding(all = DSSpacing.medium),
            isLoadingVisible = viewState.isLoadingVisible,
            isErrorVisible = viewState.isErrorVisible,
            imageUrl = viewState.imageUrl,
            isLoadNewButtonEnabled = viewState.isLoadNewButtonEnabled,
            isAddToFavoritesButtonEnabled = viewState.isAddToFavoritesButtonEnabled,
            onLoadNewButtonClicked = onLoadNewButtonClicked,
            onAddToFavoritesButtonClicked = onAddToFavoritesButtonClicked,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(
    modifier: Modifier = Modifier,
    onToolbarStarIconClicked: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(id = R.string.home_toolbar_title_text),
            )
        },
        actions = {
            ToolbarIcon(
                imageVector = Icons.Filled.Star,
                onIconClicked = onToolbarStarIconClicked,
            )
        },
    )
}

@Composable
private fun ToolbarIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    onIconClicked: () -> Unit,
) {
    IconButton(
        onClick = onIconClicked,
    ) {
        Icon(
            modifier = modifier.size(16.dp),
            imageVector = imageVector,
            contentDescription = null,
        )
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    isLoadingVisible: Boolean,
    isErrorVisible: Boolean,
    imageUrl: String?,
    isLoadNewButtonEnabled: Boolean,
    isAddToFavoritesButtonEnabled: Boolean,
    onLoadNewButtonClicked: () -> Unit,
    onAddToFavoritesButtonClicked: () -> Unit,
) {
    Column(
        modifier = modifier,
    ) {
        ImageSection(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(300.dp),
            isLoadingVisible = isLoadingVisible,
            isErrorVisible = isErrorVisible,
            imageUrl = imageUrl,
        )

        Spacer(
            modifier = Modifier.height(DSSpacing.small),
        )

        Spacer(
            modifier = Modifier.weight(1F),
        )

        ButtonSection(
            modifier = Modifier.fillMaxWidth(),
            isLoadNewButtonEnabled = isLoadNewButtonEnabled,
            isAddToFavoritesButtonEnabled = isAddToFavoritesButtonEnabled,
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
    AsyncImage(
        modifier = modifier,
        model = url,
        contentDescription = null,
    )
}

@Composable
private fun ButtonSection(
    modifier: Modifier = Modifier,
    isLoadNewButtonEnabled: Boolean,
    isAddToFavoritesButtonEnabled: Boolean,
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
            isEnabled = isLoadNewButtonEnabled,
            onButtonClicked = onLoadNewButtonClicked,
        )

        DSButton(
            modifier = Modifier.weight(1F),
            text = stringResource(id = R.string.home_add_to_favorites_button_text),
            isEnabled = isAddToFavoritesButtonEnabled,
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
                isLoadNewButtonEnabled = false,
                isAddToFavoritesButtonEnabled = false,
            ),
            // Error.
            HomeViewState(
                isLoadingVisible = false,
                isErrorVisible = true,
                imageUrl = null,
                isLoadNewButtonEnabled = true,
                isAddToFavoritesButtonEnabled = false,
            ),
            // Success.
            HomeViewState(
                isLoadingVisible = false,
                isErrorVisible = false,
                imageUrl = "example.com",
                isLoadNewButtonEnabled = true,
                isAddToFavoritesButtonEnabled = true,
            ),
        )
}

@Preview
@Composable
private fun HomeViewPreview(
    @PreviewParameter(HomeViewPreviewProvider::class) viewState: HomeViewState,
) {
    CoilPreviewScope(
        colorPreviewMap =
            mapOf(
                "example.com" to Color.Blue.toArgb(),
            ),
    ) {
        CoffeePicturesPreview {
            HomeView(
                modifier = Modifier.fillMaxSize(),
                viewState = viewState,
                onToolbarStarIconClicked = {},
                onLoadNewButtonClicked = {},
                onAddToFavoritesButtonClicked = {},
            )
        }
    }
}
