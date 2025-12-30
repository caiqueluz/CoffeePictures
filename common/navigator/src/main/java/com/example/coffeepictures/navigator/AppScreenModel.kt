package com.example.coffeepictures.navigator

sealed interface AppScreenModel {
    data object Home : AppScreenModel

    data object Favorites : AppScreenModel
}
