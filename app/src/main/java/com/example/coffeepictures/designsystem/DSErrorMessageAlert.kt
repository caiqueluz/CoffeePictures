package com.example.coffeepictures.designsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DSErrorMessageAlert(
    modifier: Modifier = Modifier,
    text: String,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Content(
            text = text,
        )
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    text: String,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(DSSpacing.small),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier.size(48.dp),
            imageVector = Icons.Filled.Warning,
            contentDescription = null,
        )

        Text(
            text = text,
        )
    }
}

@Preview
@Composable
private fun DSErrorMessageAlertPreview() {
    CoffeePicturesPreview {
        DSErrorMessageAlert(
            text = "DS Error Message Alert",
        )
    }
}
