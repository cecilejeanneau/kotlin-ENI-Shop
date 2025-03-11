package fr.eni.ecole.eni_shop.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument

object ArticleDestination : Destination {
    override val icon: ImageVector
        get() = Icons.Default.ArrowBack
    override val route: String = "Article";

    val argName by lazy{
        "articleValue"
    };

    val args = listOf(navArgument(argName){
        type = NavType.LongType
    });

    val routeWithArgs = "$route/{$argName}";
}

object ArticleListDestination : Destination {
    override val icon: ImageVector
        get() = Icons.Default.Home;
    override val route: String = "article_list";
}

object AddArticle : Destination {
    override val icon: ImageVector
        get() = Icons.Default.Add;
    override val route: String = "article_add";
}

object ArticleDetails : Destination {
    override val icon: ImageVector
        get() = Icons.Default.Info;
    override val route: String = "article_detail";
    const val articleDetailArg = "article_id";
    val arguments = listOf(navArgument(articleDetailArg))
}