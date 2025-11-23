package com.example.coffeepictures.app.app.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.coffeepictures.app.apptoolbar.presentation.view.AppToolbarHost
import com.example.coffeepictures.home.presentation.view.HomeHost
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHost(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
) {
    val appScreenFlow =
        remember {
            MutableStateFlow<AppScreenModel>(value = AppScreenModel.Home)
        }

    Scaffold(
        modifier = modifier,
        topBar = {
            AppToolbarHost(
                appScreenFlow = appScreenFlow,
            )
        },
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
            )
        },
    ) {
        HomeHost()
    }
}
