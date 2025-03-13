package fr.eni.ecole.eni_shop.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.eni.ecole.eni_shop.bo.Article
import fr.eni.ecole.eni_shop.dao.ArticleDao

@Database(entities = [Article::class], version = 1)
@TypeConverters
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDAO(): ArticleDao;

    //    singleton
    companion object {
        private var INSTANCE: AppDatabase? = null;

        fun getInstance(context: Context): AppDatabase {
            var instance = INSTANCE;

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "NosFavoris.db"
                ).fallbackToDestructiveMigration()
                    .build();
                INSTANCE = instance;
            }
            return instance;
        }
    }

}