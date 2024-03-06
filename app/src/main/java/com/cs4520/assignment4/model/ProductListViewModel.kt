package com.cs4520.assignment4.model


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cs4520.assignment4.data.Api
import com.cs4520.assignment4.data.Product
import com.cs4520.assignment4.data.ProductRepository
import kotlinx.coroutines.launch



class ProductListViewModel: ViewModel() {
    private val productRepo = ProductRepository()
    val productList = MutableLiveData<List<Product>>()
//    val productList : LiveData<List<Product>> get() = _productList


    init {
        viewModelScope.launch {
            try {
                productList.value = productRepo.getAllProducts()

            }
            catch(e: Exception) {
                Log.w("myApp", "Products Not Loaded")
            }
        }
    }
}