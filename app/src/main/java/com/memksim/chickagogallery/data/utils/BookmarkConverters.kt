package com.memksim.chickagogallery.data.utils

import com.memksim.chickagogallery.data.firestore.Constants
import com.memksim.chickagogallery.data.local.entity.Bookmark

fun Bookmark.toHashMap(): HashMap<String, Any>{
    val map: HashMap<String, Any> = hashMapOf()
    map[Constants.ARTIST] = artist
    map[Constants.ARTWORK_ID] = bookmarkId
    map[Constants.ARTWORK_TYPE_ID] = artworkTypeId
    map[Constants.ARTWORK_TYPE_TITLE] = artworkTypeTitle
    map[Constants.CREDIT_LINE] = creditLine
    map[Constants.DATE] = date
    map[Constants.EXHIBITION_HISTORY] = exhibitionHistory
    map[Constants.GALLERY] = gallery
    map[Constants.IMAGE_URL] = imageUrl
    map[Constants.IS_BOOKMARKED] = isBookmarked
    map[Constants.MATERIALS] = materials.toTypedArray()
    map[Constants.PROVENANCE_TEXT] = provenanceText
    map[Constants.PUBLICATION_HISTORY] = publicationHistory
    map[Constants.SIZE] = size
    map[Constants.TITLE] = title
    return map
}