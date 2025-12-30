package com.example.coffeepictures.feature.impl.favorites.navigator

sealed interface FavoritesScreenModel {
    data object List : FavoritesScreenModel

    data class Detail(
        val imageUrl: String,
    ) : FavoritesScreenModel
}
