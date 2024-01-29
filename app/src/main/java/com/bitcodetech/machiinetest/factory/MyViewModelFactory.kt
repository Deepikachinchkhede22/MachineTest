package com.bitcodetech.machiinetest.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.machiinetest.repository.BooksRepository
import com.bitcodetech.machiinetest.viewmodels.BooksViewModel

class MyViewModelFactory (
    private val booksRepository: BooksRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BooksViewModel(booksRepository) as T
    }
}