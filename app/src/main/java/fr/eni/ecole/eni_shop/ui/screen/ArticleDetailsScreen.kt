package fr.eni.ecole.eni_shop.ui.screen

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import fr.eni.ecole.eni_shop.bo.Article
import fr.eni.ecole.eni_shop.ui.common.EniShopTopBar
import fr.eni.ecole.eni_shop.utils.toFrenchStringFormat
import fr.eni.ecole.eni_shop.vm.ArticleDetailsViewModel

@Composable
fun ArticleDetailsScreen(
    modifier: Modifier = Modifier,
    articleDetailsViewModel: ArticleDetailsViewModel = viewModel(factory = ArticleDetailsViewModel.Factory),
    articleId: Long,
    navHostController: NavHostController,
    isDarkThemeActivated: Boolean,
    onDarkThemeToggle: (Boolean) -> Unit,
) {
    LaunchedEffect(Unit) {
        articleDetailsViewModel.initArticle(articleId);
    }

    val article by articleDetailsViewModel.article.collectAsState();

    Scaffold(
        topBar = {
            EniShopTopBar(
                navController = navHostController,
                isDarkThemeActivated = isDarkThemeActivated,
                onDarkThemeToggle = onDarkThemeToggle
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            ArticleDetails(
                article = article,
                articleDetailsViewModel = articleDetailsViewModel
            );
        }
    }
}

@Composable
fun ArticleDetails(
    article: Article,
    modifier: Modifier = Modifier,
    articleDetailsViewModel: ArticleDetailsViewModel = viewModel(factory = ArticleDetailsViewModel.Factory)
) {
    val context = LocalContext.current;
    val uri = Uri.parse(
        "https://www.google.fr/search?q=eni+shop+${article.title}"
    );

    val checked by articleDetailsViewModel.checked.collectAsState();

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp),
    ) {
        TextButton(
            onClick = {
                Intent(
                    Intent.ACTION_WEB_SEARCH,
                    uri
                )
            }
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
                modifier = Modifier.clickable {
                    Intent(
                        Intent.ACTION_WEB_SEARCH,
                        Uri.parse(
                            "https://www.google.fr/search?q=eni+shop+${article.title}"
                        )
                    ).also { context.startActivity(it) }
                }
            );
        }
        Surface(
            color = Color.LightGray,
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = article.urlImage,
                contentDescription = "the ${article.title} image",
                modifier = Modifier.size(200.dp),
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
        ) {
            Checkbox(checked = checked, onCheckedChange = {
                articleDetailsViewModel.updateCheck(it);
                val toast = if (checked) "Article enregistré dans vos favoris" else "Article supprimé de vos favoris";
                Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();

//                if (it) {
//                    Toast.makeText(
//                        context,
//                        "Article enregistré dans vos favoris",
//                        Toast.LENGTH_LONG
//                    ).show();
//                } else {
//                    Toast.makeText(
//                        context,
//                        "Article supprimé de vos favoris",
//                        Toast.LENGTH_LONG
//                    ).show();
//                }
            });
            Text(text = "Favoris ?");
        }
    }
}

//@Composable
//@Preview
////@Preview(showBackground = true)
//fun Preview() {
//    val viewModel = ArticleDetailsViewModel();
//    ArticleDetailsScreen(modifier = Modifier, viewModel, 3);
//}