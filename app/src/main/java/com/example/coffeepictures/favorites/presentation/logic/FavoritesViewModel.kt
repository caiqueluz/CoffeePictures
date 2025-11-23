package com.example.coffeepictures.favorites.presentation.logic

import com.example.coffeepictures.app.navigator.AppScreenNavigator
import com.example.coffeepictures.core.BasicViewModel
import com.example.coffeepictures.home.domain.RandomImageModel

class FavoritesViewModel(
    private val appScreenNavigator: AppScreenNavigator,
) : BasicViewModel<FavoritesViewState>() {
    private var randomImageModels = listOf<RandomImageModel>()
    private var errorThrowable: Throwable? = null

    override fun createViewState(): FavoritesViewState {
        val imageModels =
            if (randomImageModels.isNotEmpty() && errorThrowable == null) {
                randomImageModels.map { model ->
                    createFavoriteImageModel(
                        randomImageModel = model
                    )
                }
            } else {
                emptyList()
            }

        return FavoritesViewState(
            isLoadingVisible = randomImageModels.isEmpty() && errorThrowable == null,
            isErrorVisible = randomImageModels.isEmpty() && errorThrowable != null,
            imageModels = imageModels,
        )
    }

    fun onBackButtonClicked() {
        appScreenNavigator.navigateBackToHome()
    }

    private fun createFavoriteImageModel(randomImageModel: RandomImageModel): FavoriteImageModel {
        return FavoriteImageModel(
            /**
             * Use the model url as both the title text and the url,
             * but don't expose this logic to the view.
             */
            titleText = randomImageModel.url,
            url = randomImageModel.url,
        )
    }
}
