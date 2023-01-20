package com.memksim.chickagogallery.ui.artworkInfo_page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memksim.chickagogallery.converters.convertArtworkInfoPageItemUiStateToBookmark
import com.memksim.chickagogallery.converters.convertToArtworkInfoPageItemUiState
import com.memksim.chickagogallery.domain.interactors.UpdateBookmarksTableInteractor
import com.memksim.chickagogallery.domain.model.Artwork
import com.memksim.chickagogallery.domain.model.ArtworkType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtworkInfoViewModel @Inject constructor(
    private val updateBookmarksTableInteractor: UpdateBookmarksTableInteractor
) : ViewModel() {

    private val _liveData: MutableLiveData<ArtworkInfoPageUiState> by lazy {
        MutableLiveData<ArtworkInfoPageUiState>()
    }
    val liveData: LiveData<ArtworkInfoPageUiState> = _liveData

    fun setState(
        artwork: Artwork,
        artworkType: ArtworkType
    ) {
        updateState(
            artwork = artwork,
            artworkType = artworkType
        )
    }

    private fun updateState(
        artwork: Artwork,
        artworkType: ArtworkType
    ) {
        _liveData.value = ArtworkInfoPageUiState(
            convertToArtworkInfoPageItemUiState(
                artwork = artwork,
                artworkType = artworkType
            )
        ) {
            updateBookmark(itemState = _liveData.value?.itemState)
            updateState(
                artwork.copy(isBookmarked = !artwork.isBookmarked),
                artworkType
            )
        }
    }


    private fun updateBookmark(itemState: ArtworkInfoPageItemUiState?) {
        itemState ?: return
        viewModelScope.launch {
            updateBookmarksTableInteractor.invoke(
                bookmark = convertArtworkInfoPageItemUiStateToBookmark(
                    item = itemState.copy(isBookmarked = !itemState.isBookmarked)
                ),
                isOnline = true, //TODO
                failureListener = null
            )
        }
    }
}