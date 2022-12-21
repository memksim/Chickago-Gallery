package com.memksim.chickagogallery.ui.artworks_types_page

import com.memksim.chickagogallery.ui.ItemUiState
import com.memksim.chickagogallery.ui.UiState

data class ArtworksTypesPageUiState(
    val artworksTypesList: List<ArtworksTypesPageItemUiState> = emptyList(),
    val artworkTypesToSearch: List<ArtworksTypesPageItemUiState> = emptyList()
) : UiState

data class ArtworksTypesPageItemUiState(
    val id: Int,
    val title: String
) : ItemUiState(
    itemTitle = title
)