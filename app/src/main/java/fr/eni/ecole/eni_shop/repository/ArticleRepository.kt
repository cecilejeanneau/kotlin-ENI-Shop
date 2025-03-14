package fr.eni.ecole.eni_shop.repository

import fr.eni.ecole.eni_shop.bo.Article
import fr.eni.ecole.eni_shop.dao.ArticleDao
import fr.eni.ecole.eni_shop.dao.ArticleServiceAPI
import fr.eni.ecole.eni_shop.dao.DaoFactory
import fr.eni.ecole.eni_shop.dao.DaoType

// singleton same repository for all rqt and so, no parenthesis
class ArticleRepository(
    private val articleDaoRoom: ArticleDao,
    private val articleAPI: ArticleServiceAPI
) {
    //    no instance of Factory but enable to access to a "static" -> companion object method
//    call different source data and return same thing with structure similar
//    private var articleDaoMemory: ArticleDao = DaoFactory.createArticleDAO(DaoType.MEMORY);

    suspend fun getArticle(
        id: Long,
        daoTYpe: DaoType = DaoType.NETWORK
    ): Article {
        return when(daoTYpe){
//            DaoType.MEMORY -> articleDaoMemory.findById(id);
            DaoType.NETWORK -> articleAPI.getArticle(id);
            else -> articleDaoRoom.findById(id);
        }
    }

    suspend fun getAllArticles(
        daoTYpe: DaoType = DaoType.NETWORK
    ): List<Article> {
        return when(daoTYpe){
//            DaoType.MEMORY -> articleDaoMemory.findAll();
            DaoType.NETWORK -> articleAPI.getArticles();
            else -> articleDaoRoom.findAll();
        }
    }

    suspend fun getCategories(): List<String> {
        return articleAPI.getCategories();
    }

    fun addArticle(
        article: Article,
        daoTYpe: DaoType = DaoType.NETWORK
    ): Long {
        return when(daoTYpe){
//            DaoType.MEMORY -> articleDaoMemory.insert(article);
//            DaoType.NETWORK -> TODO()
            else -> articleDaoRoom.insert(article);
        }
    }

    fun addArticles(
        articles: MutableList<Article>,
        daoTYpe: DaoType = DaoType.NETWORK
    ): List<Long> {
        return when(daoTYpe){
//            DaoType.MEMORY -> articleDaoMemory.insertMultiples(articles);
//            DaoType.NETWORK -> TODO()
            else -> articleDaoRoom.insertMultiples(articles);
        }
    }

    fun deleteArticle(
        article: Article,
        daoTYpe: DaoType = DaoType.NETWORK
    ): Unit {
        return when(daoTYpe){
//            DaoType.MEMORY -> articleDaoMemory.deleteOne(article);
//            DaoType.NETWORK -> TODO()
            else -> articleDaoRoom.deleteOne(article);
        }
    }
}