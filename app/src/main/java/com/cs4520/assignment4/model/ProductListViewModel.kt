package com.cs4520.assignment4.model


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cs4520.assignment4.data.Api
import com.cs4520.assignment4.data.Product
import kotlinx.coroutines.launch



class ProductListViewModel: ViewModel() {
    private val apiService = Api.apiService
    val productList = MutableLiveData<List<Product>>()

    fun getAllProducts() {
        viewModelScope.launch {
            val response = apiService.getProducts(1).execute()

            if(response.isSuccessful) {
                productList.value = response.body()
            }
            else {
                //
            }



        }
    }
}