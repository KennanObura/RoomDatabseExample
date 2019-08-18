package video.nts.nl.componentarch

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Word::class], version = 1) // was arrayOf(Word::class) before converting to kotlin short
abstract class WordRoomDatabase : RoomDatabase() {

    companion object {
        @Volatile lateinit var INSTANCE : WordRoomDatabase

        fun getDatabase(context: Context): WordRoomDatabase? {

            if (INSTANCE == null) {
                synchronized(WordRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        // Create database here
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            WordRoomDatabase::class.java,
                            "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build()
                    }
                }
            }
            return INSTANCE
        }

        private val sRoomDatabaseCallback = object : RoomDatabase.Callback(){

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                PopulateDbAsync(INSTANCE).execute()
            }
        }

    }

    abstract fun wordDao() : WordDao?

    private class PopulateDbAsync internal constructor(db: WordRoomDatabase) : AsyncTask<Void, Void, Void>() {

        private val mDao: WordDao? = db.wordDao()

        override fun doInBackground(vararg params: Void): Void? {
            mDao!!.deleteAll()
            var word = Word("Hello")
            mDao.insert(word)
            word = Word("World")
            mDao.insert(word)
            return null
        }
    }



}