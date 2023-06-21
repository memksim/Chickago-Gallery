package com.memksim.chickagogallery.types_page

import androidx.fragment.app.viewModels
import com.memksim.chickagogallery.base.BaseFragment
import com.memksim.chickagogallery.base.mvi.UiState
import com.memksim.chickagogallery.types_page.databinding.FragmentArtworksTypesListBinding

class TypesPageFragment :
    BaseFragment(
        R.layout.fragment_artworks_types_list,
        FragmentArtworksTypesListBinding::bind
    ) {

    private val viewModel by viewModels<TypesPageViewModel>()

    override fun onBind() {
        //TODO("Not yet implemented")
    }

    override fun observeViewState(state: UiState) {
        //TODO("Not yet implemented")
    }

}