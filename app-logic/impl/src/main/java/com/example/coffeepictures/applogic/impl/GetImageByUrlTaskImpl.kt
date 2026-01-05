package com.example.coffeepictures.applogic.impl

import com.example.coffeepictures.applogic.api.GetImageByUrlTask
import com.example.coffeepictures.applogic.api.ImageModel
import com.example.coffeepictures.infrastructure.database.api.ImagesDao

class GetImageByUrlTaskImpl(
    private val imagesDao: ImagesDao,
) : GetImageByUrlTask {
    override suspend operator fun invoke(url: String): Result<ImageModel> {
        return runCatching {
            val entity = imagesDao.getImageByUrl(url)

            ImageModel(
                url = entity.url,
                isFavorite = entity.isFavorite,
            )
        }
    }
}
