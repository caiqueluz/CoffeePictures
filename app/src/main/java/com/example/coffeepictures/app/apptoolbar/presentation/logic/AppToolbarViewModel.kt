package com.example.coffeepictures.app.apptoolbar.presentation.logic

import androidx.lifecycle.viewModelScope
import com.example.coffeepictures.R
import com.example.coffeepictures.app.app.presentation.AppScreenModel
import com.example.coffeepictures.app.app.presentation.AppScreenModel.Favorites
import com.example.coffeepictures.app.app.presentation.AppScreenModel.Home
import com.example.coffeepictures.app.navigator.AppScreenNavigator
import com.example.coffeepictures.core.BasicViewModel
import kotlinx.coroutines.launch

class AppToolbarViewModel(
    private val appScreenNavigator: AppScreenNavigator,
) : BasicViewModel<AppToolbarViewState>() {
    private var appScreenModel: AppScreenModel =
        appScreenNavigator
            .appScreenFlow
            .value

    private var actionModels = listOf<AppToolbarActionModel>()

    init {
        updateActionModels()
        updateViewState()

        viewModelScope.launch {
            appScreenNavigator
                .appScreenFlow
                .collect {
                    appScreenModel = it

                    updateActionModels()
                    updateViewState()
                }
        }
    }

    override fun createViewState(): AppToolbarViewState {
        val titleTextResId =
            when (appScreenModel) {
                is Home -> R.string.home_toolbar_title_text
                is Favorites -> R.string.favorites_toolbar_title_text
            }

        return AppToolbarViewState(
            titleTextResId = titleTextResId,
            actionModels = actionModels,
        )
    }

    fun onToolbarActionIconClicked(index: Int) {
        val model = actionModels[index]

        when (model) {
            AppToolbarActionModel.FAVORITES -> {
                appScreenNavigator.navigateToFavorites()
            }
        }
    }

    private fun updateActionModels() {
        actionModels =
            when (appScreenModel) {
                is Home -> {
                    listOf(
                        AppToolbarActionModel.FAVORITES,
                    )
                }

                is Favorites -> emptyList()
            }
    }
}
