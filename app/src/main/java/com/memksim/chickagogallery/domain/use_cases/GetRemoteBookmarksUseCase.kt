package com.memksim.chickagogallery.domain.use_cases

import com.google.firebase.firestore.QuerySnapshot
import com.memksim.chickagogallery.data.local.entity.Bookmark
import com.memksim.chickagogallery.data.repository.FirestoreRepository
import javax.inject.Inject

class GetRemoteBookmarksUseCase @Inject constructor(
    private val repository: FirestoreRepository
) {

    suspend operator fun invoke(
        failureListener: ((e: Exception) -> Unit)?
    ): QuerySnapshot {
        return repository.getBookmarksList(
            failureListener = failureListener
        )
    }

}