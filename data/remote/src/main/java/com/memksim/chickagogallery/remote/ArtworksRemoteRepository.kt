package com.memksim.chickagogallery.remote

import com.memksim.chickagogallery.remote.model.ArtworkTypeResponseList
import com.memksim.chickagogallery.remote.model.ArtworksResponse

interface ArtworksRemoteRepository {

    suspend fun loadArtworkTypes(): ArtworkTypeResponseList

    suspend fun loadArtworksByType(artworkTypeId: Int): ArtworksResponse

}