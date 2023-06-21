package com.memksim.chickagogallery.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.memksim.chickagogallery.base.mvi.UiEvent
import com.memksim.chickagogallery.base.mvi.UiState

abstract class BaseViewModel : ViewModel() {

    protected abstract val _uiState: MutableLiveData<out UiState>
    val uiState: LiveData<out UiState> = _uiState

    abstract fun obtainUiEvent(uiEvent: UiEvent)

    fun renderState(uiState: UiState?) {
        if(uiState != null && _uiState.value != null) {
            _uiState.value = uiState
        }
    }

    abstract fun handleError(e: Throwable)

}