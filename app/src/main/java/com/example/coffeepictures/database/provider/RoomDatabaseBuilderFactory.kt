package com.example.coffeepictures.database.provider

import androidx.room.RoomDatabase
import kotlin.reflect.KClass

interface RoomDatabaseBuilderFactory {
    fun <DatabaseT : RoomDatabase> create(
        name: String,
        klass: KClass<DatabaseT>,
    ): RoomDatabase.Builder<DatabaseT>
}
