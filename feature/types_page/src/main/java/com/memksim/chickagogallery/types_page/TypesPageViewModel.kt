package com.memksim.chickagogallery.types_page

import androidx.lifecycle.MutableLiveData
import com.memksim.chickagogallery.base.BaseViewModel
import com.memksim.chickagogallery.base.mvi.UiEvent

internal class TypesPageViewModel: BaseViewModel() {

    override val _uiState: MutableLiveData<TypesPageUiState> = MutableLiveData()

    override fun obtainUiEvent(uiEvent: UiEvent) {
        //TODO("Not yet implemented")
    }

    override fun handleError(e: Throwable) {
        //todo
    }

}