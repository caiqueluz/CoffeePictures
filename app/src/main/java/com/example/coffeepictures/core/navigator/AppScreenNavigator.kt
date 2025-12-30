package com.example.coffeepictures.core.navigator

import com.example.coffeepictures.app.app.presentation.AppScreenModel
import kotlinx.coroutines.flow.StateFlow

interface AppScreenNavigator {
    val appScreenFlow: StateFlow<AppScreenModel>

    fun navigateToFavorites()

    fun navigateBackToHome()
}
