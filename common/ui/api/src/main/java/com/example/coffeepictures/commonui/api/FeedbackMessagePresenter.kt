package com.example.coffeepictures.common.ui.api

import androidx.annotation.StringRes
import kotlinx.coroutines.channels.ReceiveChannel

interface FeedbackMessagePresenter {
    val channel: ReceiveChannel<Int>

    fun show(@StringRes textResId: Int)
}
