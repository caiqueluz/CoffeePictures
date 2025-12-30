package com.example.coffeepictures.infrastructure.database.api

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ImagesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: ImageEntity)

    @Query("DELETE FROM images")
    suspend fun deleteAllFavorites()

    @Query("SELECT EXISTS(SELECT 1 FROM images)")
    fun getFavoritesPresenceStatusFlow(): Flow<Boolean>

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
