package com.example.coffeepictures.feature.impl.favorites.list.logic

data class FavoritesListViewState(
    val isLoadingVisible: Boolean,
    val isErrorVisible: Boolean,
    val imageModels: List<FavoriteImageModel>,
)
