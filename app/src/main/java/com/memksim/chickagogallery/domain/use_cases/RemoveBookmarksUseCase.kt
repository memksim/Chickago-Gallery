package com.memksim.chickagogallery.domain.use_cases

import com.memksim.chickagogallery.data.local.entity.Bookmark
import com.memksim.chickagogallery.data.repository.LocalRepository
import javax.inject.Inject

class RemoveBookmarksUseCase @Inject constructor(
    private val repository: LocalRepository
) {

    suspend operator fun invoke(bookmark: Bookmark) =
        repository.removeBookmarks(bookmark = bookmark)

}