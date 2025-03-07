package fr.eni.ecole.eni_shop.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EniShopTopBar(modifier : Modifier = Modifier){
    TopAppBar(
        title = {
            EniShopTopBarTitle();
        },
    );
}

@Composable
fun EniShopTopBarTitle(modifier : Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "shopping cart icon",
            modifier = Modifier.size(30.dp)
        );
        Spacer(modifier = modifier.width(8.dp));
        Text(
            text = "ENI-Shop",
            color = MaterialTheme.colorScheme.tertiary,
            fontSize = 30.sp
        );
    }
}

@Composable
@Preview
fun Preview(){
    EniShopTopBar();
}