package fr.eni.ecole.eni_shop.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import fr.eni.ecole.eni_shop.ui.common.ArticleList
import fr.eni.ecole.eni_shop.vm.ArticleListViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import fr.eni.ecole.eni_shop.ui.common.ArticleListFAB
import fr.eni.ecole.eni_shop.ui.common.CategoryFilterChip
import fr.eni.ecole.eni_shop.ui.common.EniShopTopBar

@Composable
fun ArticleListScreen(
    modifier: Modifier = Modifier,
    viewModel: ArticleListViewModel = viewModel(factory = ArticleListViewModel.Factory),
    onClickOnArticle: (Long) -> Unit,
    navHostController: NavHostController,
    isDarkThemeActivated: Boolean,
    onDarkThemeToggle: (Boolean) -> Unit,
) {
    val articles by viewModel.articles.collectAsState();

//    categories list
    val categories = viewModel.categories;
    var selectedCategory by rememberSaveable {
        mutableStateOf("")
    }

    val selectedArticles = if (selectedCategory != "") {
        articles.filter {
            it.category == selectedCategory;
        }
    } else {
        articles
    }

    Scaffold(
        topBar = {
            EniShopTopBar(
                navController = navHostController,
                isDarkThemeActivated = isDarkThemeActivated,
                onDarkThemeToggle = onDarkThemeToggle
            );
        },
        floatingActionButton = { ArticleListFAB(navController = navHostController) }

    ) {
        Column(modifier = Modifier.padding(it)) {
            CategoryFilterChip(
                categories = categories,
                selectedCategory = selectedCategory,
                onCategoryChange = {
                    selectedCategory = it
                } //param it given by onCategoryChange callback from children
            );
            ArticleList(
                articles = selectedArticles,
                onClickOnArticle = onClickOnArticle,
            )
        }
    }
}