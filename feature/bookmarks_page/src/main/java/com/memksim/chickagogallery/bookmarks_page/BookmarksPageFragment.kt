package com.memksim.chickagogallery.bookmarks_page

import androidx.fragment.app.viewModels
import com.memksim.chickagogallery.base.BaseFragment
import com.memksim.chickagogallery.base.mvi.UiState
import com.memksim.chickagogallery.bookmarks_page.databinding.FragmentBookmarksListBinding

class BookmarksPageFragment :
    BaseFragment(
        R.layout.fragment_bookmarks_list,
        FragmentBookmarksListBinding::bind
    ) {

    private val viewModel by viewModels<BookmarksViewModel>()

    override fun onBind() {
        //TODO("Not yet implemented")
    }

    override fun observeViewState(state: UiState) {
        //TODO("Not yet implemented")
    }


}