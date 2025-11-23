package com.example.coffeepictures.home.data

import retrofit2.Response
import retrofit2.http.GET

interface RandomImagesRetrofitClient {
    @GET("/random.json")
    suspend fun loadRandomImage(): Response<RandomImageResponse>
}
