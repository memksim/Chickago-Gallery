package com.memksim.chickagogallery.domain.interactors

import com.memksim.chickagogallery.data.local.entity.Bookmark
import com.memksim.chickagogallery.domain.use_cases.GetBookmarksUseCase
import com.memksim.chickagogallery.domain.use_cases.GetRemoteBookmarksUseCase
import javax.inject.Inject

class GetBookmarksInteractor @Inject constructor(
    private val getBookmarksUseCase: GetBookmarksUseCase,
    private val getRemoteBookmarksUseCase: GetRemoteBookmarksUseCase
) {

    suspend operator fun invoke(
         isOnline: Boolean,
         failureListener: ((e: Exception) -> Unit)?
     ): List<Bookmark> {
        return if (isOnline) {
            getRemoteBookmarksUseCase.invoke(
                failureListener = failureListener
            ).toObjects(Bookmark::class.java).filter {
                it.bookmarkId != 0
            }
        } else {
            getBookmarksUseCase.invoke()
        }
    }

}