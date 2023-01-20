package com.memksim.chickagogallery.domain.use_cases

import com.memksim.chickagogallery.data.local.entity.Bookmark
import com.memksim.chickagogallery.data.repository.FirestoreRepository
import javax.inject.Inject

class RemoveRemoteBookmarkUseCase @Inject constructor(
    private val repository: FirestoreRepository
) {

    suspend operator fun invoke(
        bookmark: Bookmark,
        failureListener: ((e: Exception) -> Unit)?
    ){
        repository.removeBookmark(
            bookmark = bookmark,
            failureListener = failureListener
        )
    }

}