package com.example.coffeepictures.feature.impl.favorites.list.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.example.coffeepictures.feature.impl.favorites.list.logic.FavoritesListViewState

@Composable
fun FavoritesListView(
    modifier: Modifier = Modifier,
    viewState: FavoritesListViewState,
    onToolbarBackIconClicked: () -> Unit,
    onToolbarDeleteIconClicked: () -> Unit,
    onItemClicked: (Int) -> Unit,
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
            imageUrls = viewState.imageUrls,
            onItemClicked = onItemClicked,
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
                text = stringResource(id = R.string.favorites_list_toolbar_title_text),
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
    imageUrls: List<String>,
    onItemClicked: (Int) -> Unit,
) {
    Box(
        modifier = modifier.padding(all = DSSpacing.medium),
    ) {
        if (isLoadingVisible) {
            LoadingList(
                modifier = Modifier.fillMaxSize(),
            )
        }

        if (isErrorVisible) {
            DSErrorMessageAlert(
                modifier = Modifier.fillMaxSize(),
                text = stringResource(id = R.string.favorites_list_error_text),
            )
        }

        List(
            modifier = Modifier.fillMaxSize(),
            imageUrls = imageUrls,
            onItemClicked = onItemClicked,
        )
    }
}

@Composable
private fun LoadingList(
    modifier: Modifier = Modifier,
    size: Int = 3,
) {
    Column(
        modifier = modifier,
    ) {
        repeat(times = size) { index ->
            LoadingItem()

            if (index < size.dec()) {
                Spacer(
                    modifier = Modifier.height(DSSpacing.medium),
                )
            }
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
    }
}

@Composable
private fun List(
    modifier: Modifier = Modifier,
    imageUrls: List<String>,
    onItemClicked: (Int) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        itemsIndexed(imageUrls) { index, url ->
            FavoriteImageItem(
                modifier =
                    Modifier.clickable {
                        onItemClicked(index)
                    },
                url = url,
            )

            if (index < imageUrls.size.dec()) {
                Spacer(
                    modifier = Modifier.height(DSSpacing.medium),
                )
            }
        }
    }
}

@Composable
private fun FavoriteImageItem(
    modifier: Modifier = Modifier,
    url: String,
) {
    AsyncImage(
        modifier =
            modifier
                .fillMaxWidth()
                .height(300.dp),
        model = url,
        contentDescription = null,
    )
}

private class FavoritesListViewPreviewProvider : PreviewParameterProvider<FavoritesListViewState> {
    override val values: Sequence<FavoritesListViewState> =
        sequenceOf(
            // Loading.
            FavoritesListViewState(
                isToolbarDeleteIconVisible = false,
                isLoadingVisible = true,
                isErrorVisible = false,
                imageUrls = emptyList(),
            ),
            // Error.
            FavoritesListViewState(
                isToolbarDeleteIconVisible = false,
                isLoadingVisible = false,
                isErrorVisible = true,
                imageUrls = emptyList(),
            ),
            // Success.
            FavoritesListViewState(
                isToolbarDeleteIconVisible = true,
                isLoadingVisible = false,
                isErrorVisible = false,
                imageUrls =
                    listOf(
                        "example.com/1.png",
                        "example.com/2.png",
                        "example.com/3.png",
                    ),
            ),
        )
}

@Preview
@Composable
private fun FavoritesListViewPreview(@PreviewParameter(FavoritesListViewPreviewProvider::class) viewState: FavoritesListViewState) {
    CoilPreviewScope(
        colorPreviewMap =
            mapOf(
                "example.com/1.png" to Color.Red.toArgb(),
                "example.com/2.png" to Color.Green.toArgb(),
                "example.com/3.png" to Color.Blue.toArgb(),
            ),
    ) {
        CoffeePicturesPreview {
            FavoritesListView(
                modifier = Modifier.fillMaxSize(),
                viewState = viewState,
                onToolbarBackIconClicked = {},
                onToolbarDeleteIconClicked = {},
                onItemClicked = {},
            )
        }
    }
}
