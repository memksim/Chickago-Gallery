package com.memksim.chickagogallery.converters

import com.memksim.chickagogallery.data.local.entity.Bookmark
import com.memksim.chickagogallery.domain.model.Artwork
import com.memksim.chickagogallery.domain.model.ArtworkType
import com.memksim.chickagogallery.ui.artworks_page.ArtworksPageItemUiState
import com.memksim.chickagogallery.ui.artworks_page.ArtworksPageUiState

fun convertArtworksPageItemUiStateToBookmark(
    itemState: ArtworksPageItemUiState,
    artworkType: ArtworkType
): Bookmark = Bookmark(
    bookmarkId = itemState.id,
    title = itemState.title,
    imageUrl = itemState.imageUrl,
    artist = itemState.artist,
    date = itemState.date,
    artworkTypeId = artworkType.id,
    artworkTypeTitle = artworkType.title,
    isBookmarked = itemState.isBookmarked,
    creditLine = itemState.creditLine,
    size = itemState.size,
    gallery = itemState.gallery,
    materials = itemState.materials,
    publicationHistory = itemState.publicationHistory,
    exhibitionHistory = itemState.exhibitionHistory,
    provenanceText = itemState.provenanceText
)

fun convertArtworksPageItemUiStateToArtworkType(
    item: ArtworksPageUiState?
): ArtworkType? {
    if (item == null) return null
    return ArtworkType(
        id = item.artworkTypeId,
        title = item.artworkTypeTitle
    )
}

fun convertArtworksPageItemUiStateToArtwork(
    item: ArtworksPageItemUiState
): Artwork = Artwork(
    id = item.id,
    title = item.title,
    imageUrl = item.imageUrl,
    artist = item.artist,
    date = item.date,
    isBookmarked = item.isBookmarked,
    creditLine = item.creditLine,
    size = item.size,
    gallery = item.gallery,
    materials = item.materials,
    publicationHistory = item.publicationHistory,
    exhibitionHistory = item.exhibitionHistory,
    provenanceText = item.provenanceText
)

fun convertToArtworksPageItemUiState(
    artwork: Artwork,
    onBookmark: (item: ArtworksPageItemUiState) -> Unit
): ArtworksPageItemUiState = ArtworksPageItemUiState(
    id = artwork.id,
    title = artwork.title,
    imageUrl = artwork.imageUrl,
    artist = artwork.artist,
    date = artwork.date,
    isBookmarked = artwork.isBookmarked,
    creditLine = artwork.creditLine,
    size = artwork.size,
    gallery = artwork.gallery,
    materials = artwork.materials,
    publicationHistory = artwork.publicationHistory,
    exhibitionHistory = artwork.exhibitionHistory,
    provenanceText = artwork.provenanceText,
    onBookmark = onBookmark
)

fun convertArtworkListToArtworksPageItemUiStateList(
    artworkList: List<Artwork>,
    onBookmark: (item: ArtworksPageItemUiState) -> Unit
): List<ArtworksPageItemUiState> = artworkList.map {
    convertToArtworksPageItemUiState(
        artwork = it,
        onBookmark = onBookmark
    )
}
