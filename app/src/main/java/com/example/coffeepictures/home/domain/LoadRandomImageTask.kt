package com.example.coffeepictures.home.domain

interface LoadRandomImageTask {
    suspend fun load(): Result<RandomImageModel>
}
