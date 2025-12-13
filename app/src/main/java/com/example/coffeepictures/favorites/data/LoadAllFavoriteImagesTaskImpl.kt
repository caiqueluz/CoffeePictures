package com.example.coffeepictures.favorites.data

import com.example.coffeepictures.favorites.domain.LoadAllFavoriteImagesTask
import com.example.coffeepictures.home.domain.RandomImageModel
import com.example.coffeepictures.infrastructure.database.api.ImagesDao

class LoadAllFavoriteImagesTaskImpl(
    private val imagesDao: ImagesDao,
) : LoadAllFavoriteImagesTask {
    override suspend fun load(): Result<List<RandomImageModel>> {
        return try {
            val imageModels =
                imagesDao
                    .getAllImages()
                    .ifEmpty {
                        throw Throwable("No random images found.")
                    }
                    .map { entity ->
                        RandomImageModel(url = entity.url)
                    }

            Result.success(value = imageModels)
        } catch (throwable: Throwable) {
            Result.failure(throwable)
        }
    }
}
