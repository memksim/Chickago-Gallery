package com.memksim.chickagogallery.ui.artworks_page

import com.memksim.chickagogallery.ui.base.ItemUiState
import com.memksim.chickagogallery.ui.base.UiState

data class ArtworksPageUiState(
    val itemsList: List<ArtworksPageItemUiState>,
    val itemsForSearch: List<ArtworksPageItemUiState>,
    val artworkTypeId: Int,
    val artworkTypeTitle: String,
) : UiState

data class ArtworksPageItemUiState(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val artist: String,
    val date: String,
    val isBookmarked: Boolean,
    val creditLine: String,
    val size: String,
    val gallery: String,
    val materials: List<String>,
    val publicationHistory: String,
    val exhibitionHistory: String,
    val provenanceText: String,
    val onBookmark: (item: ArtworksPageItemUiState) -> Unit
) : ItemUiState(
    itemTitle = title
)

