@file:OptIn(ExperimentalMaterial3Api::class)

package fr.eni.ecole.eni_shop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import fr.eni.ecole.eni_shop.ui.screen.AddArticleForm
import fr.eni.ecole.eni_shop.ui.screen.AddArticlesScreen
import fr.eni.ecole.eni_shop.ui.screen.ArticleDetailsScreen

//logt enter
private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
//            ArticleDetailsScreen();
//            AddArticleForm();
            AddArticlesScreen();
        }


    }
}

//@Composable
//fun ArticlesList(modifier : Modifier = Modifier) {
////    var article = ArticleRepository.getArticle(1);
//    ArticleRepository.addArticles(
//        mutableListOf(
//            Article(
//                _id = 1,
//                _title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
//                _description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
//                _price = 109.95,
//                _urlImage = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
//                _category = "men's clothing"
//            ),
//            Article(
//                _id = 2,
//                _title= "Mens Casual Premium Slim Fit T-Shirts",
//                _description = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
//                _price = 22.3,
//                _urlImage = "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg",
//                _category = "men's clothing"
//            ),
//            Article(
//                _id = 3,
//                _title = "Mens Cotton Jacket",
//                _description = "great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.",
//                _price = 55.99,
//                _urlImage = "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg",
//                _category = "men's clothing"
//            )
//        )
//    );
//
//    val articles : List<Article> = ArticleRepository.getAllArticles();
////    val articles : List<Article> = List(3){
////        Article(
////            _id = 1,
////            _title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
////            _description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
////            _price = 109.95,
////            _urlImage = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
////            _category = "men's clothing"
////        );
////        Article(
////            _id = 2,
////            _title= "Mens Casual Premium Slim Fit T-Shirts",
////            _description = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
////            _price = 22.3,
////            _urlImage = "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg",
////            _category = "men's clothing"
////        );
////        Article(
////            _id = 3,
////            _title = "Mens Cotton Jacket",
////            _description = "great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.",
////            _price = 55.99,
////            _urlImage = "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg",
////            _category = "men's clothing"
////        );
////    }
//    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
//        items(articles){
//            ArticleDetailsScreen();
//        }
//    }
//
//
////        println(article);
////        ArticleRepository.addArticle(
////            Article(
////                _id = 1,
////                _title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
////                _description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
////                _price = 109.95,
////                _urlImage = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
////                _category = "men's clothing"
////            )
////        );
////        ArticleRepository.addArticle(
////            Article(
////                _id = 2,
////                _title= "Mens Casual Premium Slim Fit T-Shirts",
////                _description = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
////                _price = 22.3,
////                _urlImage = "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg",
////                _category = "men's clothing"
////            ),
////        );
////        ArticleRepository.addArticle(
////            Article(
////                _id = 3,
////                _title = "Mens Cotton Jacket",
////                _description = "great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.",
////                _price = 55.99,
////                _urlImage = "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg",
////                _category = "men's clothing"
////            )
////        );
//
////        logi enter
////    Log.i(TAG, article.toString());
////    article = ArticleRepository.getArticle(2);
////    Log.i(TAG, article.toString())
//}
