package com.example.coffeepictures.favorites.presentation.logic

import androidx.lifecycle.viewModelScope
import com.example.coffeepictures.app.navigator.AppScreenNavigator
import com.example.coffeepictures.applogic.api.LoadAllFavoriteImagesTask
import com.example.coffeepictures.applogic.api.RandomImageModel
import com.example.coffeepictures.viewmodel.BasicViewModel
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val loadAllFavoriteImagesTask: LoadAllFavoriteImagesTask,
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

    fun onFavoritesStarted() {
        loadAllFavoriteImages()
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

    private fun loadAllFavoriteImages() {
        randomImageModels = emptyList()
        errorThrowable = null

        updateViewState()

        viewModelScope.launch {
            loadAllFavoriteImagesTask.load()
                .onSuccess { randomImageModels = it }
                .onFailure { errorThrowable = it }

            updateViewState()
        }
    }
}
