package com.example.coffeepictures.feature.impl.favorites.list.logic

data class FavoritesListViewState(
    val isToolbarDeleteIconVisible: Boolean,
    val isLoadingVisible: Boolean,
    val isErrorVisible: Boolean,
    val imageUrls: List<String>,
)
