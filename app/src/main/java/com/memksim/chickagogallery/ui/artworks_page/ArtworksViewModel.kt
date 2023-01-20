package com.memksim.chickagogallery.ui.artworks_page

import androidx.lifecycle.viewModelScope
import com.memksim.chickagogallery.converters.convertArtworkListToArtworksPageItemUiStateList
import com.memksim.chickagogallery.converters.convertArtworksPageItemUiStateToArtworkType
import com.memksim.chickagogallery.converters.convertArtworksPageItemUiStateToBookmark
import com.memksim.chickagogallery.domain.interactors.LoadArtworksInteractor
import com.memksim.chickagogallery.domain.interactors.UpdateBookmarksTableInteractor
import com.memksim.chickagogallery.domain.model.Artwork
import com.memksim.chickagogallery.domain.model.ArtworkType
import com.memksim.chickagogallery.ui.base.SearchViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class ArtworksViewModel @Inject constructor(
    private val loadArtworksInteractor: LoadArtworksInteractor,
    private val updateBookmarksTableInteractor: UpdateBookmarksTableInteractor
) : SearchViewModel<ArtworksPageUiState, ArtworksPageItemUiState>() {

    /**
     * Checks if the state is not null, then it is not necessary to download data from the network
     * */
    fun loadArtworks(artworkType: ArtworkType) {
        if (_liveData.value == null) {
            viewModelScope.launch {
                updateState(
                    artworks = loadData(artworkType.id),
                    artworkType = artworkType
                )
            }
        }
    }

    private suspend fun loadData(artworkTypeId: Int): List<Artwork> =
        loadArtworksInteractor.invoke(artworkTypeId = artworkTypeId)


    private fun updateState(
        artworks: List<Artwork>,
        artworkType: ArtworkType
    ) {
        val resultList = convertArtworkListToArtworksPageItemUiStateList(
            artworkList = artworks
        ) { stateItem ->

            updateState(
                artworks = updateStateList(
                    artworks = artworks,
                    stateItem = stateItem
                ),
                artworkType = artworkType
            )

            updateBookmarkLocal(stateItem)
        }

        _liveData.value = ArtworksPageUiState(
            itemsList = resultList,
            itemsForSearch = resultList,
            artworkTypeId = artworkType.id,
            artworkTypeTitle = artworkType.title
        )
    }

    private fun updateStateList(
        artworks: List<Artwork>,
        stateItem: ArtworksPageItemUiState
    ): List<Artwork> {
        val newList: MutableList<Artwork> = mutableListOf()
        artworks.forEach {
            newList.add(
                if (it.id == stateItem.id) {
                    it.copy(isBookmarked = stateItem.isBookmarked)
                } else {
                    it
                }
            )
        }
        return newList
    }

    private fun updateBookmarkLocal(
        itemUiState: ArtworksPageItemUiState
    ) {
        val artworkType = convertArtworksPageItemUiStateToArtworkType(_liveData.value) ?: return

        val bookmark = convertArtworksPageItemUiStateToBookmark(
            itemState = itemUiState,
            artworkType = artworkType
        )

        viewModelScope.launch {
            updateBookmarksTableInteractor.invoke(
                bookmark = bookmark,
                isOnline = true, //TODO
                failureListener = null
            )
        }
    }

    override fun setItemsList(itemsList: List<ArtworksPageItemUiState>) {
        _liveData.value = _liveData.value?.copy(
            itemsForSearch = itemsList
        )
    }

}