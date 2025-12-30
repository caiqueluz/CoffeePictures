package com.example.coffeepictures.designsystem.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeepictures.designsystem.CoffeePicturesPreview

@Composable
fun DSIconButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    onIconClicked: () -> Unit,
) {
    IconButton(
        modifier = modifier,
        onClick = onIconClicked,
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            imageVector = imageVector,
            contentDescription = null,
        )
    }
}

@Preview
@Composable
private fun DSIconButtonPreview() {
    CoffeePicturesPreview {
        DSIconButton(
            imageVector = Icons.Filled.Delete,
            onIconClicked = {},
        )
    }
}
