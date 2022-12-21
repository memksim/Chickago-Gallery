package com.memksim.chickagogallery.ui.bookmarks_page

import androidx.lifecycle.viewModelScope
import com.memksim.chickagogallery.converters.convertBookmarkListToBookmarksPageItemUiStateList
import com.memksim.chickagogallery.converters.convertBookmarksPageItemUiStateListToBookmarkList
import com.memksim.chickagogallery.converters.convertBookmarksPageItemUiStateToBookmark
import com.memksim.chickagogallery.data.local.entity.Bookmark
import com.memksim.chickagogallery.domain.use_cases.GetBookmarksUseCase
import com.memksim.chickagogallery.domain.use_cases.RemoveBookmarksUseCase
import com.memksim.chickagogallery.ui.SearchViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarksViewModel @Inject constructor(
    private val getBookmarksUseCase: GetBookmarksUseCase,
    private val removeBookmarksUseCase: RemoveBookmarksUseCase
) : SearchViewModel<BookmarksPageUiState, BookmarksPageItemUiState>() {

    fun loadBookmarksList() {
        viewModelScope.launch {
            updateState(bookmarks = getBookmarksUseCase.invoke())
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
            removeBookmarksUseCase.invoke(bookmark = convertBookmarksPageItemUiStateToBookmark(item))
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