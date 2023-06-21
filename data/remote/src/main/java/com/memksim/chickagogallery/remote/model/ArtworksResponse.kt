package com.memksim.chickagogallery.remote.model

import com.google.gson.annotations.SerializedName

private const val BASE_URL = "https://www.artic.edu/iiif/2/"
private const val TAIL = "/full/843,/0/default.jpg"

data class ArtworksResponse(
    @SerializedName("data")
    val artworkData: List<ArtworkData>
) {
    data class ArtworkData(
        val id: Int,
        val title: String,
        @SerializedName("date_display")
        val date: String,
        @SerializedName("artist_title")
        val artist: String?,
        @SerializedName("image_id")
        val imageId: String,
        @SerializedName("credit_line")
        val creditLine: String?,
        @SerializedName("dimensions")
        val size: String?,
        @SerializedName("gallery_title")
        val gallery: String?,
        @SerializedName("material_titles")
        val materials: List<String>?,
        @SerializedName("publication_history")
        val publicationHistory: String?,
        @SerializedName("exhibition_history")
        val exhibitionHistory: String?,
        @SerializedName("provenance_text")
        val provenanceText: String?
    )
}

