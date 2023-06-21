package com.memksim.chickagogallery.main_page

import androidx.lifecycle.MutableLiveData
import com.memksim.chickagogallery.base.BaseViewModel
import com.memksim.chickagogallery.base.mvi.UiEvent

internal class MainPageViewModel(

) : BaseViewModel() {

    override val _uiState: MutableLiveData<MainPageUiState> = MutableLiveData()

    override fun obtainUiEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            is MainPageUiEvent.InitialEvent -> {
                loadData()
            }
        }
    }

    private fun loadData() {
        //todo
        //renderState(...)
    }

    override fun handleError(e: Throwable) {
        renderState(_uiState.value?.copy(
            error = true,
            toastMessage = e.message
        ))
    }

    sealed class MainPageUiEvent : UiEvent {
        object InitialEvent : MainPageUiEvent()

    }

}