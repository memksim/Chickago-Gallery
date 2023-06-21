package com.memksim.chickagogallery.ui.artworks_page

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.memksim.chickagogallery.R
import com.memksim.chickagogallery.databinding.FragmentArtworksListBinding
import com.memksim.chickagogallery.converters.convertArtworksPageItemUiStateToArtwork
import com.memksim.chickagogallery.converters.convertArtworksPageItemUiStateToArtworkType
import com.memksim.chickagogallery.domain.model.ArtworkType
import com.memksim.chickagogallery.ui.base.ParentFragment

const val ARTWORK_PAGE_TAG = "ArtworksPageFragment"

class ArtworksPageFragment :
    ParentFragment<FragmentArtworksListBinding>(
        R.layout.fragment_artworks_list,
        FragmentArtworksListBinding::bind
    ) {

    private val viewModel by viewModels<ArtworksViewModel>()

    private val args: ArtworksPageFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //makes a remote request for artworks, according to the received category
        val artworkType = args.artworkType
        if(artworkType != null) viewModel.loadArtworks(artworkType)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArtworksAdapter{
            putValueAndNavigate(
                it,
                convertArtworksPageItemUiStateToArtworkType(viewModel.liveData.value)
            )
        }

        viewModel.liveData.observe(viewLifecycleOwner) { state ->
            adapter.items = state.itemsForSearch.toMutableList()
            viewBinding.run {
                nothingToShowView.layout.isVisible = adapter.itemCount == 0
                toolbar.title = state.artworkTypeTitle
            }
        }

        with(viewBinding) {

            searchView.onSearch {str ->
                viewModel.filterList(
                    requestSubstring = str,
                    viewModel.liveData.value?.itemsList ?: emptyList()
                )
            }

            toolbar.run {

                setNavigationOnClickListener {
                    navigateBack(
                        ArtworksPageFragmentDirections.actionArtworksPageFragmentToArtworksTypesPageFragment()
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
     * @param uiItemState the object of state item type
     * @param artworkType the category of artwork's displayed on the screen
     * */
    private fun putValueAndNavigate(
        uiItemState: ArtworksPageItemUiState,
        artworkType: ArtworkType?
    ) {
        if (artworkType != null){
            val action = ArtworksPageFragmentDirections.actionArtworksPageFragmentToArtworkInfoPageFragment(
                artwork = convertArtworksPageItemUiStateToArtwork(uiItemState),
                artworkType = artworkType,
                fromWhat = ARTWORK_PAGE_TAG
            )
            navigate(action)
        }
    }
}