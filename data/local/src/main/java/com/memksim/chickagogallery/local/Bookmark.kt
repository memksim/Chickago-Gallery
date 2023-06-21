package com.memksim.chickagogallery.local

data class Bookmark(
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
