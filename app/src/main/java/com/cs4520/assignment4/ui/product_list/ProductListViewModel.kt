package com.cs4520.assignment4.ui.product_list



import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cs4520.assignment4.data.Api
import com.cs4520.assignment4.model.Product
import com.cs4520.assignment4.data.ProductRepository
import kotlinx.coroutines.launch



class ProductListViewModel: ViewModel() {

    private val productRepo = ProductRepository(Api.apiService)

    var isLoading = MutableLiveData<Boolean>()

    val productList = MutableLiveData<List<Product>>()


    init {
        fetchProducts()
    }

    private fun fetchProducts() {

        isLoading.value = true
        viewModelScope.launch {
            try {

                productList.value = productRepo.getAllProducts()

            }
            catch(e: Exception) {

                Log.e("ProductLisViewModel", "Error getting Products" ,e)
            }
            finally {
                isLoading.value = false
            }
        }
    }
}