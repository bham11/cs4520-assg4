package com.cs4520.assignment4.ui.product_list



import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cs4520.assignment4.data.Api
import com.cs4520.assignment4.model.Product
import com.cs4520.assignment4.data.ProductRepository
import com.cs4520.assignment4.model.isValidProduct
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ProductListViewModel(): ViewModel() {

    private val productRepo = ProductRepository()

    private var isLoaded = MutableLiveData<Boolean>().apply { value = false }

    private val productList = MutableLiveData<List<Product>>()

    private val errorMsg = MutableLiveData<String>()


    fun fetchProducts() {


        viewModelScope.launch {
            try {

               val products = withContext(Dispatchers.IO) {
                    productRepo.getAllProducts()
                }

                productList.value = filterValidProducts(products)

            }
            catch(e: Exception) {

                Log.e("ProductLisViewModel", "Error getting Products" ,e)
                errorMsg.value = e.toString()
            }
            finally {
                isLoaded.value = true
            }
        }
    }

    fun getProductList(): LiveData<List<Product>> {
        return productList

    }

    fun getIsLoading(): LiveData<Boolean> {
        return isLoaded
    }

    fun getErrorMessage(): LiveData<String> {
        return errorMsg
    }

    private fun filterValidProducts(productList: List<Product>): List<Product> {
        val productListCopy = productList.toList()
        productListCopy.filter { it.isValidProduct() }
        productListCopy.toSet()
        return productListCopy.toList()




    }
}