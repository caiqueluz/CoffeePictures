package com.example.coffeepictures.app.navigator

import com.example.coffeepictures.app.app.presentation.AppScreenModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppScreenNavigatorImpl(
    private val coroutineScope: CoroutineScope,
) : AppScreenNavigator {
    private val mutableAppScreenFlow = MutableStateFlow<AppScreenModel>(value = AppScreenModel.Home)
    override val appScreenFlow = mutableAppScreenFlow.asStateFlow()

    override fun navigateToFavorites() {
        navigateTo(model = AppScreenModel.Favorites)
    }

    override fun navigateBackToHome() {
        navigateTo(model = AppScreenModel.Home)
    }

    private fun navigateTo(model: AppScreenModel) {
        coroutineScope.launch {
            mutableAppScreenFlow.emit(model)
        }
    }
}
