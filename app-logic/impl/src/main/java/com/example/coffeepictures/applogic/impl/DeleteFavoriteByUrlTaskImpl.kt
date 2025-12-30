package com.example.coffeepictures.applogic.impl

import com.example.coffeepictures.applogic.api.DeleteFavoriteByUrlTask
import com.example.coffeepictures.infrastructure.database.api.ImagesDao

class DeleteFavoriteByUrlTaskImpl(
    private val imagesDao: ImagesDao,
) : DeleteFavoriteByUrlTask {
    override suspend fun invoke(url: String): Result<Unit> {
        return runCatching {
            imagesDao.deleteFavoriteByUrl(url)
        }
    }
}
