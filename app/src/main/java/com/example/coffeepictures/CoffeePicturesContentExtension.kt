package com.example.coffeepictures

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.coffeepictures.designsystem.CoffeePicturesTheme

fun ComponentActivity.setCoffeePicturesContent(
    content: @Composable () -> Unit,
) {
    setContent {
        CoffeePicturesTheme(
            content = content,
        )
    }
}
