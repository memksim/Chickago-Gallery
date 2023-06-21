package com.memksim.chickagogallery.remote.client

import com.memksim.chickagogallery.remote.model.ArtworksResponse
import com.memksim.chickagogallery.remote.model.ArtworkTypeResponseList
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtworksApi {

    /**
     * @return ArtworkTypeResponseList object that contains a list of ArtworkType objects
     * */
    @GET("artwork-types")
    suspend fun getArtworkTypes(): ArtworkTypeResponseList

    /**
     * @param artworkTypeId the artwork category identifier
     * @param fields sets the artwork fields to get from the response. Shouldn't be changed
     * @return an ArtworkIdsResponseList object which is a set of artwork IDs for the selected category
     * */
    @GET("artworks/search")
    suspend fun getArtworks(
        @Query("query[term][artwork_type_id]") artworkTypeId: Int,
        @Query("fields") fields: String = "id,title,image_id,artist_title,config,material_titles,credit_line,dimensions,date_display,image_id,gallery_title"
    ): ArtworksResponse

}