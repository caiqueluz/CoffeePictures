package com.example.coffeepictures.infrastructure.database.impl.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

fun migration(
    start: Int,
    end: Int,
    sql: String,
): Migration {
    return object : Migration(
        startVersion = start,
        endVersion = end,
    ) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL(sql)
        }
    }
}
