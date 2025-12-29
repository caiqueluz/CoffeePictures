package com.example.coffeepictures.infrastructure.database.api

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class ImageEntity(
    @PrimaryKey
    @ColumnInfo("url")
    val url: String,
    @ColumnInfo("is_favorite")
    val isFavorite: Boolean,
)
