package com.memksim.chickagogallery.ui.bookmarks_page

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.memksim.chickagogallery.R
import com.memksim.chickagogallery.databinding.FragmentBookmarksListBinding
import com.memksim.chickagogallery.converters.convertBookmarksPageItemUiStateToArtworkType
import com.memksim.chickagogallery.converters.convertBookmarksPageItemUiStateToBookmark
import com.memksim.chickagogallery.domain.convertBookmarkToArtwork
import com.memksim.chickagogallery.domain.model.ArtworkType
import com.memksim.chickagogallery.ui.ParentFragment
import dagger.hilt.android.AndroidEntryPoint

const val BOOKMARK_PAGE_TAG = "BookmarksPageFragment"

@AndroidEntryPoint
class BookmarksPageFragment :
    ParentFragment<FragmentBookmarksListBinding>(
        R.layout.fragment_bookmarks_list,
        FragmentBookmarksListBinding::bind
    ) {

    private val viewModel by viewModels<BookmarksViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadBookmarksList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BookmarksAdapter {
            putValueAndNavigate(
                itemUiState = it,
                artworkType = convertBookmarksPageItemUiStateToArtworkType(it)
            )
        }

        viewModel.liveData.observe(viewLifecycleOwner) { state ->
            adapter.items = state.itemsForSearch.toMutableList()

            viewBinding.run {
                nothingSavedView.layout.isVisible = adapter.itemCount == 0
            }
        }

        with(viewBinding) {

            searchView.onSearch { str ->
                viewModel.filterList(
                    requestSubstring = str,
                    viewModel.liveData.value?.itemsList ?: emptyList()
                )
            }

            toolbar.run {

                setNavigationOnClickListener {
                    navigateBack(
                        BookmarksPageFragmentDirections.actionBookmarksPageFragmentToArtworksTypesPageFragment()
                    )
                }
            }

            artworksRV.run {
                this.adapter = adapter

                val horizontalDivider =
                    DividerItemDecoration(requireContext(), RecyclerView.HORIZONTAL)
                        .also {
                            ResourcesCompat.getDrawable(
                                resources,
                                R.drawable.horizontal_divider,
                                null
                            )?.let { dr ->
                                it.setDrawable(dr)
                            }
                        }
                addItemDecoration(
                    horizontalDivider
                )

                val verticalDivider =
                    DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)
                        .also {
                            ResourcesCompat.getDrawable(
                                resources,
                                R.drawable.vertical_divider,
                                null
                            )?.let { dr ->
                                it.setDrawable(dr)
                            }
                        }
                addItemDecoration(
                    verticalDivider
                )
            }
        }

    }

    /**
     * Puts argument and navigates to ArtworkInfoPageFragment
     * @param itemUiState the object of state item type
     * */
    private fun putValueAndNavigate(
        itemUiState: BookmarksPageItemUiState,
        artworkType: ArtworkType?
    ) {
        if (artworkType != null) {
            val action = BookmarksPageFragmentDirections
                .actionBookmarksPageFragmentToArtworkInfoPageFragment(
                    artwork = convertBookmarkToArtwork(
                        convertBookmarksPageItemUiStateToBookmark(
                            itemUiState
                        )
                    ),
                    artworkType = artworkType,
                    BOOKMARK_PAGE_TAG
                )
            navigate(action)
        }
    }

}