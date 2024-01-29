package com.bitcodetech.machiinetest.repository

import com.bitcodetech.machiinetest.models.Book
import com.bitcodetech.machiinetest.network.BooksApiService

class BooksRepository(
    private val booksApiService: BooksApiService
) {
    suspend fun fetchBooks():ArrayList<Book>{
        return booksApiService.fetchBooks().books
    }

    }


