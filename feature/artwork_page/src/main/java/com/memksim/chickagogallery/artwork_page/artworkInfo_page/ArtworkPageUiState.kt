package com.memksim.chickagogallery.artwork_page.artworkInfo_page

import com.memksim.chickagogallery.base.mvi.ItemUiState
import com.memksim.chickagogallery.base.mvi.UiState

data class ArtworkPageUiState(
    val itemState: ArtworkPageItemUiState,
    val onBookmark: () -> Unit,
    override var error: Boolean = false,
    override var loading: Boolean = false,
    override var toastMessage: String? = null
): UiState {
    data class ArtworkPageItemUiState(
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
    ): ItemUiState
}
