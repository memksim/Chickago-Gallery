package com.memksim.chickagogallery.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.SearchView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.memksim.chickagogallery.databinding.SearchFieldViewBinding
import com.memksim.chickagogallery.R

class SearchFieldView(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
) : ConstraintLayout(
    context,
    attrs,
    defStyleAttr,
    defStyleRes
) {
    private val binding: SearchFieldViewBinding

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        0
    )

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.search_field_view, this, true)
        binding = SearchFieldViewBinding.bind(this)
        initAttrs(
            attrs,
            defStyleAttr,
            defStyleRes
        )
    }

    fun onSearch(callback: (str: String) -> Unit) {
        with(binding) {
            search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    hint.isVisible = p0?.length == 0
                    callback(p0.toString())
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    hint.isVisible = p0?.length == 0
                    if((p0?.length ?: 0) != 1) {
                        callback(p0.toString())
                    }
                    return true
                }

            })
        }


    }

    private fun initAttrs(
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) {
        if (attrs == null) return
        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.SearchFieldView,
            defStyleAttr,
            defStyleRes
        )

        with(binding) {
            val text = typedArray.getString(R.styleable.SearchFieldView_hint_text)
            hint.hint = text ?: context.getString(R.string.search_view_default_hint)

        }

        typedArray.recycle()
    }

}