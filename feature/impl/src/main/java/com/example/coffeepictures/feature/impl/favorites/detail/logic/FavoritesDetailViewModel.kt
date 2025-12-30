package com.example.coffeepictures.feature.impl.favorites.detail.logic

import androidx.lifecycle.viewModelScope
import com.example.coffeepictures.applogic.api.DeleteFavoriteByUrlTask
import com.example.coffeepictures.applogic.api.GetImageByUrlTask
import com.example.coffeepictures.applogic.api.ImageModel
import com.example.coffeepictures.common.ui.api.FeedbackMessagePresenter
import com.example.coffeepictures.feature.impl.R
import com.example.coffeepictures.feature.impl.favorites.navigator.FavoritesScreenNavigator
import com.example.coffeepictures.viewmodel.BasicViewModel
import kotlinx.coroutines.launch

class FavoritesDetailViewModel(
    private val getImageByUrlTask: GetImageByUrlTask,
    private val deleteFavoriteByUrlTask: DeleteFavoriteByUrlTask,
    private val favoritesScreenNavigator: FavoritesScreenNavigator,
    private val feedbackMessagePresenter: FeedbackMessagePresenter,
) : BasicViewModel<FavoritesDetailViewState>() {
    private lateinit var imageUrl: String
    private var imageModel: ImageModel? = null
    private var errorThrowable: Throwable? = null

    override fun createViewState(): FavoritesDetailViewState {
        return FavoritesDetailViewState(
            isLoadingVisible = imageModel == null && errorThrowable == null,
            isErrorVisible = imageModel == null && errorThrowable != null,
            imageUrlText =
                imageModel
                    .takeIf { errorThrowable == null }
                    ?.url,
        )
    }

    fun onFavoritesDetailStarted(url: String) {
        this.imageUrl = url
        loadFavoritesDetail()
    }

    fun onToolbarBackIconClicked() {
        favoritesScreenNavigator.navigateBackToList()
    }

    fun onToolbarDeleteIconClicked() {
        deleteFavorite()
    }

    fun onBackButtonClicked() {
        favoritesScreenNavigator.navigateBackToList()
    }

    private fun loadFavoritesDetail() {
        imageModel = null
        errorThrowable = null

        updateViewState()

        viewModelScope.launch {
            getImageByUrlTask(imageUrl)
                .onSuccess { imageModel = it }
                .onFailure { errorThrowable = it }

            updateViewState()
        }
    }

    private fun deleteFavorite() {
        viewModelScope.launch {
            deleteFavoriteByUrlTask(imageUrl)
                .onSuccess {
                    feedbackMessagePresenter.show(
                        textResId = R.string.favorites_detail_delete_favorite_success_feedback_text,
                    )

                    favoritesScreenNavigator.navigateBackToList()
                }
                .onFailure {
                    feedbackMessagePresenter.show(
                        textResId = R.string.favorites_detail_delete_favorite_error_feedback_text,
                    )
                }
        }
    }
}
