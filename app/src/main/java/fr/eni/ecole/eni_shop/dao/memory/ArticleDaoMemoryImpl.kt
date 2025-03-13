package fr.eni.ecole.eni_shop.dao.memory

import fr.eni.ecole.eni_shop.bo.Article
import fr.eni.ecole.eni_shop.dao.ArticleDao

class ArticleDaoMemoryImpl : ArticleDao {

    val articles: MutableList<Article> = mutableListOf(
// emptyList<>()
        Article(
            _id = 1,
            _title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
            _description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
            _price = 109.95,
            _urlImage = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
            _category = "men's clothing"
        ),
        Article(
            _id = 2,
            _title = "Mens Casual Premium Slim Fit T-Shirts",
            _description = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
            _price = 22.3,
            _urlImage = "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg",
            _category = "men's clothing"
        ),
        Article(
            _id = 3,
            _title = "Mens Cotton Jacket",
            _description = "great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.",
            _price = 55.99,
            _urlImage = "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg",
            _category = "men's clothing"
        ),
        Article(
            _id = 6,
            _title = "stylo",
            _price = 12.35,
            _category = "furniture",
            _urlImage = "www.image.com",
            _description = "il est trop géniaaaal !",
        )
    );

    override fun findById(id: Long): Article {
        return articles.first {
            it.id == id
        };
// renvoie l'élément ou throw exception
// find peut return null, donc penser au nullable si utilisé
    }

    override fun findAll(): List<Article> {
        return articles;
    }

    override fun deleteOne(article: Article) {
        TODO("Not yet implemented")
    }

//    override fun deleteOne(id: Long) {
//        TODO("Not yet implemented")
//    }

    override fun insert(
        article: Article
//immuable car référence objet
// mais attribut muable
    ): Long {
        article.id = articles.size.toLong() + 1;
        articles.add(article);
        return article.id;
    }

    override fun insertMultiples(articles: MutableList<Article>): List<Long> {
        TODO("Not yet implemented")
    }

//    override fun insertMultiples(articles: MutableList<Article>): List<Long> {
//        var articlesId = mutableListOf<Long>();
//
//        for(article in articles) {
//            article.id = articles.size.toLong() + 1;
//            articles.add(article);
//            articlesId.add(article.id)
//        }
//
//        return articlesId;
//    }
}