package com.cs4520.assignment4.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment4.data.Product
import com.cs4520.assignment4.R
import com.cs4520.assignment4.databinding.ProductActivityLayoutBinding
import com.cs4520.assignment4.data.productsDataset
import com.cs4520.assignment4.model.ProductListViewModel

class ProductFragmentList : Fragment(R.layout.product_activity_layout) {

    private lateinit var binding: ProductActivityLayoutBinding
    private  lateinit var viewModel: ProductListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductActivityLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[ProductListViewModel::class.java]




        val productsAdapter = ProductAdapter(viewModel.productList.value!!)
        val recyclerView: RecyclerView = binding.productRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = productsAdapter

        val productListObserver = Observer<List<Product>> { newProductList ->
            viewModel.productList.value = newProductList
        }

        viewModel.productList.observe(viewLifecycleOwner, productListObserver)



//        if(dataset.isEmpty()) {
//            val msg = "No products available"
//            binding.plProgressBar.visibility = View.INVISIBLE
//            binding.loadingMessage.text = msg
//        }

    }



}