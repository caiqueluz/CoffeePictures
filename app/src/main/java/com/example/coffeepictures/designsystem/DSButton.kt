package com.example.coffeepictures.designsystem

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DSButton(
    modifier: Modifier = Modifier,
    text: String,
    onButtonClicked: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onButtonClicked,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
        )
    }
}

@Preview
@Composable
private fun DSButtonPreview() {
    CoffeePicturesPreview {
        DSButton(
            text = "DS Button",
            onButtonClicked = {},
        )
    }
}
