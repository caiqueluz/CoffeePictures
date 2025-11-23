package com.example.coffeepictures.home.presentation.logic

import androidx.lifecycle.viewModelScope
import com.example.coffeepictures.core.BasicViewModel
import com.example.coffeepictures.home.domain.AddImageToFavoritesTask
import com.example.coffeepictures.home.domain.LoadRandomImageTask
import com.example.coffeepictures.home.domain.RandomImageModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val loadRandomImageTask: LoadRandomImageTask,
    private val addImageToFavoritesTask: AddImageToFavoritesTask,
) : BasicViewModel<HomeViewState>() {
    private var randomImageModel: RandomImageModel? = null
    private var errorThrowable: Throwable? = null

    override fun createViewState(): HomeViewState {
        val imageUrl =
            if (randomImageModel != null && errorThrowable == null) {
                requireNotNull(randomImageModel).url
            } else {
                null
            }

        return HomeViewState(
            isLoadingVisible = randomImageModel == null && errorThrowable == null,
            isErrorVisible = randomImageModel == null && errorThrowable != null,
            imageUrl = imageUrl,
        )
    }

    fun onHomeStarted() {
        loadRandomImage()
    }

    fun onLoadNewButtonClicked() {
        loadRandomImage()
    }

    fun onAddToFavoritesButtonClicked() {
        addImageToFavorites()
    }

    private fun loadRandomImage() {
        randomImageModel = null
        errorThrowable = null

        updateViewState()

        viewModelScope.launch {
            loadRandomImageTask.load()
                .onSuccess { randomImageModel = it }
                .onFailure { errorThrowable = it }

            updateViewState()
        }
    }

    private fun addImageToFavorites() {
        viewModelScope.launch {
            val imageUrl = requireNotNull(randomImageModel).url

            addImageToFavoritesTask.add(imageUrl)
                .onSuccess {
                    // TODO - show success feedback.
                }
                .onFailure {
                    // TODO - show error feedback.
                }
        }
    }
}
