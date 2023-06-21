package com.memksim.chickagogallery.local.repository

import com.memksim.chickagogallery.local.LocalRepository
import com.memksim.chickagogallery.local.database.BookmarksDao
import com.memksim.chickagogallery.local.Bookmark

internal class LocalRepositoryImpl constructor(
    private val dao: BookmarksDao
): LocalRepository {

    override suspend fun getBookmarksList(): List<Bookmark> {
        return emptyList() //todo
    }

    override suspend fun getBookmarksListByArtworkType(artworkTypeId: Int): List<Bookmark> {
        return emptyList() //todo
    }

    override suspend fun saveBookmarks(bookmarkEntity: Bookmark) {
        //TODO("Not yet implemented")
    }

    override suspend fun removeBookmarks(bookmarkEntity: Bookmark) {
        //TODO("Not yet implemented")
    }


}