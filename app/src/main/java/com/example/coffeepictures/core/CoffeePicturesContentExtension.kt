package com.example.coffeepictures.core

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.coffeepictures.designsystem.core.CoffeePicturesTheme

fun ComponentActivity.setCoffeePicturesContent(
    content: @Composable () -> Unit,
) {
    setContent {
        CoffeePicturesTheme(
            content = content,
        )
    }
}
