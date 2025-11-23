package com.example.coffeepictures

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeepictures.designsystem.CoffeePicturesPreview

@Composable
fun App(
    modifier: Modifier = Modifier,
    name: String,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = name,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AppPreview() {
    CoffeePicturesPreview {
        App(
            modifier = Modifier.fillMaxSize(),
            name = "Android",
        )
    }
}
