package com.memksim.chickagogallery.base.mvi

interface UiState {
    var error: Boolean
    var loading: Boolean
    var toastMessage: String?
}
