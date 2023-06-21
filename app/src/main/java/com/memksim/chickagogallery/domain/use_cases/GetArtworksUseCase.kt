package com.memksim.chickagogallery.domain.use_cases

import com.memksim.chickagogallery.domain.model.Artwork
import com.memksim.chickagogallery.remote.repository.RemoteRepository
import javax.inject.Inject

class GetArtworksUseCase @Inject constructor(
    private val repository: com.memksim.chickagogallery.remote.repository.RemoteRepository
) {

    suspend operator fun invoke(artworkTypeId: Int): List<Artwork> =
        repository.loadArtworks(artworkTypeId = artworkTypeId)

}