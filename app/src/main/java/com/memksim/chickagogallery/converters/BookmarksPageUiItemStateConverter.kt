package com.memksim.chickagogallery.converters

import com.memksim.chickagogallery.data.local.entity.Bookmark
import com.memksim.chickagogallery.domain.model.ArtworkType
import com.memksim.chickagogallery.ui.bookmarks_page.BookmarksPageItemUiState

fun convertBookmarksPageItemUiStateToArtworkType(
    item: BookmarksPageItemUiState?
): ArtworkType? {
    item ?: return null
    return ArtworkType(
        item.artworkTypeId,
        item.artworkTypeTitle
    )
}

fun convertBookmarksPageItemUiStateListToBookmarkList(
    stateList: List<BookmarksPageItemUiState>
): List<Bookmark> = stateList.map {
    convertBookmarksPageItemUiStateToBookmark(it)
}

fun convertBookmarksPageItemUiStateToBookmark(
    item: BookmarksPageItemUiState
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

fun convertBookmarkToBookmarksPageItemUiState(
    bookmark: Bookmark,
    onBookmark: (item: BookmarksPageItemUiState) -> Unit
): BookmarksPageItemUiState = BookmarksPageItemUiState(
    id = bookmark.bookmarkId,
    title = bookmark.title,
    imageUrl = bookmark.imageUrl,
    artist = bookmark.artist,
    date = bookmark.date,
    isBookmarked = bookmark.isBookmarked,
    artworkTypeId = bookmark.artworkTypeId,
    artworkTypeTitle = bookmark.artworkTypeTitle,
    creditLine = bookmark.creditLine,
    size = bookmark.size,
    gallery = bookmark.gallery,
    materials = bookmark.materials,
    publicationHistory = bookmark.publicationHistory,
    exhibitionHistory = bookmark.exhibitionHistory,
    provenanceText = bookmark.provenanceText,
    onBookmark = onBookmark
)

fun convertBookmarkListToBookmarksPageItemUiStateList(
    bookmarksList: List<Bookmark>,
    onBookmark: (item: BookmarksPageItemUiState) -> Unit
): List<BookmarksPageItemUiState> = bookmarksList.map {
    convertBookmarkToBookmarksPageItemUiState(
        bookmark = it,
        onBookmark = onBookmark
    )
}
