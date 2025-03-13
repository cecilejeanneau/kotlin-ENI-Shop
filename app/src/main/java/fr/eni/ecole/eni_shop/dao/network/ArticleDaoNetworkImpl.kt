package fr.eni.ecole.eni_shop.dao.network

import fr.eni.ecole.eni_shop.bo.Article
import fr.eni.ecole.eni_shop.dao.ArticleDao

class ArticleDaoNetworkImpl : ArticleDao {
    override fun findById(id: Long): Article {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Article> {
        TODO("Not yet implemented")
    }

    override fun deleteOne(article: Article) {
        TODO("Not yet implemented")
    }

    override fun insert(article: Article): Long {
        TODO("Not yet implemented")
    }

    override fun insertMultiples(articles: MutableList<Article>): List<Long> {
        TODO("Not yet implemented")
    }
}