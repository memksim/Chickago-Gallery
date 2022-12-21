package com.memksim.chickagogallery.ui.artworks_types_page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.memksim.chickagogallery.databinding.ArtworkTypeItemLayoutBinding

class ArtworksDiffCallback(
    private val oldList: List<ArtworksTypesPageItemUiState>,
    private val newList: List<ArtworksTypesPageItemUiState>
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

class ArtworksTypesAdapter(
    private val onCLick: (item: ArtworksTypesPageItemUiState) -> Unit
) : RecyclerView.Adapter<ArtworksTypesAdapter.ArtworksTypesViewHolder>() {

    var items: List<ArtworksTypesPageItemUiState> = mutableListOf()
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

    inner class ArtworksTypesViewHolder(
        val binding: ArtworkTypeItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) {
            with(binding) {
                val item = items[position]
                title.text = item.title

                layout.setOnClickListener {
                    onCLick(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtworksTypesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArtworkTypeItemLayoutBinding.inflate(inflater)

        return ArtworksTypesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtworksTypesViewHolder, position: Int) {
        with(holder) {
            onBind(position)


        }
    }

    override fun getItemCount(): Int = items.size

}