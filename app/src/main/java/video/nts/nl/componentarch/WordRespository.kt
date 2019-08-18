package video.nts.nl.componentarch

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.os.AsyncTask
import androidx.room.RoomDatabase
import android.os.AsyncTask.execute
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.annotation.NonNull
import video.nts.nl.componentarch.WordRoomDatabase.Companion.INSTANCE


class WordRespository(application: Application) {

    private var wordDao : WordDao?

    private var wordLiveData : LiveData<List<Word>>?

    init {
        val database = WordRoomDatabase.getDatabase(application)
        wordDao = database?.wordDao()
        wordLiveData = wordDao?.getWords()
    }


    fun getAllWords() : LiveData<List<Word>>? = wordLiveData

    fun insertWord(word: Word) {
        val insertAsyncTask = InsertAsyncTask(wordDao)
        insertAsyncTask.execute(word)
    }

    private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: WordDao?) :
        AsyncTask<Word, Void, Void>() {

        override fun doInBackground(vararg params: Word): Void? {
            mAsyncTaskDao?.insert(params[0])
            return null
        }
    }

}