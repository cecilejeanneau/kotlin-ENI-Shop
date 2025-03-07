package fr.eni.ecole.eni_shop.ui.common

import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.eni.ecole.eni_shop.vm.ArticleListViewModel


@Composable
fun CategoryFilterChip(
    modifier : Modifier = Modifier,
//    viewModel : ArticleListViewModel = viewModel(factory = ArticleListViewModel.Factory)
    categories: List<String>,
    selectedCategory: String = "",
//    signature callback = type of his parameter here String
    onCategoryChange: (String) -> Unit = {}
){
//    val categories by viewModel.categories.collectAsState();
//    var selected by remember { mutableStateOf(false) }
//    categories list
//    val categories = viewModel.categories;
//    var selectedCategory by rememberSaveable {
//        mutableStateOf("")
//    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            FilterChip(
//                selected = selected,
                selected = category == selectedCategory,
                onClick = {
                    if (selectedCategory == category) {
                        onCategoryChange("");
                    } else {
                        onCategoryChange(category);
                    }
//                    selected = !selected
                    //                selected = true;
                    //      TODO:      filter list to display only category's items
                },
                label = {
                    Text(text = category)
//                    categories.forEach { category ->
////                        Button(
////                            onClick = {
////                                selected = selected;
////                            },
////                            modifier = Modifier.align(Alignment.CenterHorizontally)
////                        ) {
////                            Text(text = category);
////                        }
//                    }
                },
                leadingIcon = if (selectedCategory == category) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Done icon",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                } else {
                    null
                },
            )
        }

    };
}