package com.memksim.chickagogallery.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtworkType(
    val id: Int,
    val title: String
): Parcelable
