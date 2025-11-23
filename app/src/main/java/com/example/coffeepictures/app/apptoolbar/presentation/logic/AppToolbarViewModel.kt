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
    private var appScreenModel: AppScreenModel? = null

    init {
        viewModelScope.launch {
            appScreenNavigator
                .appScreenFlow
                .collect {
                    appScreenModel = it
                    updateViewState()
                }
        }
    }

    override fun createViewState(): AppToolbarViewState {
        return when (appScreenModel) {
            is Home -> {
                AppToolbarViewState(
                    titleTextResId = R.string.home_toolbar_title_text,
                    actionModels =
                        listOf(
                            AppToolbarActionModel.FAVORITES,
                        ),
                )
            }

            is Favorites -> {
                AppToolbarViewState(
                    titleTextResId = R.string.favorites_toolbar_title_text,
                    actionModels = emptyList(),
                )
            }

            else -> {
                AppToolbarViewState(
                    titleTextResId = null,
                    actionModels = emptyList(),
                )
            }
        }
    }

    fun onToolbarActionIconClicked(index: Int) {
        val model = AppToolbarActionModel.entries[index]

        when (model) {
            AppToolbarActionModel.FAVORITES -> {
                appScreenNavigator.navigateToFavorites()
            }
        }
    }
}
