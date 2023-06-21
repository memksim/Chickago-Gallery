package com.memksim.chickagogallery.remote.model

import com.google.gson.annotations.SerializedName

data class ArtworkTypeResponseList(
    @SerializedName("data")
    val artworkTypes: List<ArtworkType>
) {
    data class ArtworkType(
        val id: Int,
        val title: String
    )
}
