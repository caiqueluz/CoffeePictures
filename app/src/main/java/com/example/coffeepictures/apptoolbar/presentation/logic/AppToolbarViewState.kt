package com.example.coffeepictures.apptoolbar.presentation.logic

import androidx.annotation.StringRes

data class AppToolbarViewState(
    @param:StringRes val titleTextResId: Int?,
    val actionModels: List<AppToolbarActionModel>,
)
