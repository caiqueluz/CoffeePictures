package com.example.coffeepictures.feature.impl.favorites.navigator

import com.example.coffeepictures.feature.impl.favorites.navigator.FavoritesScreenModel.Detail
import com.example.coffeepictures.feature.impl.favorites.navigator.FavoritesScreenModel.List
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FavoritesScreenNavigatorImpl : FavoritesScreenNavigator {
    private val mutableFavoritesScreenFlow = MutableStateFlow<FavoritesScreenModel>(value = List)
    override val favoritesScreenFlow = mutableFavoritesScreenFlow.asStateFlow()

    override fun navigateToDetail(imageUrl: String) {
        val model = Detail(imageUrl)
        navigateTo(model)
    }

    override fun navigateBackToList() {
        navigateTo(model = List)
    }

    private fun navigateTo(model: FavoritesScreenModel) {
        mutableFavoritesScreenFlow.update {
            model
        }
    }
}
