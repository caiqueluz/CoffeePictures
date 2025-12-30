package com.example.coffeepictures.feature.impl.favorites.logic

import androidx.lifecycle.viewModelScope
import com.example.coffeepictures.applogic.api.DeleteAllFavoritesTask
import com.example.coffeepictures.applogic.api.LoadAllFavoriteImagesTask
import com.example.coffeepictures.applogic.api.ImageModel
import com.example.coffeepictures.common.ui.api.FeedbackMessagePresenter
import com.example.coffeepictures.feature.impl.R
import com.example.coffeepictures.navigator.AppScreenNavigator
import com.example.coffeepictures.viewmodel.BasicViewModel
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val loadAllFavoriteImagesTask: LoadAllFavoriteImagesTask,
    private val deleteAllFavoritesTask: DeleteAllFavoritesTask,
    private val appScreenNavigator: AppScreenNavigator,
    private val feedbackMessagePresenter: FeedbackMessagePresenter,
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
        appScreenNavigator.navigateBackToHome()
    }

    fun onToolbarDeleteIconClicked() {
        deleteAllFavorites()
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

    private fun deleteAllFavorites() {
        viewModelScope.launch {
            deleteAllFavoritesTask()
                .onSuccess {
                    loadAllFavoriteImages()

                    feedbackMessagePresenter.show(
                        textResId = R.string.favorites_delete_all_favorites_success_feedback_text,
                    )
                }
                .onFailure {
                    feedbackMessagePresenter.show(
                        textResId = R.string.favorites_delete_all_favorites_error_feedback_text,
                    )
                }
        }
    }
}
