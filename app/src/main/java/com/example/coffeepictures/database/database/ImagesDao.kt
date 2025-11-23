package com.example.coffeepictures.database.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImagesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: ImageEntity)

    @Query("SELECT * FROM images")
    suspend fun getAllImages(): List<ImageEntity>
}
