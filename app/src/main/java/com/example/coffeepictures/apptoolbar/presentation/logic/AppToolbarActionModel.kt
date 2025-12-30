package com.example.coffeepictures.apptoolbar.presentation.logic

import com.example.coffeepictures.app.app.presentation.AppScreenModel
import com.example.coffeepictures.app.app.presentation.AppScreenModel.Favorites
import com.example.coffeepictures.app.app.presentation.AppScreenModel.Home

enum class AppToolbarActionModel {
    FAVORITES;

    companion object {
        fun modelsOf(appScreenModel: AppScreenModel): List<AppToolbarActionModel> {
            return when (appScreenModel) {
                is Home -> {
                    listOf(
                        FAVORITES,
                    )
                }

                is Favorites -> emptyList()
            }
        }
    }
}
