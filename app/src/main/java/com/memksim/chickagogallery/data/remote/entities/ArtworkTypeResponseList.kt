package com.memksim.chickagogallery.data.remote.entities

import com.google.gson.annotations.SerializedName
import com.memksim.chickagogallery.domain.model.ArtworkType

data class ArtworkTypeResponseList(
    @SerializedName("data")
    val artworkTypes: List<ArtworkType>
)
