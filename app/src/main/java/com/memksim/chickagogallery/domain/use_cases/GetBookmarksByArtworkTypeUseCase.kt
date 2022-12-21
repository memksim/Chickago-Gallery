package com.memksim.chickagogallery.domain.use_cases

import com.memksim.chickagogallery.data.repository.LocalRepository
import javax.inject.Inject

class GetBookmarksByArtworkTypeUseCase @Inject constructor(
    private val repository: LocalRepository
) {

    suspend operator fun invoke(artworkTypeId: Int) =
        repository.getBookmarksListByArtworkType(artworkTypeId = artworkTypeId)

}