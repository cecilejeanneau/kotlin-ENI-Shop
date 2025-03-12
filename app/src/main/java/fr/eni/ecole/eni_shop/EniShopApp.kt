package fr.eni.ecole.eni_shop

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import fr.eni.ecole.eni_shop.navigation.EniShopNavHost

@Composable
fun EniShopApp(
    modifier : Modifier = Modifier,
    isDarkThemeActivated: Boolean,
    onDarkThemeToggle: (Boolean) -> Unit,
    ){
    val navHostController: NavHostController = rememberNavController();
    EniShopNavHost(
        modifier,
        navHostController,
        isDarkThemeActivated = isDarkThemeActivated,
        onDarkThemeToggle = onDarkThemeToggle
    );
}