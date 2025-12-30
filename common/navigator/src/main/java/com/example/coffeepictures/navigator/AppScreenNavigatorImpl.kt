package com.example.coffeepictures.navigator

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppScreenNavigatorImpl(
    initialModel: AppScreenModel,
) : AppScreenNavigator {
    private val mutableAppScreenFlow = MutableStateFlow(value = initialModel)
    override val appScreenFlow = mutableAppScreenFlow.asStateFlow()

    override fun navigateToFavorites() {
        navigateTo(model = AppScreenModel.Favorites)
    }

    override fun navigateBackToHome() {
        navigateTo(model = AppScreenModel.Home)
    }

    private fun navigateTo(model: AppScreenModel) {
        mutableAppScreenFlow.update {
            model
        }
    }
}
