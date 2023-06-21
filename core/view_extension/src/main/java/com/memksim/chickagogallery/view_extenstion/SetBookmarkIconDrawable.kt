package com.memksim.chickagogallery.view_extenstion

import android.content.res.Resources
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat

/**
 * @param isBookmarked - indicates whether the artwork is bookmarked
 * */
fun ImageView.setBookmarkIconDrawable(
    res: Resources,
    isBookmarked: Boolean
) {
    this.setImageDrawable(
        ResourcesCompat.getDrawable(
            res,
            if (isBookmarked)
                R.drawable.ic_bookmark_filled
            else
                R.drawable.ic_bookmark,
            null
        )
    )
}