package com.memksim.chickagogallery.ui.artworkInfo_page

data class ArtworkInfoPageUiState(
    val itemState: ArtworkInfoPageItemUiState,
    val onBookmark: () -> Unit
)

data class ArtworkInfoPageItemUiState(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val artist: String,
    val date: String,
    val artworkTypeId: Int,
    val artworkTypeTitle: String,
    val isBookmarked: Boolean,
    val creditLine: String,
    val size: String,
    val gallery: String,
    val materials: List<String>,
    val publicationHistory: String,
    val exhibitionHistory: String,
    val provenanceText: String
)