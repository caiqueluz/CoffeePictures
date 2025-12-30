package com.example.coffeepictures.feature.impl.home.logic

data class HomeViewState(
    val isLoadingVisible: Boolean,
    val isErrorVisible: Boolean,
    val imageUrl: String?,
    val isLoadNewButtonEnabled: Boolean,
    val isAddToFavoritesButtonEnabled: Boolean,
)
