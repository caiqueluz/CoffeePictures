package com.example.coffeepictures.home.data

class RandomImagesHttpClient(
    private val randomImagesRetrofitClient: RandomImagesRetrofitClient,
) {
    suspend fun loadRandomImage(): Result<RandomImageResponse> {
        return try {
            val response = randomImagesRetrofitClient.loadRandomImage()
            val body = response.body()
            val model = requireNotNull(body)

            Result.success(value = model)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}
