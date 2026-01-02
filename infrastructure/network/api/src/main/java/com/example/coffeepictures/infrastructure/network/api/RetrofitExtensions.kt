package com.example.coffeepictures.infrastructure.network.api

import retrofit2.Response

fun <ResponseT> Response<ResponseT>.requireBody(): ResponseT {
    return requireNotNull(this.body())
}
