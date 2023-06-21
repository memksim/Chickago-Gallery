package com.memksim.chickagogallery.local

interface LocalRepository {

    suspend fun getBookmarksList(): List<Bookmark>

    suspend fun getBookmarksListByArtworkType(artworkTypeId: Int): List<Bookmark>

    suspend fun saveBookmarks(bookmarkEntity: Bookmark)

    suspend fun removeBookmarks(bookmarkEntity: Bookmark)

}