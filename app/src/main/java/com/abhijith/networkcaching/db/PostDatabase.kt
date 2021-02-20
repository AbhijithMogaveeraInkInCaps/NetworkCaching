package com.abhijith.networkcaching.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.abhijith.networkcaching.db.dao.PostDao
import com.abhijith.networkcaching.db.models.Media
import com.abhijith.networkcaching.db.models.PostLD

@Database(
    entities = [PostLD::class, Media::class],
    version = 1
)
abstract class PostDatabase:RoomDatabase() {
    abstract fun getPostDao(): PostDao

    companion object {
        private lateinit var instance: PostDatabase
        private val LOCK = Any()
        operator fun invoke(context: Context): PostDatabase {
            if (!this::instance.isInitialized) {
                synchronized(LOCK) {
                    return if (!this::instance.isInitialized) {
                        createDatabase(context)
                    }else
                        instance
                }
            }
            return instance
        }

        private fun createDatabase(context: Context) =Room.databaseBuilder(
                context.applicationContext,
                PostDatabase::class.java,
                "post_db.db"
            ).build()

    }
}