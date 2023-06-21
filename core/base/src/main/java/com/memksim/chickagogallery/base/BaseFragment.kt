package com.memksim.chickagogallery.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.memksim.chickagogallery.base.mvi.UiState

abstract class BaseFragment(
    @LayoutRes layout: Int,
    binder: (View) -> ViewBinding
) : Fragment(layout) {

    val viewBinding by viewBinding(binder)

    abstract fun onBind()

    abstract fun observeViewState(state: UiState)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBind()
    }

}