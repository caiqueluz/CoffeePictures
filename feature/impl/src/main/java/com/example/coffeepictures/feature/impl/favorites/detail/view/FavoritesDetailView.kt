package com.example.coffeepictures.feature.impl.favorites.detail.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.coffeepictures.designsystem.CoffeePicturesPreview
import com.example.coffeepictures.designsystem.CoilPreviewScope
import com.example.coffeepictures.designsystem.component.DSErrorMessageAlert
import com.example.coffeepictures.designsystem.component.DSIconButton
import com.example.coffeepictures.designsystem.component.DSLoading
import com.example.coffeepictures.designsystem.core.DSSpacing
import com.example.coffeepictures.feature.impl.R
import com.example.coffeepictures.feature.impl.favorites.detail.logic.FavoritesDetailViewState

@Composable
fun FavoritesDetailView(
    modifier: Modifier = Modifier,
    viewState: FavoritesDetailViewState,
    onToolbarBackIconClicked: () -> Unit,
    onToolbarDeleteIconClicked: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            Toolbar(
                isToolbarDeleteIconVisible = viewState.isToolbarDeleteIconVisible,
                onToolbarBackIconClicked = onToolbarBackIconClicked,
                onToolbarDeleteIconClicked = onToolbarDeleteIconClicked,
            )
        },
    ) { innerPadding ->
        Content(
            modifier = Modifier.padding(innerPadding),
            isLoadingVisible = viewState.isLoadingVisible,
            isErrorVisible = viewState.isErrorVisible,
            imageModel = viewState.imageUrlText,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(
    modifier: Modifier = Modifier,
    isToolbarDeleteIconVisible: Boolean,
    onToolbarBackIconClicked: () -> Unit,
    onToolbarDeleteIconClicked: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(id = R.string.favorites_detail_toolbar_title_text),
            )
        },
        navigationIcon = {
            DSIconButton(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                onIconClicked = onToolbarBackIconClicked,
            )
        },
        actions = {
            if (isToolbarDeleteIconVisible) {
                DSIconButton(
                    imageVector = Icons.Filled.Delete,
                    onIconClicked = onToolbarDeleteIconClicked,
                )
            }
        },
    )
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    isLoadingVisible: Boolean,
    isErrorVisible: Boolean,
    imageModel: String?,
) {
    Box(
        modifier = modifier.padding(all = DSSpacing.medium),
    ) {
        if (isLoadingVisible) {
            LoadingItem(
                modifier = Modifier.fillMaxSize(),
            )
        }

        if (isErrorVisible) {
            DSErrorMessageAlert(
                modifier = Modifier.fillMaxSize(),
                text = stringResource(id = R.string.favorites_detail_error_text),
            )
        }

        imageModel?.let { model ->
            ImageItem(
                urlText = model,
            )
        }
    }
}

@Composable
private fun LoadingItem(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        DSLoading(
            modifier =
                Modifier
                    .width(64.dp)
                    .height(16.dp),
        )

        Spacer(
            modifier = Modifier.height(DSSpacing.small),
        )

        DSLoading(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(300.dp),
        )

        Spacer(
            modifier = Modifier.height(DSSpacing.medium),
        )

        DSLoading(
            modifier =
                Modifier
                    .width(80.dp)
                    .height(16.dp),
        )

        Spacer(
            modifier = Modifier.height(DSSpacing.small),
        )

        DSLoading(
            modifier =
                Modifier
                    .width(128.dp)
                    .height(16.dp),
        )
    }
}

@Composable
private fun ImageItem(
    modifier: Modifier = Modifier,
    urlText: String,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(DSSpacing.medium),
    ) {
        AsyncImage(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(300.dp),
            model = urlText,
            contentDescription = null,
        )

        ImageUrlTextItem(
            titleText = urlText,
        )
    }
}

@Composable
private fun ImageUrlTextItem(
    modifier: Modifier = Modifier,
    titleText: String,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(DSSpacing.small),
    ) {
        Text(
            text = stringResource(id = R.string.favorites_detail_image_url_label_text),
        )

        Text(
            text = titleText,
        )
    }
}

private class FavoritesDetailViewPreviewProvider : PreviewParameterProvider<FavoritesDetailViewState> {
    override val values: Sequence<FavoritesDetailViewState> =
        sequenceOf(
            // Loading.
            FavoritesDetailViewState(
                isToolbarDeleteIconVisible = false,
                isLoadingVisible = true,
                isErrorVisible = false,
                imageUrlText = null,
            ),
            // Error.
            FavoritesDetailViewState(
                isToolbarDeleteIconVisible = false,
                isLoadingVisible = false,
                isErrorVisible = true,
                imageUrlText = null,
            ),
            // Success.
            FavoritesDetailViewState(
                isToolbarDeleteIconVisible = true,
                isLoadingVisible = false,
                isErrorVisible = false,
                imageUrlText = "example.com/1.png",
            ),
        )
}

@Preview
@Composable
private fun FavoritesDetailViewPreview(@PreviewParameter(FavoritesDetailViewPreviewProvider ::class) viewState: FavoritesDetailViewState) {
    CoilPreviewScope(
        colorPreviewMap =
            mapOf(
                "example.com/1.png" to Color.Red.toArgb(),
            ),
    ) {
        CoffeePicturesPreview {
            FavoritesDetailView(
                viewState = viewState,
                onToolbarBackIconClicked = {},
                onToolbarDeleteIconClicked = {},
            )
        }
    }
}
