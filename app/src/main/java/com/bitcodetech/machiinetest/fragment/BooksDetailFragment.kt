package com.bitcodetech.machinetest.details.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitcodetech.machiinetest.databinding.BooksDetailsFragmentBinding
import com.bitcodetech.machiinetest.models.Book

class BookDetailsFragment : Fragment() {
    private lateinit var binding: BooksDetailsFragmentBinding

    private var book: Book? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BooksDetailsFragmentBinding.inflate(layoutInflater)

        if(arguments != null) {
            book = requireArguments().getSerializable("books") as Book
            binding.book = book
        }

        return binding.root
    }
}
