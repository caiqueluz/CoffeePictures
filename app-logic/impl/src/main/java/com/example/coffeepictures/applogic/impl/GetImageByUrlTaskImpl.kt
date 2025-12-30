package com.example.coffeepictures.applogic.impl

import com.example.coffeepictures.applogic.api.GetImageByUrlTask
import com.example.coffeepictures.applogic.api.ImageModel
import com.example.coffeepictures.infrastructure.database.api.ImagesDao

class GetImageByUrlTaskImpl(
    private val imagesDao: ImagesDao,
) : GetImageByUrlTask {
    override suspend operator fun invoke(url: String): Result<ImageModel> {
        return try {
            val entity = imagesDao.getImageByUrl(url)

            val model =
                ImageModel(
                    url = entity.url,
                    isFavorite = entity.isFavorite,
                )

            Result.success(value = model)
        } catch (throwable: Throwable) {
            Result.failure(throwable)
        }
    }
}
