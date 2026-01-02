package com.example.coffeepictures.designsystem.component.toolbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.coffeepictures.designsystem.CoffeePicturesPreview
import com.example.coffeepictures.designsystem.component.DSIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DSToolbar(
    modifier: Modifier = Modifier,
    titleText: String,
    navigationIcon: DSToolbarNavigationIcon?,
    actionIcons: Set<DSToolbarIcon.Model>,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = titleText,
            )
        },
        navigationIcon = {
            navigationIcon?.let { model ->
                DSIconButton(
                    imageVector = model.imageVector,
                    onIconClicked = model.onIconClicked,
                )
            }
        },
        actions = {
            actionIcons.forEach { model ->
                DSIconButton(
                    imageVector = model.imageVector,
                    onIconClicked = model.onIconClicked,
                )
            }
        },
    )
}

private data class PreviewModel(
    val titleText: String,
    val navigationIcon: DSToolbarNavigationIcon,
    val actionIcons: Set<DSToolbarIcon.Model>,
)

private class DSToolbarPreviewProvider : PreviewParameterProvider<PreviewModel> {
    override val values: Sequence<PreviewModel> =
        sequenceOf(
            // Back navigation icon, with actions.
            PreviewModel(
                titleText = "Title text",
                navigationIcon = DSToolbarNavigationIcon.Back(onIconClicked = {}),
                actionIcons =
                    setOf(
                        DSToolbarIcon.Model(
                            imageVector = Icons.Filled.Delete,
                            onIconClicked = {},
                        ),
                    ),
            ),
            // Back navigation icon, without actions.
            PreviewModel(
                titleText = "Title text",
                navigationIcon = DSToolbarNavigationIcon.Back(onIconClicked = {}),
                actionIcons = emptySet(),
            ),
        )
}

@Preview
@Composable
private fun DSToolbarPreview(@PreviewParameter(DSToolbarPreviewProvider::class) previewModel: PreviewModel) {
    CoffeePicturesPreview {
        DSToolbar(
            titleText = previewModel.titleText,
            navigationIcon = previewModel.navigationIcon,
            actionIcons = previewModel.actionIcons,
        )
    }
}
