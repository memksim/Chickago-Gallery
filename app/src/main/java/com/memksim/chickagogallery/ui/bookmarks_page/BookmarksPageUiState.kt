package com.memksim.chickagogallery.ui.bookmarks_page

import com.memksim.chickagogallery.ui.ItemUiState
import com.memksim.chickagogallery.ui.UiState

data class BookmarksPageUiState(
    val itemsList: List<BookmarksPageItemUiState>,
    val itemsForSearch: List<BookmarksPageItemUiState>
): UiState

data class BookmarksPageItemUiState(
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
    val artworkTypeId: Int,
    val artworkTypeTitle: String,
    val onBookmark: (item: BookmarksPageItemUiState) -> Unit
): ItemUiState(
    itemTitle = title
)