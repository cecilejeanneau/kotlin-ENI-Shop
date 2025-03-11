package fr.eni.ecole.eni_shop.ui.common

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import fr.eni.ecole.eni_shop.bo.Article

@SuppressLint("DefaultLocale")
@Composable
fun ArticleItem(
    modifier : Modifier = Modifier,
    article : Article,
    onClickOnArticle: (Long) -> Unit,
    articleValue: Long = article.id
){
//    or surface or column or whatever
    Card(
        onClick = {
//            onClickOnArticle(articleValue)
            onClickOnArticle(article.id)
        }
    ) {
        Column(
            modifier = Modifier
                .border(2.dp, Color.LightGray, RoundedCornerShape(16.dp))
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .border(2.dp, Color.LightGray, CircleShape)
                    .padding(8.dp)
            ) {
                AsyncImage(
                    model = article.urlImage,
                    contentDescription = "the ${article.title} image",
                    modifier = Modifier.size(200.dp),
                );
            }
            Text(
                text = article.title,
                fontSize = 20.sp,
            );
            Text(text = article.description);
            Text(text = "${String.format("%.2f", article.price)} €");
        }
    }
}