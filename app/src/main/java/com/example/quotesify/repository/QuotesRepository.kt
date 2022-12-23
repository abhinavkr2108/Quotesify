package com.example.quotesify.repository

import androidx.lifecycle.MutableLiveData
import com.example.quotesify.api.QuoteService
import com.example.quotesify.models.QuoteList

class QuotesRepository(private val quoteService: QuoteService) {

    private val quotesLiveData = MutableLiveData<QuoteList>()
    val quotes: MutableLiveData<QuoteList>
    get() = quotesLiveData

    suspend fun getQuotes(page: Int){
        val result = quoteService.getQuotes(page)
        if (result?.body() != null){
            quotesLiveData.postValue(result.body())
        }
    }
}