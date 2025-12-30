package com.example.coffeepictures.feature.impl.home.logic

import androidx.lifecycle.viewModelScope
import com.example.coffeepictures.applogic.api.AddImageToFavoritesTask
import com.example.coffeepictures.applogic.api.GetImageByUrlTask
import com.example.coffeepictures.applogic.api.LoadRandomImageTask
import com.example.coffeepictures.applogic.api.ImageModel
import com.example.coffeepictures.common.ui.api.FeedbackMessagePresenter
import com.example.coffeepictures.feature.impl.R
import com.example.coffeepictures.navigator.AppScreenNavigator
import com.example.coffeepictures.viewmodel.BasicViewModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val loadRandomImageTask: LoadRandomImageTask,
    private val getImageByUrlTask: GetImageByUrlTask,
    private val addImageToFavoritesTask: AddImageToFavoritesTask,
    private val appScreenNavigator: AppScreenNavigator,
    private val feedbackMessagePresenter: FeedbackMessagePresenter,
) : BasicViewModel<HomeViewState>() {
    private var imageModel: ImageModel? = null
    private var errorThrowable: Throwable? = null

    override fun createViewState(): HomeViewState {
        return HomeViewState(
            isLoadingVisible = imageModel == null && errorThrowable == null,
            isErrorVisible = imageModel == null && errorThrowable != null,
            imageUrl =
                imageModel
                    .takeIf { it != null && errorThrowable == null }
                    ?.url,
            isLoadNewButtonEnabled = imageModel != null || errorThrowable != null,
            isAddToFavoritesButtonEnabled = imageModel != null && imageModel?.isFavorite == false && errorThrowable == null,
        )
    }

    fun onHomeStarted() {
        loadRandomImage()
    }

    fun onToolbarStarIconClicked() {
        appScreenNavigator.navigateToFavorites()
    }

    fun onLoadNewButtonClicked() {
        loadRandomImage()
    }

    fun onAddToFavoritesButtonClicked() {
        addImageToFavorites()
    }

    private fun loadRandomImage() {
        imageModel = null
        errorThrowable = null

        updateViewState()

        viewModelScope.launch {
            loadRandomImageTask()
                .onSuccess { imageModel = it }
                .onFailure { errorThrowable = it }

            updateViewState()
        }
    }

    private fun addImageToFavorites() {
        viewModelScope.launch {
            val imageUrl = requireNotNull(imageModel).url

            addImageToFavoritesTask(imageUrl)
                .onSuccess {
                    reloadImageByUrl()

                    feedbackMessagePresenter.show(
                        textResId = R.string.home_add_image_to_favorites_feedback_success_message_text,
                    )
                }
                .onFailure {
                    feedbackMessagePresenter.show(
                        textResId = R.string.home_add_image_to_favorites_feedback_error_message_text,
                    )
                }
        }
    }

    private fun reloadImageByUrl() {
        viewModelScope.launch {
            val imageUrl = requireNotNull(imageModel).url

            getImageByUrlTask(url = imageUrl)
                .onSuccess { imageModel = it }
                .onFailure { errorThrowable = it }

            updateViewState()
        }
    }
}
