package com.memksim.chickagogallery.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "bookmarks")
@TypeConverters(value = [MaterialsConverter::class])
data class Bookmark(
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
    val materials: List<String>,
    val publicationHistory: String,
    val exhibitionHistory: String,
    val provenanceText: String
)