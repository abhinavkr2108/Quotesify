package com.example.quotesify.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quotesify.repository.QuotesRepository

class MainViewModelFactory(private val quotesRepository: QuotesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(quotesRepository) as T
    }
}