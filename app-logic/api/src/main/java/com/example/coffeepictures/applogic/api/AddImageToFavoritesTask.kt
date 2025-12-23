package com.example.coffeepictures.applogic.api

interface AddImageToFavoritesTask {
    suspend fun add(imageUrl: String): Result<Unit>
}
