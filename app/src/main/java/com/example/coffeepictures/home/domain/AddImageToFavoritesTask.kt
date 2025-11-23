package com.example.coffeepictures.home.domain

interface AddImageToFavoritesTask {
    suspend fun add(imageUrl: String): Result<Unit>
}
