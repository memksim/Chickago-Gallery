package com.memksim.chickagogallery.main_page

import com.memksim.chickagogallery.base.mvi.ItemUiState
import com.memksim.chickagogallery.base.mvi.UiState

internal data class MainPageUiState(
    val itemsList: List<MainPageItemUiState>,
    val artworkTypeId: Int,
    val artworkTypeTitle: String,
    override var error: Boolean = false,
    override var loading: Boolean = false,
    override var toastMessage: String? = null,
) : UiState {
    data class MainPageItemUiState(
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
        val onBookmark: (item: MainPageItemUiState) -> Unit
    ) : ItemUiState
}



