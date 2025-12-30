package com.example.coffeepictures.feature.impl.favorites.navigator

import kotlinx.coroutines.flow.StateFlow

// TODO - replace with Navigation3.
interface FavoritesScreenNavigator {
    val favoritesScreenFlow: StateFlow<FavoritesScreenModel>

    fun navigateToDetail(imageUrl: String)

    fun navigateBackToList()
}
