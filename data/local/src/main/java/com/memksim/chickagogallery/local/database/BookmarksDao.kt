package com.memksim.chickagogallery.local.database

import androidx.room.*

@Dao
internal interface BookmarksDao {

    /**
     * Saves a Bookmark type item in the table, the OnConflictStrategy.REPLACE strategy is used because the primary key is not autoincrement
     * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBookmark(bookmarkEntity: BookmarkEntity)

    /**
     * Gets all Bookmark type items from table
     * */
    @Query("select * from bookmarks")
    suspend fun getBookmarksList(): List<BookmarkEntity>

    /**
     * @param bookmarkId ID for both the Bookmark type and the Artwork type
     **/
    @Query("select * from bookmarks where bookmarkId = :bookmarkId")
    suspend fun getBookmarkById(bookmarkId: Int): BookmarkEntity

    /**
     * @param typeId ArtworkType id - id of Artwork category, also a category for Bookmark
     * */
    @Query("select * from bookmarks where artworkTypeId = :typeId")
    suspend fun getBookmarksListByArtworkType(typeId: Int): List<BookmarkEntity>

    @Delete
    suspend fun deleteBookmark(bookmarkEntity: BookmarkEntity)

}