package com.example.coffeepictures.infrastructure.database.impl

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.reflect.KClass

class RoomDatabaseBuilderFactoryImpl(
    private val applicationContext: Context,
) : RoomDatabaseBuilderFactory {
    override fun <DatabaseT : RoomDatabase> create(
        name: String,
        klass: KClass<DatabaseT>,
    ): RoomDatabase.Builder<DatabaseT> {
        return Room.databaseBuilder(
            context = applicationContext,
            klass = klass.java,
            name = name,
        )
    }
}
