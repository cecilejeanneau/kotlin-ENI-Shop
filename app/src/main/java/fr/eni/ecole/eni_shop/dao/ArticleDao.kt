package fr.eni.ecole.eni_shop.dao

import fr.eni.ecole.eni_shop.bo.Article

interface ArticleDao {
    fun findById(id: Long): Article;

    fun findAll(): List<Article>;

    fun insert(article: Article): Long;

    fun insertMultiples(articles : MutableList<Article>): List<Long>
}