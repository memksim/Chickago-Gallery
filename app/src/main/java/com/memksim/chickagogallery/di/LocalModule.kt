package com.memksim.chickagogallery.di

import android.content.Context
import androidx.room.Room
import com.memksim.chickagogallery.data.local.api.BookmarksDao
import com.memksim.chickagogallery.data.local.source.BookmarksDatabase
import com.memksim.chickagogallery.data.repository.LocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): BookmarksDatabase = Room.databaseBuilder(
        context,
        BookmarksDatabase::class.java,
        "BookmarksDb"
    ).build()

    @Provides
    @Singleton
    fun provideDao(
        db: BookmarksDatabase
    ): BookmarksDao = db.getDao()

    @Provides
    fun provideRepository(
        dao: BookmarksDao
    ): LocalRepository = LocalRepository(dao = dao)

}