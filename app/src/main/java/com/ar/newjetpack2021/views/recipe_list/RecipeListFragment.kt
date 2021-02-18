package com.ar.newjetpack2021.views.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ar.newjetpack2021.views.ui_components.CategoryChipsWidget
import com.ar.newjetpack2021.views.ui_components.RecipeCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    //USE activityViewModels if you want to use and share same ViewModel across different fragments
    //    val viewModel: RecipeListViewModel by activityViewModels()

    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(requireActivity()).apply {
            setContent {
                Column {
                    Surface(modifier = Modifier
                        .fillMaxWidth(),
                        //                        color = MaterialTheme.colors.primary,
                        color = Color.White,
                        elevation = 8.dp
                    ) {
                        Column {
                            SearchWidget()
                            CategoryChipList()
                        }
                    }

                    LazyColumn {
                        itemsIndexed(items = viewModel.recipeList.value) { index, model ->
                            RecipeCard(recipeMo = model, onClick = { })
                        }
                    }
                }

                /*val result = viewModel.recipeList.value
                for (dto: RecipeResultDto in result) {
                    Log.e("APIResult", "Result ${dto.title}")
                }
                Column(
                    modifier = Modifier
                        .padding(16.dp)
//                        .background(Color.Magenta)
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Text(text = "Welcome to LIST of Recipes")
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(onClick = {
                        findNavController().navigate(R.id.action_view_recipe)
                    }) {
                        Text(
                            text = "View Details Of Recipe",
                            style = TextStyle(
                                color = Color(0xFFFFBB00),
                                fontSize = TextUnit.Companion.Sp(19)
                            )
                        )
                    }
                }*/
            }
        }

        /*val view = inflater.inflate(R.layout.fragment_recipe_list, container, false)
        view.findViewById<ComposeView>(R.id.composeView).setContent {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = "Welcome to jungle of Recipe")
                Spacer(modifier = Modifier.padding(10.dp))
                CircularProgressIndicator()
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Text(text = "Great...")
                Spacer(modifier = Modifier.padding(top = 10.dp))
                HorizontalDottedProgressBar()
            }
        }
        return view*/
    }

    @Composable
    private fun SearchWidget() {
        TextField(value = viewModel.searchQuery.value, onValueChange = { newValue ->
            viewModel.onQueryChanged(newValue)
        },
            modifier = Modifier.fillMaxWidth(0.9f),
            label = { Text(text = "Search") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search,
                keyboardType = KeyboardType.Text
            ),
            leadingIcon = { Icon(Icons.Filled.Search, "") },
            textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
            backgroundColor = MaterialTheme.colors.surface,
            onImeActionPerformed = { action, softKeyController ->
                if (action == ImeAction.Search) {
                    viewModel.apply {
                        this.onSearchRecipe()
                    }
                    softKeyController?.hideSoftwareKeyboard()
                }
            })
    }

    @Composable
    private fun CategoryChipList() {
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(getAllFoodCategories()) { index, foodCategory ->
                /*Text(text = foodCategory.value,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.secondary,
                    modifier = Modifier.padding(8.dp)
                )*/
                CategoryChipsWidget(
                    isSelected = viewModel.selectedCategory.value == foodCategory,
                    foodCategory.value, onChipSelected = {
                        viewModel.apply {
                            onQueryChanged(foodCategory.value)
                            onSearchRecipe()
                        }
                    })
            }
        }
    }
}