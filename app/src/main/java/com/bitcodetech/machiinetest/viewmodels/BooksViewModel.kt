package com.bitcodetech.machiinetest.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitcodetech.machiinetest.models.Book
import com.bitcodetech.machiinetest.repository.BooksRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BooksViewModel ( private val booksRepository: BooksRepository
    ) : ViewModel() {
        val BooksUpdateAvailableLiveData = MutableLiveData<Boolean>()
        val books = ArrayList<Book>()


        fun fetchBooks() {
            CoroutineScope(Dispatchers.IO).launch {
                val books :ArrayList<Book> = booksRepository.fetchBooks()

                withContext(Dispatchers.Main) {
                    this@BooksViewModel.books.addAll(books)
                    BooksUpdateAvailableLiveData.postValue(true)
                }
            }
        }



            }

