package com.example.quotesify.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesify.repository.QuotesRepository
import com.example.quotesify.models.QuoteList


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val quotesRepository: QuotesRepository): ViewModel() {
    init {
        viewModelScope.launch (Dispatchers.IO){
            quotesRepository.getQuotes(1)
        }
    }

    val quotes: MutableLiveData<QuoteList>
    get() = quotesRepository.quotes
}