package fr.eni.ecole.eni_shop.repository

import fr.eni.ecole.eni_shop.bo.Article
import fr.eni.ecole.eni_shop.dao.ArticleDao
import fr.eni.ecole.eni_shop.dao.DaoFactory
import fr.eni.ecole.eni_shop.dao.DaoType

// singleton same repository for all rqt and so, no parenthesis
class ArticleRepository(
    private val articleDaoRoom: ArticleDao
) {
    //    no instance of Factory but enable to access to a "static" -> companion object method
//    call different source data and return same thing with structure similar
    private var articleDaoMemory: ArticleDao = DaoFactory.createArticleDAO(DaoType.MEMORY);

    fun getArticle(
        id: Long,
        daoTYpe: DaoType = DaoType.MEMORY
    ): Article {
        return when(daoTYpe){
            DaoType.MEMORY -> articleDaoMemory.findById(id);
            else -> articleDaoRoom.findById(id);
        }
    }

    fun getAllArticles(
        daoTYpe: DaoType = DaoType.MEMORY
    ): List<Article> {
        return when(daoTYpe){
            DaoType.MEMORY -> articleDaoMemory.findAll();
            else -> articleDaoRoom.findAll();
        }
    }

    fun addArticle(
        article: Article,
        daoTYpe: DaoType = DaoType.MEMORY
    ): Long {
        return when(daoTYpe){
            DaoType.MEMORY -> articleDaoMemory.insert(article);
            else -> articleDaoRoom.insert(article);
        }
    }

    fun addArticles(
        articles: MutableList<Article>,
        daoTYpe: DaoType = DaoType.MEMORY
    ): List<Long> {
        return when(daoTYpe){
            DaoType.MEMORY -> articleDaoMemory.insertMultiples(articles);
            else -> articleDaoRoom.insertMultiples(articles);
        }
    }

    fun deleteArticle(
        article: Article,
        daoTYpe: DaoType = DaoType.MEMORY
    ): Unit {
        return when(daoTYpe){
            DaoType.MEMORY -> articleDaoMemory.deleteOne(article);
            else -> articleDaoRoom.deleteOne(article);
        }
    }
}