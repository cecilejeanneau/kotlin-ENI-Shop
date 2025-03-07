package fr.eni.ecole.eni_shop.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.eni.ecole.eni_shop.bo.Article

@Composable
fun ArticleList(
    modifier : Modifier = Modifier,
    articles: List<Article>
){
    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(articles){
                ArticleItem(article = it)
            }
        }
    }
}