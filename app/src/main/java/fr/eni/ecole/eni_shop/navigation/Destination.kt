package fr.eni.ecole.eni_shop.navigation

import androidx.compose.ui.graphics.vector.ImageVector

interface Destination {
    val icon: ImageVector
    val route: String
}