package com.example.coffeepictures.feature.impl.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coffeepictures.feature.api.HomeEntrypoint
import com.example.coffeepictures.feature.impl.home.view.HomeHost

class HomeEntrypointImpl : HomeEntrypoint {
    @Composable
    override fun Content(modifier: Modifier) {
        HomeHost(
            modifier = modifier,
        )
    }
}
