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
import com.example.coffeepictures.app.app.presentation.AppScreenModel.Favorites
import com.example.coffeepictures.app.app.presentation.AppScreenModel.Home
import com.example.coffeepictures.app.app.rememberSnackbarHostState
import com.example.coffeepictures.app.apptoolbar.presentation.view.AppToolbarHost
import com.example.coffeepictures.app.navigator.rememberAppScreenNavigator
import com.example.coffeepictures.common.ui.api.FeedbackMessagePresenter
import com.example.coffeepictures.favorites.presentation.view.FavoritesHost
import com.example.coffeepictures.home.presentation.view.HomeHost
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

    FeedbackMessagePresenterEffect(
        presenter = feedbackMessagePresenter,
        snackbarHostState = snackbarHostState,
        getTextValue = getTextValue,
    )

    Scaffold(
        modifier = modifier,
        topBar = {
            AppToolbarHost(
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
                    HomeHost()
                }

                is Favorites -> {
                    FavoritesHost(
                        appScreenNavigator = appScreenNavigator,
                    )
                }
            }
        }
    }
}
