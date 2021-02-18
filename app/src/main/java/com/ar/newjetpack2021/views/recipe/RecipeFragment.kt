package com.ar.newjetpack2021.views.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

class RecipeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*val view = inflater.inflate(R.layout.fragment_recipe_list, container, false)        
        return super.onCreateView(inflater, container, savedInstanceState)*/
        return ComposeView(requireContext()).apply {
            setContent {
                Text(text = "Hello Welcome to new Recipe Fragment...")
            }
        }
    }
}