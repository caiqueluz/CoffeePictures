package com.example.coffeepictures.applogic.api

import kotlinx.coroutines.flow.Flow

interface GetFavoritesPresenceStatusStreamTask {
    operator fun invoke(): Flow<Boolean>
}
