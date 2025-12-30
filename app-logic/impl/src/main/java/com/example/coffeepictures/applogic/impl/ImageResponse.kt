package com.example.coffeepictures.applogic.impl

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("file") val url: String,
)
