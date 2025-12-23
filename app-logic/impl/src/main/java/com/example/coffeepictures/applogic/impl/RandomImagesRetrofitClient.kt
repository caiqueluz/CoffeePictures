package com.example.coffeepictures.applogic.impl

import retrofit2.Response
import retrofit2.http.GET

interface RandomImagesRetrofitClient {
    @GET("/random.json")
    suspend fun loadRandomImage(): Response<RandomImageResponse>
}
