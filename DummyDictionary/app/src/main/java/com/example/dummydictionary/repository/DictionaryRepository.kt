package com.example.dummydictionary.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dummydictionary.data.DummyDictionaryDatabase
import com.example.dummydictionary.data.dao.AntonymDao
import com.example.dummydictionary.data.dao.SynonymDao
import com.example.dummydictionary.data.dao.WordDao
import com.example.dummydictionary.data.model.Word
import com.example.dummydictionary.network.ApiResponse
import com.example.dummydictionary.network.WordService
import retrofit2.HttpException
import java.io.IOException

class DictionaryRepository(
    database: DummyDictionaryDatabase,
    private  val api: WordService,
) {
    private val wordDoa = database.wordDao()

    suspend fun getAllWords() : ApiResponse<LiveData<List<Word>>> {
        return try {
            val response = api.getAllWord()
            if (response.count > 0) {
                wordDoa.insertWord(response.words)
            }
            ApiResponse.Success(data = wordDoa.getAllWords())
        } catch (e: HttpException) {
            ApiResponse.Error(exception = e)
        } catch (e: IOException) {
            ApiResponse.Error(exception = e)
        }
    }

    suspend fun addWord(word: Word) {
        wordDoa.insertWord(word)
    }
}