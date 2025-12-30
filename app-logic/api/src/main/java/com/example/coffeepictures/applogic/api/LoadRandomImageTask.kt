package com.example.coffeepictures.applogic.api

interface LoadRandomImageTask {
    suspend fun load(): Result<ImageModel>
}
