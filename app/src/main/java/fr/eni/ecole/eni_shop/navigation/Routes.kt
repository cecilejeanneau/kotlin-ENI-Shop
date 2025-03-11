package fr.eni.ecole.eni_shop.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

object ArticleDestination : Destination {
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
    override val route: String = "ArticleList";
}