package com.memksim.chickagogallery.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarks")
internal data class BookmarkEntity(
    @PrimaryKey(autoGenerate = false)
    val bookmarkId: Int,
    val title: String,
    val imageUrl: String,
    val artist: String,
    val date: String,
    val isBookmarked: Boolean,
    val artworkTypeId: Int,
    val artworkTypeTitle: String,
    val creditLine: String,
    val size: String,
    val gallery: String,
    val materials: String,
    val publicationHistory: String,
    val exhibitionHistory: String,
    val provenanceText: String
)