package com.example.coffeepictures.app.presentation

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coffeepictures.home.presentation.view.HomeHost

@Composable
fun AppHost(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
    ) {
        HomeHost()
    }
}
