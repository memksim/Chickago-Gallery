package com.memksim.chickagogallery.ui.artworks_types_page

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.memksim.chickagogallery.R
import com.memksim.chickagogallery.databinding.FragmentArtworksTypesListBinding
import com.memksim.chickagogallery.converters.convertArtworksTypesPageItemUiStateToArtworkType
import com.memksim.chickagogallery.ui.ParentFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtworksTypesPageFragment :
    ParentFragment<FragmentArtworksTypesListBinding>(
        R.layout.fragment_artworks_types_list,
        FragmentArtworksTypesListBinding::bind
    ) {

    private val viewModel by viewModels<ArtworksTypesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //makes a remote request for artworks categories
        viewModel.loadArtworksTypes()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArtworksTypesAdapter {
            putValueAndNavigate(it)
        }

        viewModel.liveData.observe(viewLifecycleOwner) { state ->
            adapter.items = state.artworkTypesToSearch
            viewBinding.nothingToShowView.layout.isVisible = adapter.items.isEmpty()
        }

        with(viewBinding) {

            searchView.onSearch {
                viewModel.filterList(
                    requestSubstring = it,
                    oldList = viewModel.liveData.value?.artworksTypesList ?: emptyList()
                )
            }

            toBookmarkPage.setOnClickListener {
                navigate(
                    ArtworksTypesPageFragmentDirections
                        .actionArtworksTypesPageFragmentToBookmarksPageFragment()
                )
            }

            artworksTypesRV.run {
                this.adapter = adapter

                val itemDecoration =
                    DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)
                        .also {
                            ResourcesCompat.getDrawable(
                                resources,
                                R.drawable.artworks_types_list_vertical_divider,
                                null
                            )?.let { dr ->
                                it.setDrawable(dr)
                            }
                        }

                addItemDecoration(
                    itemDecoration
                )
            }
        }
    }

    /**
     * Puts argument and navigates to ArtworksPageFragment
     * @param item the object of state item type
     * */
    private fun putValueAndNavigate(item: ArtworksTypesPageItemUiState) {
        val action = ArtworksTypesPageFragmentDirections
            .actionArtworksTypesPageFragmentToArtworksPageFragment(
                convertArtworksTypesPageItemUiStateToArtworkType(item)
            )
        navigate(action)
    }
}