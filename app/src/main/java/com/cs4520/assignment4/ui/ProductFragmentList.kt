package com.cs4520.assignment4.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment4.data.Product
import com.cs4520.assignment4.R
import com.cs4520.assignment4.databinding.ProductActivityLayoutBinding
import com.cs4520.assignment4.data.productsDataset

class ProductFragmentList : Fragment(R.layout.product_activity_layout) {

    private lateinit var binding: ProductActivityLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductActivityLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun buildProductsList(entries: List<List<Any?>>): ArrayList<Product> {
        val finalArray = arrayListOf<Product>()

        for (list in entries) {
                val setPrice = list[3]
                val product = Product(
                    name = list[0].toString(),
                    type= list[1].toString(),
                    expDate = list[2]?.toString(),
                    price = "$$setPrice"
                )
                finalArray.add(product)
            }

        return finalArray

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataset = this.buildProductsList(productsDataset)

        val productsAdapter = ProductAdapter(dataset)
        val recyclerView: RecyclerView = binding.productRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = productsAdapter

    }



}