package com.bitcodetech.machiinetest.network

import com.bitcodetech.machiinetest.models.BooksResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface BooksApiService {
    @GET("new")


    suspend fun fetchBooks(): BooksResponse


    companion object {
        private var booksApiService: BooksApiService? = null

        fun getInstance(): BooksApiService {
            if (booksApiService == null) {

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.itbook.store/1.0/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                booksApiService = retrofit.create(BooksApiService::class.java)

            }

            return booksApiService!!
        }
    }
}