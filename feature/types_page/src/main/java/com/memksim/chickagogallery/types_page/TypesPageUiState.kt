package com.memksim.chickagogallery.types_page

import com.memksim.chickagogallery.base.mvi.ItemUiState
import com.memksim.chickagogallery.base.mvi.UiState

internal data class TypesPageUiState(
    val artworksTypesList: List<TypesPageItemUiState> = emptyList(),
    val artworkTypesToSearch: List<TypesPageItemUiState> = emptyList(),
    override var error: Boolean = false,
    override var loading: Boolean = false,
    override var toastMessage: String? = null,
) : UiState {
    data class TypesPageItemUiState(
        val id: Int,
        val title: String
    ) : ItemUiState
}

