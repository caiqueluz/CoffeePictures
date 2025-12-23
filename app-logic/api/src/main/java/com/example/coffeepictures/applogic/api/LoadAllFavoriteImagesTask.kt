package com.example.coffeepictures.applogic.api

interface LoadAllFavoriteImagesTask {
    suspend fun load(): Result<List<RandomImageModel>>
}
