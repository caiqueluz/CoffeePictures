package com.example.coffeepictures.feature.impl.favorites.detail.logic

import androidx.lifecycle.viewModelScope
import com.example.coffeepictures.applogic.api.GetImageByUrlTask
import com.example.coffeepictures.applogic.api.ImageModel
import com.example.coffeepictures.viewmodel.BasicViewModel
import kotlinx.coroutines.launch

class FavoritesDetailViewModel(
    private val getImageByUrlTask: GetImageByUrlTask,
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
        // TODO - navigate back to favorites.
    }

    fun onToolbarDeleteIconClicked() {
        // TODO - delete favorite image by url.
    }

    private fun loadFavoritesDetail() {
        imageModel = null
        errorThrowable = null

        updateViewState()

        viewModelScope.launch {
            getImageByUrlTask(imageUrl)
                .onSuccess { imageModel = null }
                .onFailure { errorThrowable = it }

            updateViewState()
        }
    }
}
