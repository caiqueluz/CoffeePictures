package com.example.coffeepictures.infrastructure.database.impl

import com.example.coffeepictures.infrastructure.database.impl.migration.MIGRATION_1_TO_2

class AppDatabaseProvider(
    private val databaseBuilderFactory: RoomDatabaseBuilderFactory,
) {
    @Volatile
    private var instance: AppDatabase? = null

    fun get(): AppDatabase {
        if (instance != null) return requireNotNull(instance)

        return synchronized(this) {
            val builder =
                databaseBuilderFactory
                    .create(
                        name = "app_database",
                        klass = AppDatabase::class,
                    )
                    .addMigrations(
                        MIGRATION_1_TO_2,
                    )

            instance = builder.build()
            requireNotNull(instance)
        }
    }
}
