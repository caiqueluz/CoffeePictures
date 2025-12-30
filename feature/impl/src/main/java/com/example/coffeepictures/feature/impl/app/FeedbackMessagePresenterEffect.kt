package com.example.coffeepictures.feature.impl.app

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import com.example.coffeepictures.common.ui.api.FeedbackMessagePresenter
import com.example.coffeepictures.feature.impl.R
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun FeedbackMessagePresenterEffect(
    snackbarHostState: SnackbarHostState,
    presenter: FeedbackMessagePresenter,
    getTextValue: (Int) -> String,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val dismissActionText = stringResource(id = R.string.feedback_message_presenter_snackbar_dismiss_action_text)

    LaunchedEffect(key1 = Unit) {
        presenter
            .channel
            .receiveAsFlow()
            .flowWithLifecycle(
                lifecycle = lifecycleOwner.lifecycle,
                minActiveState = Lifecycle.State.RESUMED,
            )
            .collect { textResId ->
                snackbarHostState.showSnackbar(
                    message = getTextValue(textResId),
                    actionLabel = dismissActionText,
                    duration = SnackbarDuration.Short,
                )
            }
    }
}
