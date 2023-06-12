package com.memksim.chickagogallery.ui.bookmarks_page

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.memksim.chickagogallery.converters.convertBookmarkListToBookmarksPageItemUiStateList
import com.memksim.chickagogallery.converters.convertBookmarksPageItemUiStateListToBookmarkList
import com.memksim.chickagogallery.converters.convertBookmarksPageItemUiStateToBookmark
import com.memksim.chickagogallery.data.local.entity.Bookmark
import com.memksim.chickagogallery.domain.interactors.GetBookmarksInteractor
import com.memksim.chickagogallery.domain.interactors.UpdateBookmarksTableInteractor
import com.memksim.chickagogallery.ui.base.SearchViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarksViewModel @Inject constructor(
    private val getBookmarksInteractor: GetBookmarksInteractor,
    private val updateBookmarksTableInteractor: UpdateBookmarksTableInteractor
) : SearchViewModel<BookmarksPageUiState, BookmarksPageItemUiState>() {

    fun loadBookmarksList() {
        viewModelScope.launch {
            updateState(bookmarks = getBookmarksInteractor()
            )
        }
    }

    private fun updateState(
        bookmarks: List<Bookmark>
    ) {
        val resultList = convertBookmarkListToBookmarksPageItemUiStateList(
            bookmarksList = bookmarks
        ) {
            removeBookmark(item = it)
        }

        _liveData.value = BookmarksPageUiState(
            itemsList = resultList,
            itemsForSearch = resultList
        )
    }

    private fun removeBookmark(item: BookmarksPageItemUiState) {
        viewModelScope.launch {
            updateBookmarksTableInteractor(bookmark = convertBookmarksPageItemUiStateToBookmark(item))
        }
        val stateList = _liveData.value?.itemsList ?: emptyList()
        updateState(
            bookmarks = convertBookmarksPageItemUiStateListToBookmarkList(
                stateList = stateList.filter {
                    it.id != item.id
                })
        )
    }


    override fun setItemsList(itemsList: List<BookmarksPageItemUiState>) {
        _liveData.value = _liveData.value?.copy(
            itemsForSearch = itemsList
        )
    }

}