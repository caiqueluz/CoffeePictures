package com.example.coffeepictures.applogic.impl

import com.example.coffeepictures.applogic.api.LoadAllFavoriteImagesTask
import com.example.coffeepictures.applogic.api.ImageModel
import com.example.coffeepictures.infrastructure.database.api.ImagesDao

class LoadAllFavoriteImagesTaskImpl(
    private val imagesDao: ImagesDao,
) : LoadAllFavoriteImagesTask {
    override suspend fun load(): Result<List<ImageModel>> {
        return try {
            val imageModels =
                imagesDao
                    .getAllImages()
                    .ifEmpty {
                        throw Throwable("No random images found.")
                    }
                    .map { entity ->
                        ImageModel(
                            url = entity.url,
                            isFavorite = entity.isFavorite,
                        )
                    }

            Result.success(value = imageModels)
        } catch (throwable: Throwable) {
            Result.failure(throwable)
        }
    }
}
