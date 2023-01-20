package com.memksim.chickagogallery.ui.artworks_page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.memksim.chickagogallery.databinding.ArtworkItemLayoutBinding
import com.memksim.chickagogallery.ui.utils.extensions.setBookmarkIconDrawable

class ArtworksDiffCallback(
    private val oldList: List<ArtworksPageItemUiState>,
    private val newList: List<ArtworksPageItemUiState>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}

class ArtworksAdapter(
    private val onCLick: (artwork: ArtworksPageItemUiState) -> Unit
) : RecyclerView.Adapter<ArtworksAdapter.ArtworksViewHolder>() {

    var items: MutableList<ArtworksPageItemUiState> = mutableListOf()
        set(value) {
            val result = DiffUtil.calculateDiff(
                ArtworksDiffCallback(
                    field,
                    value
                )
            )
            field = value
            result.dispatchUpdatesTo(this)
        }

    inner class ArtworksViewHolder(
        private val binding: ArtworkItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) {
            with(binding) {
                var item = items[position]
                title.text = item.title
                date.text = item.date
                //load image using coil
                artworkImage.load(item.imageUrl)
                artist.text = item.artist

                bookmarkIcon.run {
                    setBookmarkIconDrawable(
                        res = resources,
                        isBookmarked = item.isBookmarked
                    )

                    setOnClickListener {
                        item = item.copy(isBookmarked = !item.isBookmarked)
                        setBookmarkIconDrawable(
                            res = resources,
                            isBookmarked = item.isBookmarked
                        )
                        items[position] = item
                        item.onBookmark(item)
                    }
                }

                layout.setOnClickListener {
                    onCLick(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtworksViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArtworkItemLayoutBinding.inflate(inflater)

        return ArtworksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtworksViewHolder, position: Int) =
        holder.onBind(position)

    override fun getItemCount(): Int = items.size

}