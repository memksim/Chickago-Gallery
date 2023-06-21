package com.memksim.chickagogallery.main_page

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.memksim.chickagogallery.base.BaseFragment
import com.memksim.chickagogallery.base.mvi.UiState
import com.memksim.chickagogallery.main_page.databinding.FragmentArtworksListBinding

class MainPageFragment :
    BaseFragment(
        R.layout.fragment_artworks_list,
        FragmentArtworksListBinding::bind
    ) {

    private val viewModel by viewModels<MainPageViewModel>()

    //private val args: ArtworksPageFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //makes a remote request for artworks, according to the received category
        //val artworkType = args.artworkType
        //if(artworkType != null) viewModel.loadArtworks(artworkType)
    }

    override fun onBind() {
        TODO("Not yet implemented")
    }

    override fun observeViewState(state: UiState) {
        TODO("Not yet implemented")
    }

}