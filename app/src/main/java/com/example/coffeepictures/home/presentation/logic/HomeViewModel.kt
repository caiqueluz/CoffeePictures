package com.example.coffeepictures.home.presentation.logic

import androidx.lifecycle.viewModelScope
import com.example.coffeepictures.core.BasicViewModel
import com.example.coffeepictures.home.domain.LoadRandomImageTask
import com.example.coffeepictures.home.domain.RandomImageModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val loadRandomImageTask: LoadRandomImageTask,
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
        // TODO.
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
}
