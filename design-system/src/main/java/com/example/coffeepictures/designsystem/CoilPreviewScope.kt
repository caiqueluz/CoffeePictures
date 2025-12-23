@file:OptIn(ExperimentalCoilApi::class)

package com.example.coffeepictures.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import coil3.ColorImage
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.AsyncImagePreviewHandler
import coil3.compose.LocalAsyncImagePreviewHandler

@Composable
fun CoilPreviewScope(
    colorPreviewMap: Map<String, Int>,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalAsyncImagePreviewHandler provides createPreviewHandler(colorPreviewMap),
    ) {
        content()
    }
}

private fun createPreviewHandler(
    colorPreviewMap: Map<String, Int>,
): AsyncImagePreviewHandler {
    return AsyncImagePreviewHandler { imageRequest ->
        val url = imageRequest.data.toString()
        val color = colorPreviewMap[url]

        ColorImage(
            color = requireNotNull(color),
        )
    }
}
