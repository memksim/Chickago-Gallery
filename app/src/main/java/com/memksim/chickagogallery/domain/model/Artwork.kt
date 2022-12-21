package com.memksim.chickagogallery.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artwork(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val artist: String,
    val date: String,
    val isBookmarked: Boolean,
    val creditLine: String,
    val size: String,
    val gallery: String,
    val materials: List<String>,
    val publicationHistory: String,
    val exhibitionHistory: String,
    val provenanceText: String
): Parcelable