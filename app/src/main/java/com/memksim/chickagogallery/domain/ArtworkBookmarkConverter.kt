package com.memksim.chickagogallery.domain

import com.memksim.chickagogallery.data.local.entity.Bookmark
import com.memksim.chickagogallery.domain.model.Artwork

fun convertBookmarkToArtwork(
    bookmark: Bookmark
): Artwork = Artwork(
    id = bookmark.bookmarkId,
    title = bookmark.title,
    imageUrl = bookmark.imageUrl,
    artist = bookmark.artist,
    date = bookmark.date,
    isBookmarked = bookmark.isBookmarked,
    creditLine = bookmark.creditLine,
    size = bookmark.size,
    gallery = bookmark.gallery,
    materials = bookmark.materials,
    publicationHistory = bookmark.publicationHistory,
    exhibitionHistory = bookmark.exhibitionHistory,
    provenanceText = bookmark.provenanceText
)
fun toArtwork(isBookmarked: Boolean = false): Artwork {
    return Artwork(
        id = id,
        title = title,
        date = date,
        artist = artist ?: "Unknown",
        imageUrl = BASE_URL + imageId + TAIL,
        isBookmarked = isBookmarked,
        creditLine = creditLine.orEmpty(),
        size = size.orEmpty(),
        gallery = gallery.orEmpty(),
        materials = materials.orEmpty(),
        publicationHistory = publicationHistory.orEmpty(),
        exhibitionHistory = exhibitionHistory.orEmpty(),
        provenanceText = provenanceText.orEmpty()
    )
}