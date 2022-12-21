package com.memksim.chickagogallery.data.repository

import com.memksim.chickagogallery.data.remote.client.ArtworksApi
import com.memksim.chickagogallery.data.remote.entities.ArtworkData
import com.memksim.chickagogallery.domain.model.Artwork
import com.memksim.chickagogallery.domain.model.ArtworkType
import com.memksim.chickagogallery.data.remote.entities.ArtworkTypeResponseList
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val api: ArtworksApi
) {

    suspend fun loadArtworkTypes(): List<ArtworkType> {
        val response: ArtworkTypeResponseList = api.getArtworkTypes()

        return response.artworkTypes
    }

    suspend fun loadArtworks(
        artworkTypeId: Int
    ): List<Artwork> {
        val responseList: List<ArtworkData> =
            api.getArtworks(artworkTypeId = artworkTypeId).artworkData

        return responseList.map {
            it.toArtwork()
        }
    }
}