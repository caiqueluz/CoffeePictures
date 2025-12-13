package com.example.coffeepictures.commonui.impl

import androidx.annotation.StringRes
import com.example.coffeepictures.commonui.api.FeedbackMessagePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch

class FeedbackMessagePresenterImpl(
    private val coroutineScope: CoroutineScope,
) : FeedbackMessagePresenter {
    private val mutableChannel = Channel<Int>()
    val channel: ReceiveChannel<Int> = mutableChannel

    override fun show(@StringRes textResId: Int) {
        coroutineScope.launch {
            mutableChannel.send(textResId)
        }
    }
}
