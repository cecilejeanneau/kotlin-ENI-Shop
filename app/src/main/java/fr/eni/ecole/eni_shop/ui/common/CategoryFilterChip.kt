package fr.eni.ecole.eni_shop.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CategoryFilterChip(
    modifier: Modifier = Modifier,
    categories: List<String>,
    selectedCategory: String = "",
//    signature callback = type of his parameter here String
//    viewModel with collectAsState and rememberSaveable in parent : ArticleListScreen
    onCategoryChange: (String) -> Unit = {}
) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            FilterChip(
                selected = category == selectedCategory,
                onClick = {
                    if (selectedCategory == category) {
                        onCategoryChange("");
                    } else {
                        onCategoryChange(category);
                    }
                    //      TODO:      filter list to display only category's items
                },
                label = {
                    Text(text = category)
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