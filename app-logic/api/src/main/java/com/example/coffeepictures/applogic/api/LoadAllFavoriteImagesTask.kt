package com.example.coffeepictures.applogic.api

interface LoadAllFavoriteImagesTask {
    suspend operator fun invoke(): Result<List<ImageModel>>
}
