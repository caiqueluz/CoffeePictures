package com.example.coffeepictures.designsystem.feedbackmessagepresenter

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import com.example.coffeepictures.R
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun rememberFeedbackMessagePresenter(
    state: SnackbarHostState,
    getTextValue: (Int) -> String
): FeedbackMessagePresenter {
    val lifecycleOwner = LocalLifecycleOwner.current
    val coroutineScope = rememberCoroutineScope()
    val dismissActionText = stringResource(id = R.string.feedback_message_presenter_snackbar_dismiss_action_text)

    val presenter =
        remember {
            FeedbackMessagePresenterImpl(
                coroutineScope = coroutineScope,
            )
        }

    LaunchedEffect(key1 = Unit) {
        presenter.channel
            .receiveAsFlow()
            .flowWithLifecycle(
                lifecycle = lifecycleOwner.lifecycle,
                minActiveState = Lifecycle.State.RESUMED,
            )
            .collect { textResId ->
                state.showSnackbar(
                    message = getTextValue(textResId),
                    actionLabel = dismissActionText,
                    duration = SnackbarDuration.Short,
                )
            }
    }

    return presenter
}
