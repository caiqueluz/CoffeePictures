package com.example.coffeepictures.commonui.api

import androidx.annotation.StringRes

interface FeedbackMessagePresenter {
    fun show(@StringRes textResId: Int)
}
