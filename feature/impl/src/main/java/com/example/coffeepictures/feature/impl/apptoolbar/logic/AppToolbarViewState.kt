package com.example.coffeepictures.feature.impl.apptoolbar.logic

import androidx.annotation.StringRes

data class AppToolbarViewState(
    val isBackIconVisible: Boolean,
    @param:StringRes val titleTextResId: Int,
    val actionModels: List<AppToolbarActionModel>,
)
