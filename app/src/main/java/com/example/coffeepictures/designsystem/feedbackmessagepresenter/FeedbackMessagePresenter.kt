package com.example.coffeepictures.designsystem.feedbackmessagepresenter

import androidx.annotation.StringRes

interface FeedbackMessagePresenter {
    fun show(@StringRes textResId: Int)
}
