package com.example.coffeepictures.apptoolbar.presentation.logic

import com.example.coffeepictures.navigator.AppScreenModel
import com.example.coffeepictures.navigator.AppScreenModel.Home
import com.example.coffeepictures.navigator.AppScreenModel.Favorites

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
