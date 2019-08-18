package video.nts.nl.componentarch

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WordDao {

    @Insert
    fun insert(word: Word)

    @Query("Delete FROM word_table")
    fun deleteAll()

    @Query("SELECT * FROM word_table ORDER BY id ASC")
    fun getWords() : LiveData<List<Word>>
}

