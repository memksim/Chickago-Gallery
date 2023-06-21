package com.memksim.chickagogallery.artwork_page.artworkInfo_page

import androidx.lifecycle.MutableLiveData
import com.memksim.chickagogallery.base.BaseViewModel
import com.memksim.chickagogallery.base.mvi.UiEvent

class ArtworkViewModel: BaseViewModel() {

    override val _uiState: MutableLiveData<ArtworkPageUiState> = MutableLiveData()

    override fun obtainUiEvent(uiEvent: UiEvent) {
        //TODO("Not yet implemented")
    }

    override fun handleError(e: Throwable) {
        //TODO("Not yet implemented")
    }


}