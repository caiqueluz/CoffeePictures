package com.example.coffeepictures.home.domain

class LoadRandomImageTaskImpl : LoadRandomImageTask {
    override suspend fun load(): Result<String> {
        // TODO - add real logic.
        return Result.failure(
            exception = Throwable(),
        )
    }
}
