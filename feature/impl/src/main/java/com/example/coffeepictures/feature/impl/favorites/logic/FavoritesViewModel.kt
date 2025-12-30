package com.example.coffeepictures.feature.impl.favorites.logic

import androidx.lifecycle.viewModelScope
import com.example.coffeepictures.applogic.api.LoadAllFavoriteImagesTask
import com.example.coffeepictures.applogic.api.ImageModel
import com.example.coffeepictures.navigator.AppScreenNavigator
import com.example.coffeepictures.viewmodel.BasicViewModel
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val loadAllFavoriteImagesTask: LoadAllFavoriteImagesTask,
    private val appScreenNavigator: AppScreenNavigator,
) : BasicViewModel<FavoritesViewState>() {
    private var imageModels = listOf<ImageModel>()
    private var errorThrowable: Throwable? = null

    override fun createViewState(): FavoritesViewState {
        return FavoritesViewState(
            isLoadingVisible = imageModels.isEmpty() && errorThrowable == null,
            isErrorVisible = imageModels.isEmpty() && errorThrowable != null,
            imageModels =
                imageModels
                    .takeIf { it.isNotEmpty() && errorThrowable == null }
                    ?.map(::createFavoriteImageModel)
                    .orEmpty(),
        )
    }

    fun onFavoritesStarted() {
        loadAllFavoriteImages()
    }

    fun onToolbarBackIconClicked() {
        // TODO - navigate back to home.
    }

    fun onToolbarDeleteIconClicked() {
        // TODO - delete all favorites.
    }

    fun onBackButtonClicked() {
        appScreenNavigator.navigateBackToHome()
    }

    private fun createFavoriteImageModel(imageModel: ImageModel): FavoriteImageModel {
        return FavoriteImageModel(
            /**
             * Use the model url as both the title text and the url,
             * but don't expose this logic to the view.
             */
            titleText = imageModel.url,
            url = imageModel.url,
        )
    }

    private fun loadAllFavoriteImages() {
        imageModels = emptyList()
        errorThrowable = null

        updateViewState()

        viewModelScope.launch {
            loadAllFavoriteImagesTask()
                .onSuccess { imageModels = it }
                .onFailure { errorThrowable = it }

            updateViewState()
        }
    }
}
