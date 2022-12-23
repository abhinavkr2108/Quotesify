package com.example.quotesify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.quotesify.api.QuoteService
import com.example.quotesify.api.RetrofitConstants
import com.example.quotesify.repository.QuotesRepository
import com.example.quotesify.viewmodels.MainViewModel
import com.example.quotesify.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        val quoteService = RetrofitConstants.getInstance().create(QuoteService::class.java)
        val quotesRepository = QuotesRepository(quoteService)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(quotesRepository)).get(MainViewModel::class.java)


        mainViewModel.quotes.observe(this, Observer {
            Log.d("QUOTES", it.results.toString())
            textView.text = it.results.toString()
        })
    }
}