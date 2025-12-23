package com.example.coffeepictures.common.ui.impl

import androidx.annotation.StringRes
import com.example.coffeepictures.common.ui.api.FeedbackMessagePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

class FeedbackMessagePresenterImpl(
    private val coroutineScope: CoroutineScope,
) : FeedbackMessagePresenter {
    private val mutableChannel = Channel<Int>()
    override val channel = mutableChannel

    override fun show(@StringRes textResId: Int) {
        coroutineScope.launch {
            mutableChannel.send(textResId)
        }
    }
}
