package com.memksim.chickagogallery.local.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [BookmarkEntity::class],
    version = 1,
    exportSchema = false
)
internal abstract class BookmarksDatabase : RoomDatabase() {

    abstract fun getDao(): BookmarksDao

}