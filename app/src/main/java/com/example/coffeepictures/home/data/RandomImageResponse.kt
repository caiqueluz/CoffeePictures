package com.example.coffeepictures.home.data

import com.google.gson.annotations.SerializedName

data class RandomImageResponse(
    @SerializedName("file") val url: String,
)
