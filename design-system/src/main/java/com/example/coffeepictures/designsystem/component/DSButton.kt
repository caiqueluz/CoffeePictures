package com.example.coffeepictures.designsystem.component

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.coffeepictures.designsystem.CoffeePicturesPreview

@Composable
fun DSButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean,
    onButtonClicked: () -> Unit,
) {
    Button(
        modifier = modifier,
        enabled = isEnabled,
        onClick = onButtonClicked,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
        )
    }
}

private data class PreviewModel(
    val text: String,
    val isEnabled: Boolean,
)

private class DSButtonPreviewProvider : PreviewParameterProvider<PreviewModel> {
    override val values: Sequence<PreviewModel> =
        sequenceOf(
            PreviewModel(
                text = "DS Button enabled",
                isEnabled = true,
            ),
            PreviewModel(
                text = "DS Button disabled",
                isEnabled = false,
            ),
        )
}

@Preview
@Composable
private fun DSButtonPreview(@PreviewParameter(DSButtonPreviewProvider::class) previewModel: PreviewModel) {
    CoffeePicturesPreview {
        DSButton(
            text = previewModel.text,
            isEnabled = previewModel.isEnabled,
            onButtonClicked = {},
        )
    }
}
