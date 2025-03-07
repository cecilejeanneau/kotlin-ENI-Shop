package fr.eni.ecole.eni_shop.repository

import fr.eni.ecole.eni_shop.bo.Article
import fr.eni.ecole.eni_shop.dao.ArticleDao
import fr.eni.ecole.eni_shop.dao.DaoFactory
import fr.eni.ecole.eni_shop.dao.DaoType

// singleton same repository for all rqt and so, no parenthesis
object ArticleRepository {
//    no instance of Factory but enable to access to a "static" -> companion object method
//    call different source data and return same thing with structure similar
    private var articleDao: ArticleDao = DaoFactory.createArticleDAO(DaoType.MEMORY);

    fun getArticle(id: Long): Article {
        return articleDao.findById(id);
    }

    fun getAllArticles(): List<Article> {
        return articleDao.findAll();
    }

    fun addArticle(article: Article): Long {
        return articleDao.insert(article);
    }
    fun addArticles(articles: MutableList<Article>): List<Long> {
        return articleDao.insertMultiples(articles);
    }
}