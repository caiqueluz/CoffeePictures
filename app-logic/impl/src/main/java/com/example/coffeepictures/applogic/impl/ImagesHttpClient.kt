package com.example.coffeepictures.applogic.impl

class ImagesHttpClient(
    private val imagesRetrofitClient: ImagesRetrofitClient,
) {
    suspend fun loadRandomImage(): Result<ImageResponse> {
        return try {
            val response = imagesRetrofitClient.loadRandomImage()
            val body = response.body()
            val model = requireNotNull(body)

            Result.success(value = model)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}
