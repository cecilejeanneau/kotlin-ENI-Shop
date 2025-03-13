package fr.eni.ecole.enishop

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import fr.eni.ecole.eni_shop.bo.Article
import fr.eni.ecole.eni_shop.room.AppDatabase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Date

@RunWith(AndroidJUnit4::class)
class ArticleDbTest {
    private lateinit var db : AppDatabase
    private lateinit var articeATester : Article

    @Before
    fun createDb(){
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java).build()

        articeATester = Article(
            0L,
            "Chaussure Blanche",
            "Chaussure blanche d'enfant",
            20.0,
            "image_chaussure",
            "affaire",
            Date()
        )
    }
    @After
    fun closeDb(){
        db.close()
    }

    @Test
    fun testInsert() = runTest {
        val id = db.articleDAO().insert(articeATester)
        assertTrue(id>0)
    }

    @Test
    fun testById() = runTest {
        val id = db.articleDAO().insert(articeATester)
        assertTrue(id>0)

        val foundDB = db.articleDAO().findById(id)
        assertNotNull(foundDB)
        assertNotNull(foundDB.title)
        assertEquals(articeATester.title, foundDB.title)
        assertNotNull(foundDB.description)
        assertEquals(articeATester.description, foundDB.description)
        assertNotNull(foundDB.price)
        assertEquals(articeATester.price, foundDB.price)
        assertNotNull(foundDB.urlImage)
        assertEquals(articeATester.urlImage, foundDB.urlImage)
        assertNotNull(foundDB.date)
        assertEquals(articeATester.date, foundDB.date)
        assertNotNull(foundDB.category)
        assertEquals(articeATester.category, foundDB.category)
    }

    @Test
    fun testDelete() = runTest {
        val id = db.articleDAO().insert(articeATester)
        assertTrue(id>0)

        val articleDB = db.articleDAO().findById(id)
        assertNotNull(articleDB)

        db.articleDAO().deleteOne(articleDB)

        val articleDelete = db.articleDAO().findById(id)
        assertNull(articleDelete)
    }
}