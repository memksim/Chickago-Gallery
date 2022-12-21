package com.memksim.chickagogallery.domain.use_cases

import com.memksim.chickagogallery.domain.model.ArtworkType
import com.memksim.chickagogallery.data.repository.RemoteRepository
import javax.inject.Inject

class GetArtworksTypesUseCase @Inject constructor(
    private val repository: RemoteRepository
) {

    suspend operator fun invoke(): List<ArtworkType> =
        repository.loadArtworkTypes()

}
