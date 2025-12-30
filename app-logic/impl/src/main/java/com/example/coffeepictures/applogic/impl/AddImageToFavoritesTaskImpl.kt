package com.example.coffeepictures.applogic.impl

import com.example.coffeepictures.applogic.api.AddImageToFavoritesTask
import com.example.coffeepictures.infrastructure.database.api.ImageEntity
import com.example.coffeepictures.infrastructure.database.api.ImagesDao

class AddImageToFavoritesTaskImpl(
    private val imagesDao: ImagesDao,
) : AddImageToFavoritesTask {
    override suspend operator fun invoke(imageUrl: String): Result<Unit> {
        return try {
            val entity =
                ImageEntity(
                    url = imageUrl,
                    isFavorite = true,
                )

            imagesDao.insert(entity)

            Result.success(Unit)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}
