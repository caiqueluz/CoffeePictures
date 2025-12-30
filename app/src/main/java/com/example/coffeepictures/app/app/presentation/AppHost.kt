package com.example.coffeepictures.app.app.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coffeepictures.app.app.FeedbackMessagePresenterEffect
import com.example.coffeepictures.app.app.rememberSnackbarHostState
import com.example.coffeepictures.common.ui.api.FeedbackMessagePresenter
import com.example.coffeepictures.feature.api.AppToolbarEntrypoint
import com.example.coffeepictures.feature.api.FavoritesEntrypoint
import com.example.coffeepictures.feature.api.HomeEntrypoint
import com.example.coffeepictures.navigator.AppScreenModel.Favorites
import com.example.coffeepictures.navigator.AppScreenModel.Home
import com.example.coffeepictures.navigator.rememberAppScreenNavigator
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHost(
    modifier: Modifier = Modifier,
    getTextValue: (Int) -> String,
) {
    val appScreenNavigator = rememberAppScreenNavigator(initialModel = Home)
    val snackbarHostState = rememberSnackbarHostState()
    val feedbackMessagePresenter = koinInject<FeedbackMessagePresenter>()
    val appToolbarEntrypoint = koinInject<AppToolbarEntrypoint>()
    val homeEntrypoint = koinInject<HomeEntrypoint>()
    val favoritesEntrypoint = koinInject<FavoritesEntrypoint>()

    FeedbackMessagePresenterEffect(
        presenter = feedbackMessagePresenter,
        snackbarHostState = snackbarHostState,
        getTextValue = getTextValue,
    )

    Scaffold(
        modifier = modifier,
        topBar = {
            appToolbarEntrypoint.Content(
                appScreenNavigator = appScreenNavigator,
            )
        },
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
            )
        },
    ) { innerPadding ->
        val appScreenModel by appScreenNavigator.appScreenFlow.collectAsStateWithLifecycle()

        Box(
            modifier = Modifier.padding(innerPadding),
        ) {
            when (appScreenModel) {
                is Home -> {
                    homeEntrypoint.Content(
                        modifier = modifier,
                    )
                }

                is Favorites -> {
                    favoritesEntrypoint.Content(
                        appScreenNavigator = appScreenNavigator,
                    )
                }
            }
        }
    }
}
