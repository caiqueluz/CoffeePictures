package com.example.coffeepictures.feature.impl.favorites.list.logic

import androidx.lifecycle.viewModelScope
import com.example.coffeepictures.applogic.api.DeleteAllFavoritesTask
import com.example.coffeepictures.applogic.api.ImageModel
import com.example.coffeepictures.applogic.api.LoadAllFavoriteImagesTask
import com.example.coffeepictures.common.ui.api.FeedbackMessagePresenter
import com.example.coffeepictures.feature.impl.R
import com.example.coffeepictures.feature.impl.favorites.navigator.FavoritesScreenNavigator
import com.example.coffeepictures.navigator.AppScreenNavigator
import com.example.coffeepictures.viewmodel.BasicViewModel
import kotlinx.coroutines.launch

class FavoritesListViewModel(
    private val loadAllFavoriteImagesTask: LoadAllFavoriteImagesTask,
    private val deleteAllFavoritesTask: DeleteAllFavoritesTask,
    private val appScreenNavigator: AppScreenNavigator,
    private val favoritesScreenNavigator: FavoritesScreenNavigator,
    private val feedbackMessagePresenter: FeedbackMessagePresenter,
) : BasicViewModel<FavoritesListViewState>() {
    private var imageModels = listOf<ImageModel>()
    private var errorThrowable: Throwable? = null

    override fun createViewState(): FavoritesListViewState {
        return FavoritesListViewState(
            isLoadingVisible = imageModels.isEmpty() && errorThrowable == null,
            isErrorVisible = imageModels.isEmpty() && errorThrowable != null,
            imageUrls =
                imageModels
                    .takeIf { it.isNotEmpty() && errorThrowable == null }
                    ?.map { it.url }
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

    fun onItemClicked(index: Int) {
        val itemModel = imageModels[index]
        favoritesScreenNavigator.navigateToDetail(imageUrl = itemModel.url)
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
                    feedbackMessagePresenter.show(
                        textResId = R.string.favorites_list_delete_all_favorites_success_feedback_text,
                    )

                    appScreenNavigator.navigateBackToHome()
                }
                .onFailure {
                    feedbackMessagePresenter.show(
                        textResId = R.string.favorites_list_delete_all_favorites_error_feedback_text,
                    )
                }
        }
    }
}
