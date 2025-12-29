package com.example.coffeepictures.infrastructure.database.impl.migration

val MIGRATION_1_TO_2 =
    migration(
        start = 1,
        end = 2,
        sql =
            """
            ALTER TABLE images
            ADD COLUMN is_favorite INTEGER NOT NULL DEFAULT 1
            """,
    )
