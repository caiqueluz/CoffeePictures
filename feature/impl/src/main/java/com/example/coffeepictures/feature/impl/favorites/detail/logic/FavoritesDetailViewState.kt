package com.example.coffeepictures.feature.impl.favorites.detail.logic

data class FavoritesDetailViewState(
    val isToolbarDeleteIconVisible: Boolean,
    val isLoadingVisible: Boolean,
    val isErrorVisible: Boolean,
    val imageUrlText: String?,
)
