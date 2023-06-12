package com.memksim.chickagogallery.domain.interactors

import com.memksim.chickagogallery.data.local.entity.Bookmark
import com.memksim.chickagogallery.domain.use_cases.AddToBookmarksUseCase
import com.memksim.chickagogallery.domain.use_cases.RemoveBookmarksUseCase
import javax.inject.Inject

class UpdateBookmarksTableInteractor @Inject constructor(
    private val addToBookmarksUseCase: AddToBookmarksUseCase,
    private val removeBookmarksUseCase: RemoveBookmarksUseCase
) {

    /**
     * Checks if the Bookmark is marked, then saves it in the table, otherwise removes it from the table
     * */
    suspend operator fun invoke(
        bookmark: Bookmark,
    ) {
        if (bookmark.isBookmarked) {
            addToBookmarksUseCase.invoke(
                bookmark = bookmark
            )
        } else {
            removeBookmarksUseCase.invoke(
                bookmark = bookmark
            )
        }
    }

}