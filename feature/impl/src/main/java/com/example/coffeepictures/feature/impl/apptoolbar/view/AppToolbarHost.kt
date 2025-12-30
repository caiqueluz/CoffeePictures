package com.example.coffeepictures.feature.impl.apptoolbar.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coffeepictures.feature.impl.apptoolbar.logic.AppToolbarViewModel
import com.example.coffeepictures.navigator.AppScreenNavigator
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
