package com.memksim.chickagogallery.data.local.api

import androidx.room.*
import com.memksim.chickagogallery.data.local.entity.Bookmark

@Dao
interface BookmarksDao {

    /**
     * Saves a Bookmark type item in the table, the OnConflictStrategy.REPLACE strategy is used because the primary key is not autoincrement
     * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBookmark(bookmark: Bookmark)

    /**
     * Gets all Bookmark type items from table
     * */
    @Query("select * from bookmarks")
    suspend fun getBookmarksList(): List<Bookmark>

    /**
     * @param bookmarkId ID for both the Bookmark type and the Artwork type
     **/
    @Query("select * from bookmarks where bookmarkId = :bookmarkId")
    suspend fun getBookmarkById(bookmarkId: Int): Bookmark

    /**
     * @param typeId ArtworkType id - id of Artwork category, also a category for Bookmark
     * */
    @Query("select * from bookmarks where artworkTypeId = :typeId")
    suspend fun getBookmarksListByArtworkType(typeId: Int): List<Bookmark>

    @Delete
    suspend fun deleteBookmark(bookmark: Bookmark)

}