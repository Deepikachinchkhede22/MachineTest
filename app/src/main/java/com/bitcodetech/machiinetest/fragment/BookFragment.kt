package com.bitcodetech.machiinetest.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitcodetech.machiinetest.databinding.BookFragmentBinding
import com.bitcodetech.machiinetest.factory.MyViewModelFactory
import com.bitcodetech.machiinetest.network.BooksApiService
import com.bitcodetech.machiinetest.repository.BooksRepository
import com.bitcodetech.machiinetest.viewmodels.BooksViewModel
import com.bitcodetech.machinetest.adapter.BookAdapter

class BookFragment: Fragment() {
    private lateinit var binding: BookFragmentBinding
    private lateinit var booksAdapter: BookAdapter
    private lateinit var booksViewModel:BooksViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= BookFragmentBinding.inflate(inflater)
        initviews()
        initListeners()
        initViewModels()
        initobserver()
        initAdapter()

        booksViewModel.fetchBooks()
        return binding.root
    }
    private fun initListeners() {
        binding.recyclerbooks.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                        booksViewModel.fetchBooks()

                    }
                }
            })
    }


    private fun initAdapter(){
        booksAdapter = BookAdapter(booksViewModel.books)
        binding.recyclerbooks.adapter = booksAdapter
    }
    @SuppressLint("NotifyDataSetChanged")

    private fun initobserver(){
        booksViewModel.BooksUpdateAvailableLiveData.observe(
            viewLifecycleOwner
        ) {
            if(it) {
                booksAdapter.notifyDataSetChanged()
            }
        }

    }


    private fun initViewModels(){
        booksViewModel=ViewModelProvider(
          this,
        MyViewModelFactory(
            BooksRepository(
                BooksApiService.getInstance()
        )

        )
        ).get(BooksViewModel::class.java)
    }

    private fun initviews(){
     binding.recyclerbooks.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    }

