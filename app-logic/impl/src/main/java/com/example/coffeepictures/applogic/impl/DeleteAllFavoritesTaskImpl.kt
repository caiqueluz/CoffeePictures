package com.example.coffeepictures.applogic.impl

import com.example.coffeepictures.applogic.api.DeleteAllFavoritesTask
import com.example.coffeepictures.infrastructure.database.api.ImagesDao

class DeleteAllFavoritesTaskImpl(
    private val imagesDao: ImagesDao,
) : DeleteAllFavoritesTask {
    override suspend fun invoke(): Result<Unit> {
        return runCatching {
            imagesDao.deleteAllFavorites()
        }
    }
}
