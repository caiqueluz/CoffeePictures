package com.example.coffeepictures.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coffeepictures.designsystem.core.CoffeePicturesTheme

@Composable
fun CoffeePicturesPreview(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    CoffeePicturesTheme {
        Box(
            modifier = modifier.background(color = MaterialTheme.colorScheme.background),
            content = content,
        )
    }
}
