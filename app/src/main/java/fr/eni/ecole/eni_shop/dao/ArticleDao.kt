package fr.eni.ecole.eni_shop.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import fr.eni.ecole.eni_shop.bo.Article

@Dao
interface ArticleDao {
    @Insert
    fun insert(article: Article): Long;

    @Query("SELECT * FROM Article WHERE _id = :id")
    fun findById(id: Long): Article;

    @Query("SELECT * FROM Article")
    fun findAll(): List<Article>;

    @Delete
//    fun deleteOne(id: Long): Unit;
    fun deleteOne(article: Article): Unit;

    @Insert
    fun insertMultiples(articles : MutableList<Article>): List<Long>
}