package com.example.coffeepictures.core.applogic

import com.example.coffeepictures.applogic.api.LoadAllFavoriteImagesTask
import com.example.coffeepictures.applogic.api.ImageModel

class FakeLoadAllFavoriteImagesTask : LoadAllFavoriteImagesTask {
    private var fakeResult: Result<List<ImageModel>>? = null

    override suspend operator fun invoke(): Result<List<ImageModel>> {
        if (fakeResult == null) AssertionError("No fake results registered.")
        return requireNotNull(fakeResult)
    }

    fun fakeSuccess(model: List<ImageModel>) {
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
