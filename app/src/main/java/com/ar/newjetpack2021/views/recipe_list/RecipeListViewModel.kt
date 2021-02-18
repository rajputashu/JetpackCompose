package com.ar.newjetpack2021.views.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ar.newjetpack2021.models.dto.RecipeResultDto
import com.ar.newjetpack2021.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
@Inject
constructor(
    @Named("auth_token") private val token: String,
    private val networkRepository: NetworkRepository
) : ViewModel() {

    val recipeList: MutableState<List<RecipeResultDto>> = mutableStateOf(arrayListOf())
    val searchQuery = mutableStateOf("")
    val selectedCategory: MutableState<FoodCategory?> = mutableStateOf(null)

    init {
        onSearchRecipe()
    }

    fun onSearchRecipe() {

        viewModelScope.launch {
            val data = networkRepository.search(token, 1, searchQuery.value)
            data.results?.let {
                recipeList.value = it
            }
        }
    }

    fun onQueryChanged(newQueryText: String) {
        getFoodCategory(newQueryText)?.let {
            selectedCategory.value = it
        }
        searchQuery.value = newQueryText
    }
}