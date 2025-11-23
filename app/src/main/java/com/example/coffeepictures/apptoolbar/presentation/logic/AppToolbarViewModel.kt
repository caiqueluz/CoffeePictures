package com.example.coffeepictures.apptoolbar.presentation.logic

import androidx.lifecycle.viewModelScope
import com.example.coffeepictures.R
import com.example.coffeepictures.app.presentation.AppScreenModel
import com.example.coffeepictures.app.presentation.AppScreenModel.Favorites
import com.example.coffeepictures.app.presentation.AppScreenModel.Home
import com.example.coffeepictures.core.BasicViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppToolbarViewModel(
    private val appScreenFlow: StateFlow<AppScreenModel>,
) : BasicViewModel<AppToolbarViewState>() {
    private var appScreenModel: AppScreenModel? = null

    init {
        viewModelScope.launch {
            appScreenFlow.collect {
                appScreenModel = it
            }
        }
    }

    override fun createViewState(): AppToolbarViewState {
        val titleTextResId =
            when (appScreenModel) {
                is Home -> R.string.home_toolbar_title_text
                is Favorites -> R.string.favorites_toolbar_title_text
                else -> null
            }

        return AppToolbarViewState(
            titleTextResId = titleTextResId,
            actionModels = AppToolbarActionModel.entries,
        )
    }

    fun onToolbarActionIconClicked(index: Int) {
        val model = AppToolbarActionModel.entries[index]

        when (model) {
            AppToolbarActionModel.FAVORITES -> {
                // TODO - show favorites screen.
            }
        }
    }
}
