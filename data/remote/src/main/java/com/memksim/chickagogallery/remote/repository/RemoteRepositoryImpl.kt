package com.memksim.chickagogallery.remote.repository

import com.memksim.chickagogallery.remote.ArtworksRemoteRepository
import com.memksim.chickagogallery.remote.client.ArtworksApi
import com.memksim.chickagogallery.remote.model.ArtworksResponse
import com.memksim.chickagogallery.remote.model.ArtworkTypeResponseList

internal class RemoteRepositoryImpl(
    private val api: ArtworksApi
): ArtworksRemoteRepository {

    override suspend fun loadArtworkTypes(): ArtworkTypeResponseList = api.getArtworkTypes()
    override suspend fun loadArtworksByType(artworkTypeId: Int): ArtworksResponse = api.getArtworks(artworkTypeId = artworkTypeId)

}