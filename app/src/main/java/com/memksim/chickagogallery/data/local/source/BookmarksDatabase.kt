package com.memksim.chickagogallery.data.local.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.memksim.chickagogallery.data.local.api.BookmarksDao
import com.memksim.chickagogallery.data.local.entity.Bookmark

@Database(
    entities = [Bookmark::class],
    version = 1,
    exportSchema = false
)
abstract class BookmarksDatabase : RoomDatabase() {

    abstract fun getDao(): BookmarksDao

}