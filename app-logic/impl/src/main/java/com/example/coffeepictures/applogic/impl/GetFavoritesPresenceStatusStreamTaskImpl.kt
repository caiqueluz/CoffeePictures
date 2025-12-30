package com.example.coffeepictures.applogic.impl

import kotlinx.coroutines.flow.Flow
import com.example.coffeepictures.applogic.api.GetFavoritesPresenceStatusStreamTask
import com.example.coffeepictures.infrastructure.database.api.ImagesDao

class GetFavoritesPresenceStatusStreamTaskImpl(
    private val imagesDao: ImagesDao,
) : GetFavoritesPresenceStatusStreamTask {
    override fun invoke(): Flow<Boolean> {
        return imagesDao.getFavoritesPresenceStatusFlow()
    }
}
