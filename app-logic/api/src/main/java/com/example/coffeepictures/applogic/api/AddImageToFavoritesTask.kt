package com.example.coffeepictures.applogic.api

interface AddImageToFavoritesTask {
    suspend operator fun invoke(imageUrl: String): Result<Unit>
}
