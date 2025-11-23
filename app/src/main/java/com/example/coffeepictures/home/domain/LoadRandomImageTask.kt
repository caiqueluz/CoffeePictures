package com.example.coffeepictures.home.domain

// TODO - add implementation.
interface LoadRandomImageTask {
    suspend fun load(): Result<String>
}
