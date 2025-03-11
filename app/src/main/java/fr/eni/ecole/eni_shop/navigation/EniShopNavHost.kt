package fr.eni.ecole.eni_shop.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import fr.eni.ecole.eni_shop.ui.screen.ArticleDetailsScreen
import fr.eni.ecole.eni_shop.ui.screen.ArticleListScreen

@Composable
fun EniShopNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
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
                    navHostController.navigate("${ArticleDestination.route}/$it");
                }
            );
        };
        composable(

        ) {
            ArticleDetailsScreen(articleId = )
        }
    }
}