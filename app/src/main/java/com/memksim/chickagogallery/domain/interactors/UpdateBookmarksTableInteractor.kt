package com.memksim.chickagogallery.domain.interactors

import com.memksim.chickagogallery.data.local.entity.Bookmark
import com.memksim.chickagogallery.domain.use_cases.AddToBookmarksUseCase
import com.memksim.chickagogallery.domain.use_cases.AddToRemoteBookmarksUseCase
import com.memksim.chickagogallery.domain.use_cases.RemoveBookmarksUseCase
import javax.inject.Inject

class UpdateBookmarksTableInteractor @Inject constructor(
    private val addToBookmarksUseCase: AddToBookmarksUseCase,
    private val addToRemoteBookmarksUseCase: AddToRemoteBookmarksUseCase,
    private val removeBookmarksUseCase: RemoveBookmarksUseCase,
    private val removeRemoteBookmarksUseCase: AddToRemoteBookmarksUseCase
) {

    /**
     * Checks if the Bookmark is marked, then saves it in the table, otherwise removes it from the table
     * */
    suspend operator fun invoke(
        bookmark: Bookmark,
        isOnline: Boolean,
        failureListener: ((e: Exception) -> Unit)?
    ) {
        if (bookmark.isBookmarked) {
            if (isOnline) {
                addToRemoteBookmarksUseCase.invoke(
                    bookmark = bookmark,
                    failureListener = failureListener
                )
            }else{
                addToBookmarksUseCase.invoke(
                    bookmark = bookmark
                )
            }
        } else {
            if (isOnline) {
                removeRemoteBookmarksUseCase.invoke(
                    bookmark = bookmark,
                    failureListener = failureListener
                )
            }else{
                removeBookmarksUseCase.invoke(
                    bookmark = bookmark
                )
            }
        }
    }

}