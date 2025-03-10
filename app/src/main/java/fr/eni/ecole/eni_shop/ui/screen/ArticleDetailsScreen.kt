package fr.eni.ecole.eni_shop.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import fr.eni.ecole.eni_shop.bo.Article
import fr.eni.ecole.eni_shop.repository.ArticleRepository
import fr.eni.ecole.eni_shop.ui.common.EniShopTopBar
import fr.eni.ecole.eni_shop.utils.toFrenchStringFormat

@Composable
fun ArticleDetailsScreen(modifier : Modifier = Modifier) {
    Scaffold(
        topBar = { EniShopTopBar() }
    ) {
        Column(modifier = Modifier.padding(it)) {
            ArticleDetails(article = ArticleRepository().getArticle(3));
        }
    }
}

@Composable
fun ArticleDetails(article: Article, modifier : Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp),
    ) {
        Text(
            text = article.title,
            style = MaterialTheme.typography.titleLarge,
            fontSize = 30.sp,
            lineHeight = 1.2.em,
            textAlign = TextAlign.Justify,
//            style = TextStyle(
//                fontSize = 30.sp,
//                fontWeight = FontWeight.Medium,
//                    )
        );
        Surface(
            color = Color.LightGray,
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = article.urlImage,
                contentDescription = "the ${article.title} image",
                modifier = Modifier.size(200.dp),
//                contentScale = ContentScale.Crop    ???
            )
        };
        Text(
            text = article.description,
            textAlign = TextAlign.Justify
        );
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Prix: ${article.price} €",
                style = TextStyle(fontSize = 16.sp)
            );
            Text(
                text = "Date de sortie :  ${article.date.toFrenchStringFormat()}",
                style = TextStyle(fontSize = 16.sp)
            );
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            Checkbox(checked = true, onCheckedChange = {});
            Text(text = "Favoris ?");
        }
    }
}

@Composable
@Preview
//@Preview(showBackground = true)
fun Preview(){
    ArticleDetailsScreen();
}