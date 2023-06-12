package com.memksim.chickagogallery.domain.interactors

import com.memksim.chickagogallery.data.local.entity.Bookmark
import com.memksim.chickagogallery.domain.use_cases.GetBookmarksUseCase
import javax.inject.Inject

class GetBookmarksInteractor @Inject constructor(
    private val getBookmarksUseCase: GetBookmarksUseCase
) {

    suspend operator fun invoke(): List<Bookmark> {
        return getBookmarksUseCase.invoke()
    }

}