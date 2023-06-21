package com.memksim.chickagogallery.ui.artworks_types_page

import androidx.lifecycle.*
import com.memksim.chickagogallery.converters.convertArtworkTypesListToArtworksTypesPageItemUiStateList
import com.memksim.chickagogallery.domain.model.ArtworkType
import com.memksim.chickagogallery.domain.use_cases.GetArtworksTypesUseCase
import com.memksim.chickagogallery.ui.base.SearchViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArtworksTypesViewModel @Inject constructor(
    private val getArtworksTypesUseCase: GetArtworksTypesUseCase
) : SearchViewModel<ArtworksTypesPageUiState, ArtworksTypesPageItemUiState>() {

    fun loadArtworksTypes() {
        viewModelScope.launch {
            updateState(loadData())
        }
    }

    private suspend fun loadData(): List<ArtworkType> =
        getArtworksTypesUseCase.invoke()

    private fun updateState(
        artworkTypesFromNet: List<ArtworkType>
    ) {
        val artworkTypes =
            convertArtworkTypesListToArtworksTypesPageItemUiStateList(artworkTypesFromNet)
        _liveData.value = ArtworksTypesPageUiState(
            artworksTypesList = artworkTypes,
            artworkTypesToSearch = artworkTypes
        )
    }

    override fun setItemsList(itemsList: List<ArtworksTypesPageItemUiState>) {
        _liveData.value = _liveData.value?.copy(
            artworkTypesToSearch = itemsList
        )
    }

}