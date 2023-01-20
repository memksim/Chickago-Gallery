package com.memksim.chickagogallery.ui.utils.extensions

import android.content.res.Resources
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import com.memksim.chickagogallery.R

/**
 * @param isBookmarked - indicates whether the artwork is bookmarked
 * */
fun ImageView.setBookmarkIconDrawable(
    res: Resources,
    isBookmarked: Boolean
){
    this.setImageDrawable(
        ResourcesCompat.getDrawable(
            res,
            if (isBookmarked) {
                R.drawable.ic_bookmark_filled
            } else {
                R.drawable.ic_bookmark
            },
            null
        )
    )
}