package com.memksim.chickagogallery.artwork_page.artworkInfo_page

import androidx.fragment.app.viewModels
import com.memksim.chickagogallery.artwork_page.R
import com.memksim.chickagogallery.artwork_page.databinding.FragmentArtworkInfoPageBinding
import com.memksim.chickagogallery.base.BaseFragment
import com.memksim.chickagogallery.base.mvi.UiState

class ArtworkPageFragment : BaseFragment(
    R.layout.fragment_artwork_info_page,
    FragmentArtworkInfoPageBinding::bind
) {

    private val viewModel: ArtworkViewModel by viewModels()
    override fun onBind() {
        //TODO("Not yet implemented")
    }

    override fun observeViewState(state: UiState) {
        //TODO("Not yet implemented")
    }

}