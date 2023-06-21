package com.memksim.chickagogallery.domain.use_cases

import com.memksim.chickagogallery.domain.model.ArtworkType
import com.memksim.chickagogallery.remote.repository.RemoteRepository
import javax.inject.Inject

class GetArtworksTypesUseCase @Inject constructor(
    private val repository: com.memksim.chickagogallery.remote.repository.RemoteRepository
) {

    suspend operator fun invoke(): List<ArtworkType> =
        repository.loadArtworkTypes()

}
