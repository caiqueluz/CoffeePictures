package com.example.coffeepictures.home.data

import com.example.coffeepictures.database.database.ImageEntity
import com.example.coffeepictures.database.database.ImagesDao
import com.example.coffeepictures.home.domain.AddImageToFavoritesTask

class AddImageToFavoritesTaskImpl(
    private val imagesDao: ImagesDao,
) : AddImageToFavoritesTask {
    override suspend fun add(imageUrl: String): Result<Unit> {
        return try {
            val entity = ImageEntity(url = imageUrl)
            imagesDao.insert(entity)

            Result.success(Unit)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}
