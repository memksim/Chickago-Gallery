package com.memksim.chickagogallery.ui.artworkInfo_page

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.memksim.chickagogallery.R
import com.memksim.chickagogallery.databinding.FragmentArtworkInfoPageBinding
import com.memksim.chickagogallery.converters.convertArtworkInfoPageItemUiStateToArtworkType
import com.memksim.chickagogallery.ui.ParentFragment
import com.memksim.chickagogallery.ui.bookmarks_page.BOOKMARK_PAGE_TAG
import com.memksim.chickagogallery.ui.setBookmarkIconDrawable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtworkInfoPageFragment : ParentFragment<FragmentArtworkInfoPageBinding>(
    R.layout.fragment_artwork_info_page,
    FragmentArtworkInfoPageBinding::bind
) {

    private val viewModel: ArtworkInfoViewModel by viewModels()

    private val args: ArtworkInfoPageFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setState(
            artwork = args.artwork,
            artworkType = args.artworkType
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.liveData.observe(viewLifecycleOwner){state ->
            val itemState = state.itemState

            with(viewBinding) {

                toolbar.setNavigationOnClickListener {
                    navigateBack(
                        when(args.fromWhat){
                            BOOKMARK_PAGE_TAG -> {
                                ArtworkInfoPageFragmentDirections
                                    .actionArtworkInfoPageFragmentToBookmarksPageFragment()
                            }
                            else -> {
                                ArtworkInfoPageFragmentDirections
                                    .actionArtworkInfoPageFragmentToArtworksPageFragment(
                                        convertArtworkInfoPageItemUiStateToArtworkType(itemState)
                                    )
                            }
                        }

                    )
                }

                artworkImage.load(itemState.imageUrl)
                artworkTitle.text = itemState.title
                toolbar.title = itemState.title
                dateTitle.text = itemState.date
                artistNameTitle.text = itemState.artist
                artworkTypeInfo.text = itemState.artworkTypeTitle

                if(itemState.materials.isNotEmpty()){
                    val materials: String = TextUtils.join(", ", itemState.materials)
                    materialsInfo.text = materials
                }else{
                    materialsTitle.isVisible = false
                }

                val sizes = itemState.size
                sizesInfo.text = sizes
                sizesInfo.isVisible = sizes.isNotBlank()

                val gallery = itemState.gallery
                galleryInfo.text = gallery
                galleryInfo.isVisible = gallery.isNotBlank()

                val description = "${itemState.publicationHistory} \n ${itemState.exhibitionHistory} \n ${itemState.provenanceText}"
                artworkLargeInfo.text = description
                artworkLargeInfo.isVisible = description.isNotBlank()

                creditLineInfo.text = itemState.creditLine

                bookmarkIcon.run{
                    setBookmarkIconDrawable(
                        res = resources,
                        isBookmarked = itemState.isBookmarked
                    )

                    setOnClickListener {
                        state.onBookmark()
                        setBookmarkIconDrawable(
                            res = resources,
                            isBookmarked = !itemState.isBookmarked
                        )
                    }
                }

            }
        }
    }

}