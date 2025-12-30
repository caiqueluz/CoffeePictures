package com.example.coffeepictures.apptoolbar.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coffeepictures.apptoolbar.presentation.logic.AppToolbarViewModel
import com.example.coffeepictures.app.navigator.AppScreenNavigator
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun AppToolbarHost(
    modifier: Modifier = Modifier,
    appScreenNavigator: AppScreenNavigator,
) {
    val viewModel =
        koinViewModel<AppToolbarViewModel> {
            parametersOf(appScreenNavigator)
        }

    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    AppToolbarView(
        modifier = modifier,
        viewState = viewState,
        onToolbarBackIconClicked = viewModel::onToolbarBackIconClicked,
        onToolbarActionIconClicked = viewModel::onToolbarActionIconClicked,
    )
}
