package video.nts.nl.componentarch

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private var wordLiveData : LiveData<List<Word>>
    private val repository = WordRespository(application)

    init {
        wordLiveData = repository.getAllWords()!!
    }

    fun getAllWords() : LiveData<List<Word>> = wordLiveData

    fun insertWord(word: Word){
        repository.insertWord(word)
    }


}