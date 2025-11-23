package com.example.coffeepictures.database.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class ImageEntity(
    @PrimaryKey
    @ColumnInfo("url")
    val url: String,
)
