package com.example.coffeepictures.favorites.domain

import com.example.coffeepictures.home.domain.RandomImageModel

interface LoadAllFavoriteImagesTask {
    suspend fun load(): Result<List<RandomImageModel>>
}
