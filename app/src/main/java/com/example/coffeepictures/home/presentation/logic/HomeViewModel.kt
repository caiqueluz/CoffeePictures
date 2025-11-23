package com.example.coffeepictures.home.presentation.logic

import androidx.lifecycle.viewModelScope
import com.example.coffeepictures.core.BasicViewModel
import com.example.coffeepictures.home.domain.LoadRandomImageTask
import kotlinx.coroutines.launch

class HomeViewModel(
    private val loadRandomImageTask: LoadRandomImageTask,
) : BasicViewModel<HomeViewState>() {
    private var currentImageUrl: String? = null
    private var errorThrowable: Throwable? = null

    override fun createViewState(): HomeViewState {
        val imageUrl =
            if (currentImageUrl != null && errorThrowable == null) {
                requireNotNull(currentImageUrl)
            } else {
                null
            }

        return HomeViewState(
            isLoadingVisible = currentImageUrl == null && errorThrowable == null,
            isErrorVisible = currentImageUrl == null && errorThrowable != null,
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
        currentImageUrl = null
        errorThrowable = null

        updateViewState()

        viewModelScope.launch {
            loadRandomImageTask.load()
                .onSuccess { currentImageUrl = it }
                .onFailure { errorThrowable = it }

            updateViewState()
        }
    }
}
