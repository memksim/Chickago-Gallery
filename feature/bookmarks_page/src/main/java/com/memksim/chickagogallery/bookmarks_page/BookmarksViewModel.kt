package com.memksim.chickagogallery.bookmarks_page

import androidx.lifecycle.MutableLiveData
import com.memksim.chickagogallery.base.BaseViewModel
import com.memksim.chickagogallery.base.mvi.UiEvent

internal class BookmarksViewModel (

) : BaseViewModel() {

    override val _uiState: MutableLiveData<BookmarksPageUiState> = MutableLiveData()

    override fun obtainUiEvent(uiEvent: UiEvent) {
        //TODO("Not yet implemented")
    }

    override fun handleError(e: Throwable) {
        //TODO("Not yet implemented")
    }


}