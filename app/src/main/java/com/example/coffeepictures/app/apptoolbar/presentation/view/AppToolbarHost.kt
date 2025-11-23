package com.example.coffeepictures.app.apptoolbar.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coffeepictures.app.app.presentation.AppScreenModel
import com.example.coffeepictures.app.apptoolbar.presentation.logic.AppToolbarViewModel
import kotlinx.coroutines.flow.StateFlow
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun AppToolbarHost(
    modifier: Modifier = Modifier,
    appScreenFlow: StateFlow<AppScreenModel>,
) {
    val viewModel =
        koinViewModel<AppToolbarViewModel> {
            parametersOf(appScreenFlow)
        }

    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    AppToolbarView(
        modifier = modifier,
        viewState = viewState,
        onToolbarIconClicked = viewModel::onToolbarActionIconClicked,
    )
}
