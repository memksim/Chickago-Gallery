package com.memksim.chickagogallery.domain.interactors

import com.memksim.chickagogallery.domain.model.Artwork
import com.memksim.chickagogallery.domain.use_cases.GetArtworksUseCase
import com.memksim.chickagogallery.domain.use_cases.GetBookmarksByArtworkTypeUseCase
import javax.inject.Inject

class LoadArtworksInteractor @Inject constructor(
    private val getArtworksUseCase: GetArtworksUseCase,
    private val getBookmarksByArtworkTypeUseCase: GetBookmarksByArtworkTypeUseCase
) {

    /**
     * Checks if an item in the Artworks list is also an item in the Bookmarks list, then marks it as isBookmarked
     * @param artworkTypeId ArtworkType id - id of Artwork category, also a category for Bookmark
     * @return a list of Artworks that has items marked as iSBookmarked if the condition is true,
     * else if the condition is false, then returns the resulting list of Artworks without changes
     * */
    suspend operator fun invoke(artworkTypeId: Int): List<Artwork> {
        val artworks = getArtworksUseCase.invoke(artworkTypeId = artworkTypeId).toMutableList()
        val bookmarks = getBookmarksByArtworkTypeUseCase.invoke(artworkTypeId = artworkTypeId)

        if (bookmarks.isNotEmpty()) {
            artworks.forEach { artwork ->
                bookmarks.forEach { bookmark ->
                    if (artwork.id == bookmark.bookmarkId) {
                        artworks[artworks.indexOf(artwork)] = artwork.copy(isBookmarked = true)
                    }
                }
            }
        }

        return artworks
    }

}