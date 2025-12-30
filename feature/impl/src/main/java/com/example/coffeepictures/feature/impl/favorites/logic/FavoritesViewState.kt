package com.example.coffeepictures.feature.impl.favorites.logic

data class FavoritesViewState(
    val isLoadingVisible: Boolean,
    val isErrorVisible: Boolean,
    val imageModels: List<FavoriteImageModel>,
)
