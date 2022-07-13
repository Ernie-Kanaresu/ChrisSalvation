package com.example.dummydictionary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dummydictionary.data.model.WordViewModel
import com.example.dummydictionary.repository.DictionaryRepository
import com.example.dummydictionary.repository.LoginRepository
import com.example.dummydictionary.ui.login.LoginViewModel

class WordViewModelFactory<R>(private val repository: R) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            return WordViewModel(repository as DictionaryRepository) as T
        }
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository as LoginRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}