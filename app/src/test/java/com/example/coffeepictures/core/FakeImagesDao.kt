package com.example.coffeepictures.core

import com.example.coffeepictures.database.database.ImageEntity
import com.example.coffeepictures.database.database.ImagesDao

class FakeImagesDao : ImagesDao {
    private val entities = mutableListOf<ImageEntity>()
    private var hasFakeGetAllError = false

    override suspend fun insert(entity: ImageEntity) {
        entities.add(entity)
    }

    override suspend fun getAllImages(): List<ImageEntity> {
        if (hasFakeGetAllError) {
            throw Exception("Get all images fake error.")
        }

        return entities
    }

    fun fakeGetAllImagesError() {
        hasFakeGetAllError = true
    }
}
