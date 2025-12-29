package com.example.coffeepictures.applogic.impl

import com.example.coffeepictures.applogic.api.GetImageByUrlTask
import com.example.coffeepictures.applogic.api.RandomImageModel
import com.example.coffeepictures.infrastructure.database.api.ImagesDao

class GetImageByUrlTaskImpl(
    private val imagesDao: ImagesDao,
) : GetImageByUrlTask {
    override suspend fun get(url: String): Result<RandomImageModel> {
        return try {
            val entity = imagesDao.getImageByUrl(url)

            val model =
                RandomImageModel(
                    url = entity.url,
                    isFavorite = entity.isFavorite,
                )

            Result.success(value = model)
        } catch (throwable: Throwable) {
            Result.failure(throwable)
        }
    }
}
