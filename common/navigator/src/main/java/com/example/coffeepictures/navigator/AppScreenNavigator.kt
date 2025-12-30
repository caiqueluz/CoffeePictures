package com.example.coffeepictures.navigator

import kotlinx.coroutines.flow.StateFlow

interface AppScreenNavigator {
    val appScreenFlow: StateFlow<AppScreenModel>

    fun navigateToFavorites()

    fun navigateBackToHome()
}
