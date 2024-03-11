package com.cs4520.assignment4.ui.product_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment4.model.Product
import com.cs4520.assignment4.R
import com.cs4520.assignment4.data.Api
import com.cs4520.assignment4.data.ProductRepository
import com.cs4520.assignment4.databinding.ProductActivityLayoutBinding

class ProductFragmentList : Fragment() {

    private lateinit var binding: ProductActivityLayoutBinding
    private  lateinit var viewModel: ProductListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProductActivityLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ProductListViewModel::class.java]


        val productsAdapter = ProductAdapter(emptyList())
        val recyclerView: RecyclerView = binding.productRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = productsAdapter

        val productListObserver = Observer<List<Product>> { newProductList ->
            viewModel.productList.value = newProductList
        }

        viewModel.productList.observe(viewLifecycleOwner, productListObserver)

        viewModel.isLoading.observe(viewLifecycleOwner, Observer { loaded ->
            if(!loaded) {
                binding.loadingMessage.visibility = View.INVISIBLE
                binding.plProgressBar.visibility = View.INVISIBLE
            }
        })


    }



}