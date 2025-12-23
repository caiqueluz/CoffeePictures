package com.example.coffeepictures.core.applogic

import com.example.coffeepictures.applogic.api.LoadAllFavoriteImagesTask
import com.example.coffeepictures.applogic.api.RandomImageModel

class FakeLoadAllFavoriteImagesTask : LoadAllFavoriteImagesTask {
    private var fakeResult: Result<List<RandomImageModel>>? = null

    override suspend fun load(): Result<List<RandomImageModel>> {
        if (fakeResult == null) AssertionError("No fake results registered.")
        return requireNotNull(fakeResult)
    }

    fun fakeSuccess(model: List<RandomImageModel>) {
        fakeResult =
            if (model.isEmpty()) {
                val throwable = Throwable("List is empty.")
                Result.failure(throwable)
            } else {
                Result.success(model)
            }
    }

    fun fakeFailure(throwable: Throwable) {
        fakeResult = Result.failure(throwable)
    }
}
