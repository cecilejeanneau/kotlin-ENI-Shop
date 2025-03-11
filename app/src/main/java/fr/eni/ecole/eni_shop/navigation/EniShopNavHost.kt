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
import fr.eni.ecole.eni_shop.ui.screen.ArticleDetailsScreen
import fr.eni.ecole.eni_shop.ui.screen.ArticleListScreen

@Composable
fun EniShopNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    var articleValue by rememberSaveable {
        mutableLongStateOf(0)
    }

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
//                    articleValue = it;
                },
//                articleValue = articleValue
                navHostController = navHostController
            );
        };
        composable(
            ArticleDestination.routeWithArgs, arguments = ArticleDestination.args
        ) {
            val articleId = it.arguments?.getLong(ArticleDestination.articleDetailArd)?:0;
            ArticleDetailsScreen(articleId = articleId, navController = navController)
        };
        composable(
            route = AddArticle.route
        ) {
            AddArticleForm(navHostController = navHostController);
        };
    }
}