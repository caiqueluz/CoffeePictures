package com.example.coffeepictures.infrastructure.database.impl

class AppDatabaseProvider(
    private val databaseBuilderFactory: RoomDatabaseBuilderFactory,
) {
    @Volatile
    private var instance: AppDatabase? = null

    fun get(): AppDatabase {
        if (instance != null) return requireNotNull(instance)

        return synchronized(this) {
            val builder =
                databaseBuilderFactory.create(
                    name = "app_database",
                    klass = AppDatabase::class,
                )

            instance = builder.build()
            requireNotNull(instance)
        }
    }
}
