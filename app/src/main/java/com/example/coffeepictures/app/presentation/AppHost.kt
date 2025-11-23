package com.example.coffeepictures.app.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coffeepictures.home.presentation.view.HomeHost

@Composable
fun AppHost(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
) {
    Scaffold(
        modifier = modifier,
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
            )
        },
    ) {
        HomeHost()
    }
}
