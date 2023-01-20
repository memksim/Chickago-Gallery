package com.memksim.chickagogallery.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memksim.chickagogallery.ui.utils.UI_DEBOUNCE
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

abstract class SearchViewModel<T : UiState, E : ItemUiState> : ViewModel() {

    protected val _liveData: MutableLiveData<T> by lazy {
        MutableLiveData<T>()
    }
    val liveData: LiveData<T> = _liveData

    /**
     * Must update the ui state in own body
     * @param itemsList - list that contains only suitable values
     * */
    abstract fun setItemsList(itemsList: List<E>)

    /**
     * Uses for filter elements from state by part of word
     * @param requestSubstring substring that is contained in the name of the searched ArtworkType item
     * */
    fun filterList(
        requestSubstring: String,
        oldList: List<E>
    ) {
        viewModelScope.launch {
            //debounce
            delay(UI_DEBOUNCE)
            //list of Artwork items which does not change
            if (oldList.isEmpty()) this.cancel()

            //updates the mutable list in the state
            setItemsList(oldList.filter {
                it.itemTitle.lowercase(Locale.getDefault())
                    .contains(requestSubstring.lowercase(Locale.getDefault()))
            })
        }
    }
}