package com.memksim.chickagogallery.bookmarks_page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.memksim.chickagogallery.bookmarks_page.BookmarksPageUiState.BookmarksPageItemUiState
import com.memksim.chickagogallery.bookmarks_page.databinding.BookmarkItemLayoutBinding
import com.memksim.chickagogallery.view_extenstion.setBookmarkIconDrawable

internal class BookmarksDiffCallback(
    private val oldList: List<BookmarksPageItemUiState>,
    private val newList: List<BookmarksPageItemUiState>
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

internal class BookmarksAdapter(
    private val onCLick: (stateItem: BookmarksPageItemUiState) -> Unit
) : RecyclerView.Adapter<BookmarksAdapter.BookmarksViewHolder>() {

    var items: MutableList<BookmarksPageItemUiState> = mutableListOf()
        set(value) {
            val result = DiffUtil.calculateDiff(
                BookmarksDiffCallback(
                    field,
                    value
                )
            )
            field = value
            result.dispatchUpdatesTo(this)
        }

    inner class BookmarksViewHolder(
        private val binding: BookmarkItemLayoutBinding
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarksViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BookmarkItemLayoutBinding.inflate(inflater)

        return BookmarksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookmarksViewHolder, position: Int) =
        holder.onBind(position)

    override fun getItemCount(): Int = items.size

}