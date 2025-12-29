package com.example.coffeepictures.infrastructure.database.api

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

    @Query(
        value =
            """
                SELECT * FROM images
                WHERE url = :url
                LIMIT 1
            """,
    )
    suspend fun getImageByUrl(url: String): ImageEntity
}
