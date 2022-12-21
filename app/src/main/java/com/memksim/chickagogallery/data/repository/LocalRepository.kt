package com.memksim.chickagogallery.data.repository

import com.memksim.chickagogallery.data.local.api.BookmarksDao
import com.memksim.chickagogallery.data.local.entity.Bookmark
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val dao: BookmarksDao
) {

    suspend fun getBookmarksList(): List<Bookmark> =
        dao.getBookmarksList()

    suspend fun getBookmarksListByArtworkType(artworkTypeId: Int): List<Bookmark> =
        dao.getBookmarksListByArtworkType(typeId = artworkTypeId)

    suspend fun saveBookmarks(bookmark: Bookmark) =
        dao.saveBookmark(bookmark = bookmark)

    suspend fun removeBookmarks(bookmark: Bookmark) =
        dao.deleteBookmark(bookmark = bookmark)

}