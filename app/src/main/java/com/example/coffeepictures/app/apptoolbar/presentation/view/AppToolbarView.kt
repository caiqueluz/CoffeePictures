package com.example.coffeepictures.app.apptoolbar.presentation.view

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.coffeepictures.R
import com.example.coffeepictures.app.apptoolbar.presentation.logic.AppToolbarActionModel
import com.example.coffeepictures.app.apptoolbar.presentation.logic.AppToolbarViewState
import com.example.coffeepictures.designsystem.CoffeePicturesPreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbarView(
    modifier: Modifier = Modifier,
    viewState: AppToolbarViewState,
    onToolbarIconClicked: (Int) -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(id = viewState.titleTextResId),
            )
        },
        actions = {
            viewState.actionModels.forEachIndexed { index, model ->
                ActionIcon(
                    model = model,
                    onIconClicked = {
                        onToolbarIconClicked(index)
                    },
                )
            }
        },
    )
}

@Composable
private fun ActionIcon(
    modifier: Modifier = Modifier,
    model: AppToolbarActionModel,
    onIconClicked: () -> Unit,
) {
    IconButton(
        onClick = onIconClicked,
    ) {
        val imageVector =
            when (model) {
                AppToolbarActionModel.FAVORITES -> Icons.Filled.Star
            }

        Icon(
            modifier = modifier.size(16.dp),
            imageVector = imageVector,
            contentDescription = null,
        )
    }
}

private class AppToolbarViewParameterProvider : PreviewParameterProvider<AppToolbarViewState> {
    override val values: Sequence<AppToolbarViewState> =
        sequenceOf(
            // Home.
            AppToolbarViewState(
                titleTextResId = R.string.home_toolbar_title_text,
                actionModels =
                    listOf(
                        AppToolbarActionModel.FAVORITES,
                    ),
            ),
            // Favorites.
            AppToolbarViewState(
                titleTextResId = R.string.favorites_toolbar_title_text,
                actionModels = emptyList(),
            ),
        )
}

@Preview
@Composable
private fun AppToolbarViewPreview(@PreviewParameter(AppToolbarViewParameterProvider::class) viewState: AppToolbarViewState) {
    CoffeePicturesPreview {
        AppToolbarView(
            viewState = viewState,
            onToolbarIconClicked = {},
        )
    }
}
