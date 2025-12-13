package com.example.coffeepictures.infrastructure.database.impl

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coffeepictures.infrastructure.database.api.ImageEntity
import com.example.coffeepictures.infrastructure.database.api.ImagesDao

@Database(
    entities = [
        ImageEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun imagesDao(): ImagesDao
}
