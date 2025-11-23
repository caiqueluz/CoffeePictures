package com.example.coffeepictures.app.app.presentation

sealed interface AppScreenModel {
    data object Home : AppScreenModel

    data object Favorites : AppScreenModel
}
