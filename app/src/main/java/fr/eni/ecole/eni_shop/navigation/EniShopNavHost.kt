package fr.eni.ecole.eni_shop.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import fr.eni.ecole.eni_shop.ui.screen.AddArticleForm
import fr.eni.ecole.eni_shop.ui.screen.AddArticlesScreen
import fr.eni.ecole.eni_shop.ui.screen.ArticleDetailsScreen
import fr.eni.ecole.eni_shop.ui.screen.ArticleListScreen

@Composable
fun EniShopNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    isDarkThemeActivated: Boolean,
    onDarkThemeToggle: (Boolean) -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = ArticleListDestination.route
    ) {
        composable(
            ArticleListDestination.route
        ) {
            ArticleListScreen(
                onClickOnArticle = {
                    navHostController.navigate("${ArticleDetails.route}/$it");
                },
                navHostController = navHostController,
                isDarkThemeActivated = isDarkThemeActivated,
                onDarkThemeToggle = onDarkThemeToggle
            );
        };
        composable(
            ArticleDetails.routeWithArgs, arguments = ArticleDetails.arguments
        ) {
            val articleId = it.arguments?.getLong(ArticleDetails.articleDetailArg)?:0;
            ArticleDetailsScreen(
                articleId = articleId,
                navHostController = navHostController,
                isDarkThemeActivated = isDarkThemeActivated,
                onDarkThemeToggle = onDarkThemeToggle
            );
        };
        composable(
            route = AddArticle.route
        ) {
            AddArticlesScreen(
                navHostController = navHostController,
                isDarkThemeActivated = isDarkThemeActivated,
                onDarkThemeToggle = onDarkThemeToggle
            );
        };
    }
}