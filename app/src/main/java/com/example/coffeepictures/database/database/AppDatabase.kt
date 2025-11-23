package com.example.coffeepictures.database.database

import androidx.room.Database
import androidx.room.RoomDatabase

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
