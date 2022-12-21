package com.memksim.chickagogallery.converters

import com.memksim.chickagogallery.domain.model.ArtworkType
import com.memksim.chickagogallery.ui.artworks_types_page.ArtworksTypesPageItemUiState

fun convertArtworksTypesPageItemUiStateToArtworkType(
    item: ArtworksTypesPageItemUiState
): ArtworkType = ArtworkType(
    item.id,
    item.title
)

fun convertArtworkTypeToArtworksTypesPageItemUiState(
    artworkType: ArtworkType
): ArtworksTypesPageItemUiState = ArtworksTypesPageItemUiState(
    artworkType.id,
    artworkType.title
)

fun convertArtworkTypesListToArtworksTypesPageItemUiStateList(
    artworkTypeList: List<ArtworkType>
): List<ArtworksTypesPageItemUiState> = artworkTypeList.map {
    convertArtworkTypeToArtworksTypesPageItemUiState(it)
}
