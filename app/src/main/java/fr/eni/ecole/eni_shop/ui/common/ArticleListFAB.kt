package fr.eni.ecole.eni_shop.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import fr.eni.ecole.eni_shop.navigation.AddArticle

@Composable
fun ArticleListFAB(navController: NavHostController) {
    FloatingActionButton(
        onClick = {
            navController.navigate(AddArticle.route) {
                launchSingleTop = true
            }
        },
        shape = CircleShape
    ) {
        Image(
            imageVector = Icons.Default.Add,
            contentDescription = "Add article",
            modifier = Modifier.size(50.dp)
        )
    }
}