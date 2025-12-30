package com.example.coffeepictures.apptoolbar.presentation.logic

import androidx.lifecycle.viewModelScope
import com.example.coffeepictures.R
import com.example.coffeepictures.app.app.presentation.AppScreenModel.Favorites
import com.example.coffeepictures.app.app.presentation.AppScreenModel.Home
import com.example.coffeepictures.core.navigator.AppScreenNavigator
import com.example.coffeepictures.core.navigator.currentModel
import com.example.coffeepictures.viewmodel.BasicViewModel
import kotlinx.coroutines.launch

class AppToolbarViewModel(
    private val appScreenNavigator: AppScreenNavigator,
) : BasicViewModel<AppToolbarViewState>() {
    private var actionModels = listOf<AppToolbarActionModel>()

    init {
        viewModelScope.launch {
            appScreenNavigator
                .appScreenFlow
                .collect {
                    val appScreenModel = appScreenNavigator.currentModel()
                    actionModels = AppToolbarActionModel.modelsOf(appScreenModel)

                    updateViewState()
                }
        }
    }

    override fun createViewState(): AppToolbarViewState {
        val appScreenModel = appScreenNavigator.currentModel()

        val titleTextResId =
            when (appScreenModel) {
                is Home -> R.string.home_toolbar_title_text
                is Favorites -> R.string.favorites_toolbar_title_text
            }

        return AppToolbarViewState(
            isBackIconVisible = appScreenModel is Favorites,
            titleTextResId = titleTextResId,
            actionModels = actionModels,
        )
    }

    fun onToolbarBackIconClicked() {
        appScreenNavigator.navigateBackToHome()
    }

    fun onToolbarActionIconClicked(index: Int) {
        val model = actionModels[index]

        when (model) {
            AppToolbarActionModel.FAVORITES -> {
                appScreenNavigator.navigateToFavorites()
            }
        }
    }
}
