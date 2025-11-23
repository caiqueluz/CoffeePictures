package com.example.coffeepictures.favorites.presentation.logic

data class FavoritesViewState(
    val isLoadingVisible: Boolean,
    val isErrorVisible: Boolean,
    val imageModels: List<FavoriteImageModel>,
)
