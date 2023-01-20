package com.memksim.chickagogallery.ui.base

import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding

abstract class ParentFragment<T : ViewBinding>(
    @LayoutRes layout: Int,
    binder: (View) -> T
) : Fragment(layout) {

    val viewBinding by viewBinding(binder)

    fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

    fun navigateUp() {
        findNavController().navigateUp()
    }

    fun navigateBack(action: NavDirections){
        findNavController().navigate(action)
    }

    fun showData(data: String){
        Toast.makeText(requireContext(), data, Toast.LENGTH_SHORT).show()
    }

}