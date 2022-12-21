package com.memksim.chickagogallery.converters

import com.memksim.chickagogallery.data.local.entity.Bookmark
import com.memksim.chickagogallery.domain.model.Artwork
import com.memksim.chickagogallery.domain.model.ArtworkType
import com.memksim.chickagogallery.ui.artworkInfo_page.ArtworkInfoPageItemUiState

fun convertArtworkInfoPageItemUiStateToBookmark(
    item: ArtworkInfoPageItemUiState
): Bookmark = Bookmark(
    bookmarkId = item.id,
    title = item.title,
    imageUrl = item.imageUrl,
    artist = item.artist,
    date = item.date,
    isBookmarked = item.isBookmarked,
    artworkTypeId = item.artworkTypeId,
    artworkTypeTitle = item.artworkTypeTitle,
    creditLine = item.creditLine,
    size = item.size,
    gallery = item.gallery,
    materials = item.materials,
    publicationHistory = item.publicationHistory,
    exhibitionHistory = item.exhibitionHistory,
    provenanceText = item.provenanceText
)

fun convertArtworkInfoPageItemUiStateToArtworkType(
    item: ArtworkInfoPageItemUiState
): ArtworkType = ArtworkType(
    id = item.artworkTypeId,
    title = item.artworkTypeTitle
)

fun convertToArtworkInfoPageItemUiState(
    artwork: Artwork,
    artworkType: ArtworkType
): ArtworkInfoPageItemUiState = ArtworkInfoPageItemUiState(
    id = artwork.id,
    title = artwork.title,
    imageUrl = artwork.imageUrl,
    artist = artwork.artist,
    date = artwork.date,
    artworkTypeId = artworkType.id,
    artworkTypeTitle = artworkType.title,
    isBookmarked = artwork.isBookmarked,
    creditLine = artwork.creditLine,
    size = artwork.size,
    gallery = artwork.gallery,
    materials = artwork.materials,
    publicationHistory = artwork.publicationHistory,
    exhibitionHistory = artwork.exhibitionHistory,
    provenanceText = artwork.provenanceText
)
